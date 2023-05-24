package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityMainBinding;
import io.kodebite.fileviewlib.pdf_view.PdfView;
import io.kodebite.fileviewlib.video_view.VideoView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.videoView.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, VideoView.class));
        });


        binding.audioView.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, AudioViewer.class));
        });


        binding.pdfView.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, PdfView.class));

        });


    }
}