package com.example.user1.firstopencvapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    private final int SELECT_PHOTO = 1;
    static int ACTION_MODE = 0;

    private ImageView ivImage, ivImageProcessed;
    Mat src;

    private BaseLoaderCallback mOpenCVCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case BaseLoaderCallback.SUCCESS:
                    //Add code
                    break;
                default:
                    super.onManagerConnected(status);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivImage = (ImageView) findViewById(R.id.ivImage);
        ivImageProcessed = (ImageView) findViewById(R.id.ivImageProcessed);

        Intent intent = getIntent();

        if (intent.hasExtra("ACTION_MODE"))
            ACTION_MODE = intent.getIntExtra("ACTION_MODE", 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_load_image) {
            Intent photoPickerIntent = new
                    Intent(Intent.ACTION_PICK);
            photoPickerIntent.setType("image/*");
            startActivityForResult(photoPickerIntent,
                    SELECT_PHOTO);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_1_0, this, mOpenCVCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case SELECT_PHOTO:
                if (resultCode == RESULT_OK) {

                    try {
                        //Code to load image into a Bitmap and convert it into a Mat for processing
                        final Uri imageUri = data.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);

                        src = new Mat(selectedImage.getHeight(), selectedImage.getWidth(), CvType.CV_8UC4);
                        Utils.bitmapToMat(selectedImage, src);

                        switch (ACTION_MODE){
                            //Add different cases here depending on the required operation
                            case HomeActivity.MEAN_BLUR:
                                Imgproc.blur(src, src, new Size(3,3));
                                break;

                            case HomeActivity.GAUSSIAN_BLUR:
                                Imgproc.GaussianBlur(src, src, new Size(3,3), 0);
                                break;

                            case HomeActivity.MEDIAN_BLUR:
                                Imgproc.medianBlur(src, src, 3);
                                break;

                            case HomeActivity.SHARPEN:
                                Mat kernelSharpen = new Mat(3, 3, CvType.CV_16SC1);
                                kernelSharpen.put(0, 0, 0, -1, 0, -1, 5, -1, 0, -1, 0);
                                Imgproc.filter2D(src, src, src.depth(), kernelSharpen);
                                break;

                            case HomeActivity.DILATE:
                                Mat kernelDilate = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3,3));
                                Imgproc.dilate(src, src, kernelDilate);
                                break;

                            case HomeActivity.ERODE:
                                Mat kernelErode = Imgproc.getStructuringElement(Imgproc.MORPH_ELLIPSE, new Size(5,5));
                                Imgproc.erode(src, src, kernelErode);
                                break;

                            case HomeActivity.BINARY_THRESHOLD:
                                Imgproc.threshold(src, src, 128, 255, Imgproc.THRESH_BINARY);
                                break;

                            case HomeActivity.BINARY_INV_THRESHOLD:
                                Imgproc.threshold(src, src, 128, 255, Imgproc.THRESH_BINARY_INV);
                                break;

                            case HomeActivity.TRUNC_THRESHOLD:
                                Imgproc.threshold(src, src, 128, 255, Imgproc.THRESH_TRUNC);
                                break;

                            case HomeActivity.TOZERO_THRESHOLD:
                                Imgproc.threshold(src, src, 128, 255, Imgproc.THRESH_TOZERO);
                                break;

                            case HomeActivity.TOZERO_INV_THRESHOLD:
                                Imgproc.threshold(src, src, 128, 255, Imgproc.THRESH_TOZERO_INV);
                                break;

                            case HomeActivity.MEAN_ADAPTIVE_THRESHOLD:
                                Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
                                Imgproc.adaptiveThreshold(src, src, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY, 3, 0);
                                break;

                            case HomeActivity.GAUSSIAN_ADAPTIVE_THRESHOLD:
                                Imgproc.cvtColor(src, src, Imgproc.COLOR_BGR2GRAY);
                                Imgproc.adaptiveThreshold(src, src, 255, Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY, 3, 0);
                                break;
                        }
                        //Code to convert Mat to Bitmap to load in an ImageView. Also load
                        Bitmap processedImage = Bitmap.createBitmap(src.cols(), src.rows(), Bitmap.Config.ARGB_8888);
                        Utils.matToBitmap(src, processedImage);

                        ivImage.setImageBitmap(selectedImage);
                        ivImageProcessed.setImageBitmap(processedImage);
                    }
                    catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }
}
