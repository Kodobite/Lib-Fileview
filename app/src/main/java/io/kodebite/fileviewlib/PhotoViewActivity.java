package io.kodebite.fileviewlib;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityPhotoViewBinding;

public class PhotoViewActivity extends AppCompatActivity {

    ActivityPhotoViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhotoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}