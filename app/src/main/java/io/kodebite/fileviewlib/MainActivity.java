package io.kodebite.fileviewlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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