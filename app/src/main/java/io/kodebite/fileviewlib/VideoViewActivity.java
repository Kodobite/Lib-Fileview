package io.kodebite.fileviewlib;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.ViewGroup;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import io.kodebite.fileviewer.videoView.CustomVideoView;
import io.kodebite.fileviewlib.databinding.ActivityVideoViewBinding;

public class VideoViewActivity extends AppCompatActivity {

    ActivityVideoViewBinding binding;
    String videoPath = "/storage/emulated/0/Download/m.mp4";
    private int mSeekPosition;
    private int cachedHeight;
    private boolean isFullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVideoViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.e("VideoViewActivity", "onCreate: " + videoPath);

        setVideoAreaSize();

        new Handler().postDelayed(() -> {
            binding.videoView.start();
            File file = new File(videoPath);
            binding.mediaController.setTitle(file.getName() + "");
        }, 1000);

        binding.videoView.setMediaController(binding.mediaController);

        binding.videoView.setVideoViewCallback(new CustomVideoView.VideoViewCallback() {
            @Override
            public void onScaleChange(boolean isFullscreen) {

                VideoViewActivity.this.isFullscreen = isFullscreen;
                if (isFullscreen) {
                    android.view.ViewGroup.LayoutParams layoutParams = binding.videoLayout.getLayoutParams();
                    layoutParams.width = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    binding.videoLayout.setLayoutParams(layoutParams);
                    //GONE the unconcerned views to leave room for video and controller
                    binding.bottomLayout.setVisibility(android.view.View.GONE);

                } else {
                    android.view.ViewGroup.LayoutParams layoutParams = binding.videoLayout.getLayoutParams();
                    layoutParams.width = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = cachedHeight;
                    binding.videoLayout.setLayoutParams(layoutParams);
                    //VISIBLE the unconcerned views
                    binding.bottomLayout.setVisibility(android.view.View.VISIBLE);
                }

                switchTitleBar(!isFullscreen);


            }

            @Override
            public void onPause(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingEnd(MediaPlayer mediaPlayer) {

            }
        });

    }


    private void switchTitleBar(boolean b) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (b) {
                supportActionBar.show();
                Log.e("TAG", "switchTitleBar: " + "show");
            } else {
                supportActionBar.hide();
                Log.e("TAG", "switchTitleBar: " + "hide");
            }
        }
    }


    private void setVideoAreaSize() {
        binding.videoLayout.post(new Runnable() {
            @Override
            public void run() {
                int width = binding.videoLayout.getWidth();
                cachedHeight = (int) (width * 405f / 720f);

                ViewGroup.LayoutParams videoLayoutParams = binding.videoLayout.getLayoutParams();
                videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                videoLayoutParams.height = cachedHeight;
                binding.videoLayout.setLayoutParams(videoLayoutParams);
                binding.videoView.setVideoPath(videoPath);
                binding.videoView.requestFocus();
            }
        });
    }


}