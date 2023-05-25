package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

import io.kodebite.fileviewer.FileViewer;
import io.kodebite.fileviewlib.databinding.ActivityAudioViewerBinding;

public class AudioViewer extends AppCompatActivity {

    ActivityAudioViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.audioPlayDialog.setOnClickListener(v -> {
            FileViewer.CustomAudioPlayerDialog dialog = new FileViewer.CustomAudioPlayerDialog(this);
            dialog.setTitle("Title");
            try {
                dialog.setDataSource("/storage/emulated/0/Download/TestAudio.m4a");
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog.setCancelable(false);
            dialog.show();
        });

        binding.audioPlayActivity.setOnClickListener(v -> {
            startActivity(new android.content.Intent(this, AudioViewActivity.class));
        });


    }
}