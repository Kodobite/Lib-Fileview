package io.kodebite.fileviewlib;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import io.kodebite.fileviewlib.databinding.ActivityVideoViewBinding;

public class VideoViewActivity extends AppCompatActivity {

    ActivityVideoViewBinding binding;

    String path = Environment.getExternalStorageDirectory().getPath();
    String videoPath = path + "/Download/m.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("VideoViewActivity", "onCreate: " + videoPath);


    }
}