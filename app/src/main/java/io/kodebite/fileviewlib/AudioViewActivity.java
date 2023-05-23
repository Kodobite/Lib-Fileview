package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityAudioViewBinding;

public class AudioViewActivity extends AppCompatActivity {

    ActivityAudioViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}