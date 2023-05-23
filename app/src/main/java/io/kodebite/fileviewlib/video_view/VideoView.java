package io.kodebite.fileviewlib.video_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import io.kodebite.fileviewer.FileViewer;
import io.kodebite.fileviewlib.databinding.ActivityVideoView2Binding;

public class VideoView extends AppCompatActivity {

    ActivityVideoView2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.videoViewDialog.setOnClickListener(v -> {

            FileViewer.CustomVideoViewerDialog dialog = new FileViewer.CustomVideoViewerDialog(this);
            dialog.setVideoPath("/storage/emulated/0/Download/videoplayback.mp4");
            dialog.setCancelable(false);
            dialog.setVideoTitle(new File("/storage/emulated/0/Download/videoplayback.mp4").getName());
            dialog.setOnCompletionListener(mp -> dialog.dismiss());
            dialog.show();

        });

        binding.videoViewActivity.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, VideoViewActivity.class));
        });


    }
}