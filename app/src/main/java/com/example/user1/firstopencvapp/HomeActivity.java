package com.example.user1.firstopencvapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    static final int MEAN_BLUR = 1;
    static final int GAUSSIAN_BLUR = 2;
    static final int MEDIAN_BLUR = 3;
    static final int SHARPEN = 4;
    static final int DILATE = 5;
    static final int ERODE = 6;
    static final int BINARY_THRESHOLD = 7;
    static final int BINARY_INV_THRESHOLD = 8;
    static final int TRUNC_THRESHOLD = 9;
    static final int TOZERO_THRESHOLD = 10;
    static final int TOZERO_INV_THRESHOLD = 11;
    static final int MEAN_ADAPTIVE_THRESHOLD = 12;
    static final int GAUSSIAN_ADAPTIVE_THRESHOLD = 13;

    Button bMean, bGaussian, bMedian, bSharpen, bDilate, bErode, bBinaryThreshold, bBinaryInvThreshold, bTruncThreshold, bToZeroThreshold, bToZeroInvThreshold, bMeanAdaptiveThreshold, bGaussianAdaptiveThreshold;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        bMean = (Button) findViewById(R.id.bMean);
        bGaussian = (Button) findViewById(R.id.bGaussian);
        bMedian = (Button) findViewById(R.id.bMedian);
        bSharpen = (Button) findViewById(R.id.bSharpen);
        bDilate = (Button) findViewById(R.id.bDilate);
        bErode = (Button) findViewById(R.id.bErode);
        bBinaryThreshold = (Button) findViewById(R.id.bBinaryThreshold);
        bBinaryInvThreshold = (Button) findViewById(R.id.bBinaryInvThreshold);
        bTruncThreshold = (Button) findViewById(R.id.bTruncThreshold);
        bToZeroThreshold = (Button) findViewById(R.id.bToZeroThreshold);
        bToZeroInvThreshold = (Button) findViewById(R.id.bToZeroInvThreshold);
        bMeanAdaptiveThreshold = (Button) findViewById(R.id.bMeanAdaptiveThreshold);
        bGaussianAdaptiveThreshold = (Button) findViewById(R.id.bGaussianAdaptiveThreshold);

        bMean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", MEAN_BLUR);
                startActivity(intent);
            }
        });

        bGaussian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", GAUSSIAN_BLUR);
                startActivity(intent);
            }
        });

        bMedian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", MEDIAN_BLUR);
                startActivity(intent);
            }
        });

        bSharpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", SHARPEN);
                startActivity(intent);
            }
        });

        bDilate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", DILATE);
                startActivity(intent);
            }
        });

        bErode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", ERODE);
                startActivity(intent);
            }
        });

        bBinaryThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", BINARY_THRESHOLD);
                startActivity(intent);
            }
        });

        bBinaryInvThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", BINARY_INV_THRESHOLD);
                startActivity(intent);
            }
        });

        bTruncThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", TRUNC_THRESHOLD);
                startActivity(intent);
            }
        });

        bToZeroThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", TOZERO_THRESHOLD);
                startActivity(intent);
            }
        });

        bToZeroInvThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", TOZERO_INV_THRESHOLD);
                startActivity(intent);
            }
        });

        bMeanAdaptiveThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", MEAN_ADAPTIVE_THRESHOLD);
                startActivity(intent);
            }
        });

        bGaussianAdaptiveThreshold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra("ACTION_MODE", GAUSSIAN_ADAPTIVE_THRESHOLD);
                startActivity(intent);
            }
        });
    }
}
