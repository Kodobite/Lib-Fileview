package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityAudioViewerBinding;

public class AudioViewer extends AppCompatActivity {

    ActivityAudioViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



    }
}