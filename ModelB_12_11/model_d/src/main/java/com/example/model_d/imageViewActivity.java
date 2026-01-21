package com.example.model_d;

import android.graphics.Matrix;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class imageViewActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imageView;
    private Matrix matrix = new Matrix();
    private float scale = 1.0f;
    private ScaleGestureDetector ScaleDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ImageView iv_back = findViewById(R.id.back);
        iv_back.setOnClickListener(this);

        imageView = findViewById(R.id.imgView);
        int ResId  = getIntent().getIntExtra("ResID",-1);
        imageView.setImageResource(ResId);
        ScaleDetector = new ScaleGestureDetector(
                this,
                new ScaleGestureDetector.SimpleOnScaleGestureListener() {
                    @Override
                    public boolean onScale(ScaleGestureDetector detector) {
                        float scaleFactor = detector.getScaleFactor();
                        scale *= scaleFactor;
                        scale = Math.max(0.5f, Math.min(scale, 3.0f));
                        matrix.setScale(scale, scale, detector.getFocusX(), detector.getFocusY());
                        imageView.setImageMatrix(matrix);
                        return true;
                    }
                }
        );


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ScaleDetector.onTouchEvent(event);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
        }
    }
}