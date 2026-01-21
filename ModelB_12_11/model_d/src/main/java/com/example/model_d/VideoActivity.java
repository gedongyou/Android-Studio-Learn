package com.example.model_d;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

public class VideoActivity extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);


        videoView = findViewById(R.id.videoView);

        int videoID = getIntent().getIntExtra("ResID", -1);

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + videoID);
        videoView.setVideoURI(uri);
        MediaController controller = new MediaController(this);
        videoView.setMediaController(controller);
        videoView.start();


        videoView.setOnCompletionListener(mp -> {
            finish();
        });
        ImageView iv_back = findViewById(R.id.back);
        iv_back.setOnClickListener(v -> {
            finish();
        });
    }
}
