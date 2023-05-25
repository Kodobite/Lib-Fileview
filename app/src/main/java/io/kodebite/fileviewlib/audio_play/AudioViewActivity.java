package io.kodebite.fileviewlib.audio_play;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Objects;

import io.kodebite.fileviewlib.databinding.ActivityAudioViewBinding;

public class AudioViewActivity extends AppCompatActivity {

    ActivityAudioViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAudioViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Objects.requireNonNull(getSupportActionBar()).setTitle("Title");
        try {
            binding.audioPlayer.setDataSource("/storage/emulated/0/Download/TestAudio.m4a");
            binding.audioPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}