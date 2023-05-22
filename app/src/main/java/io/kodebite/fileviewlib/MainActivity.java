package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}