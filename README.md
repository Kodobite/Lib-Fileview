# Lib-Fileview

##### Dependency

````java
implementation 'com.github.Kodobite:Lib-Fileview:0.2'

````

##### Audio View Dialog

````java

     FileViewer.CustomAudioPlayerDialog dialog = new FileViewer.CustomAudioPlayerDialog(this);
            dialog.setTitle("Title");
            try {
                dialog.setDataSource("//your audio file source");
            } catch (IOException e) {
                e.printStackTrace();
            }
            dialog.setCancelable(false);
            dialog.show();
            
  ````
  
  ##### Audio view Activity
  
  ````xml

  <io.kodebite.fileviewer.audioView.CustomAudioPlayer
        android:id="@+id/audioPlayer"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginStart="10dp"
        android:layout_marginTop="10dp"
        android:layout_marginEnd="10dp"
        android:layout_marginBottom="10dp" />

````

````java

 try {
      audioPlayer.setDataSource("//your audio file source");
      audioPlayer.play();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
````

##### Video View Dialog

````java

     FileViewer.CustomVideoViewerDialog dialog = new FileViewer.CustomVideoViewerDialog(this);
            dialog.setVideoPath("//your video file source");
            dialog.setCancelable(false);
            dialog.setVideoTitle(new File("//your video file source").getName());
            dialog.setOnCompletionListener(mp -> dialog.dismiss());
            dialog.show();
            
  ````
  
   ##### Video view Activity
  
  ````xml

      <FrameLayout
        android:id="@+id/video_layout"
        android:layout_width="fill_parent"
        android:layout_height="200dp"
        android:background="@android:color/black">

        <io.kodebite.fileviewer.videoView.CustomVideoView
            android:id="@+id/videoView"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            android:layout_gravity="center"
            app:videoview_autoRotation="true"
            app:videoview_fitXY="false" />

        <io.kodebite.fileviewer.videoView.VideoMediaController
            android:id="@+id/media_controller"
            android:layout_width="fill_parent"
            android:layout_height="fill_parent"
            app:videoview_scalable="true" />

    </FrameLayout>


````

````java

 setVideoAreaSize();

        new Handler().postDelayed(() -> {
            videoView.start();
            File file = new File(videoPath);
            mediaController.setTitle(file.getName() + "");
        }, 1000);

        videoView.setMediaController(binding.mediaController);

        videoView.setVideoViewCallback(new CustomVideoView.VideoViewCallback() {
            @Override
            public void onScaleChange(boolean isFullscreen) {

                VideoViewActivity.this.isFullscreen = isFullscreen;
                if (isFullscreen) {
                    android.view.ViewGroup.LayoutParams layoutParams = binding.videoLayout.getLayoutParams();
                    layoutParams.width = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    videoLayout.setLayoutParams(layoutParams);
                    //GONE the unconcerned views to leave room for video and controller
                    bottomLayout.setVisibility(android.view.View.GONE);

                } else {
                    android.view.ViewGroup.LayoutParams layoutParams = binding.videoLayout.getLayoutParams();
                    layoutParams.width = android.view.ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = cachedHeight;
                    videoLayout.setLayoutParams(layoutParams);
                    //VISIBLE the unconcerned views
                    bottomLayout.setVisibility(android.view.View.VISIBLE);
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
        videoLayout.post(new Runnable() {
            @Override
            public void run() {
                int width = binding.videoLayout.getWidth();
                cachedHeight = (int) (width * 405f / 720f);

                ViewGroup.LayoutParams videoLayoutParams = binding.videoLayout.getLayoutParams();
                videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                videoLayoutParams.height = cachedHeight;
                videoLayout.setLayoutParams(videoLayoutParams);
                videoView.setVideoPath(videoPath);
                videoView.requestFocus();
            }
        });
    }
        
````

##### PDF View Dialog

````java

      FileViewer.CustomPDFViewerDialog dialog = new FileViewer.CustomPDFViewerDialog(this);
            dialog.setPdfTitle("Title");
            dialog.setUpPdf(new File("//your pdf file source"), true, true, 0);
            dialog.show();
            
  ````
  
   ##### PDF view Activity
  
  ````xml

   <io.kodebite.fileviewer.pdfView.PDFView
        android:id="@+id/pdfView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_margin="10dp" />

````

````java

pdfView.fromFile(new File("// your pdf file source"))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .defaultPage(0)
                .load();

        Objects.requireNonNull(getSupportActionBar()).setTitle("Test PDF");
        
````
            
            
