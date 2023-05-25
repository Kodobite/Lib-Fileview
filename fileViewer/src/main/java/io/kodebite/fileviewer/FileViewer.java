package io.kodebite.fileviewer;

import android.app.Activity;
import android.app.Dialog;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import io.kodebite.fileviewer.audioView.CustomAudioPlayer;
import io.kodebite.fileviewer.pdfView.PDFView;
import io.kodebite.fileviewer.videoView.CustomVideoView;
import io.kodebite.fileviewer.videoView.VideoMediaController;

public class FileViewer {


    public static class CustomVideoViewerDialog {

        Activity activity;
        Dialog dialog;
        CustomVideoView customVideoView;
        VideoMediaController videoMediaController;
        FrameLayout videoLayout;
        ImageView closeIcon;

        public CustomVideoViewerDialog(Activity activity) {
            this.activity = activity;
            dialog = new Dialog(activity);

            init();
        }

        public void init() {
            dialog.setContentView(R.layout.custom_video_viewer_dialog_layout);
            dialog.setCancelable(false);

            customVideoView = dialog.findViewById(R.id.videoView);
            videoMediaController = dialog.findViewById(R.id.media_controller);
            videoLayout = dialog.findViewById(R.id.video_layout);

            customVideoView.setMediaController(videoMediaController);

            customVideoView.setVideoViewCallback(new CustomVideoView.VideoViewCallback() {
                @Override
                public void onScaleChange(boolean isFullscreen) {
                    Log.e("TAG", "onScaleChange: " + "isFullscreen: " + isFullscreen);
                }

                @Override
                public void onPause(MediaPlayer mediaPlayer) {
                    Log.e("TAG", "onPause: ");
                }

                @Override
                public void onStart(MediaPlayer mediaPlayer) {
                    Log.e("TAG", "onStart: ");
                }

                @Override
                public void onBufferingStart(MediaPlayer mediaPlayer) {
                    Log.e("TAG", "onBufferingStart: ");
                }

                @Override
                public void onBufferingEnd(MediaPlayer mediaPlayer) {
                    Log.e("TAG", "onBufferingEnd: ");
                }
            });


            closeIcon = dialog.findViewById(R.id.close_icon_video_view);

            closeIcon.setOnClickListener(v -> {
                dialog.dismiss();
            });

        }

        public void setCancelable(boolean cancelable) {
            dialog.setCancelable(cancelable);
        }

        public void setVideoPath(String videoPath) {
            customVideoView.setVideoPath(videoPath);
        }

        public void setVideoUri(Uri videoUri) {
            customVideoView.setVideoURI(videoUri);
        }

        public void setVideoTitle(String videoTitle) {
            videoMediaController.setTitle(videoTitle);
        }

        public void setOnCompletionListener(MediaPlayer.OnCompletionListener onCompletionListener) {
            customVideoView.setOnCompletionListener(onCompletionListener);
        }


        public void show() {
            dialog.show();
            customVideoView.requestFocus();
            customVideoView.start();
        }

        public void dismiss() {
            dialog.dismiss();
        }

    }


    public static class CustomPDFViewerDialog {

        Activity activity;
        Dialog dialog;

        ImageView closeIcon;
        TextView pdfTitle;
        PDFView pdfView;
        private boolean isMethodInvoked = false;


        public CustomPDFViewerDialog(Activity activity) {
            this.activity = activity;
            dialog = new Dialog(activity);

            init();
        }

        public void init() {
            dialog.setContentView(R.layout.custom_pdf_dialog_layout);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            // full screen
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            pdfTitle = dialog.findViewById(R.id.title);
            pdfView = dialog.findViewById(R.id.pdfView);

            closeIcon = dialog.findViewById(R.id.close_icon_video_view);

            closeIcon.setOnClickListener(v -> {
                dialog.dismiss();
            });

        }

        public void setCancelable(boolean cancelable) {
            dialog.setCancelable(cancelable);
        }


        public void setPdfTitle(String title) {
            pdfTitle.setText(title);
        }

        // set uri
        public void setUpPdf(Uri uri, boolean enableSwipe, boolean swipeHorizontal, int defaultPage) {

            if (isMethodInvoked) {
                throw new IllegalStateException("One method is already invoked.");
            }
            isMethodInvoked = true;

            pdfView.fromUri(uri)
                    .enableSwipe(enableSwipe)
                    .swipeHorizontal(!swipeHorizontal)
                    .defaultPage(defaultPage).load();
        }

        // set file
        public void setUpPdf(File file, boolean enableSwipe, boolean swipeHorizontal, int defaultPage) {
            if (isMethodInvoked) {
                throw new IllegalStateException("One method is already invoked.");
            }
            isMethodInvoked = true;

            pdfView.fromFile(file)
                    .enableSwipe(enableSwipe)
                    .swipeHorizontal(!swipeHorizontal)
                    .defaultPage(defaultPage).load();
        }

        // set input stream
        public void setUpPdf(InputStream inputStream, boolean enableSwipe, boolean swipeHorizontal, int defaultPage) {

            if (isMethodInvoked) {
                throw new IllegalStateException("One method is already invoked.");
            }
            isMethodInvoked = true;

            pdfView.fromStream(inputStream)
                    .enableSwipe(enableSwipe)
                    .swipeHorizontal(!swipeHorizontal)
                    .defaultPage(defaultPage).load();
        }


        public void show() {

            dialog.show();


        }

        public void dismiss() {
            dialog.dismiss();
        }

    }

    public static class CustomAudioPlayerDialog {

        Activity activity;
        Dialog dialog;

        ImageView closeIcon;
        TextView audioTitle;
        CustomAudioPlayer customAudioPlayer;
        private boolean isMethodInvoked = false;


        public CustomAudioPlayerDialog(Activity activity) {
            this.activity = activity;
            dialog = new Dialog(activity);

            init();
        }

        private void init() {
            dialog.setContentView(R.layout.custom_audio_player_dialog_layout);
            dialog.setCancelable(false);
            dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
            // full screen
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

            audioTitle = dialog.findViewById(R.id.title);
            customAudioPlayer = dialog.findViewById(R.id.audioPlayer);

            closeIcon = dialog.findViewById(R.id.close_icon_video_view);

            closeIcon.setOnClickListener(v -> {
                dialog.dismiss();
            });

        }

        public void setCancelable(boolean cancelable) {
            dialog.setCancelable(cancelable);
        }


        public void setTitle(String titleString) {
            audioTitle.setText(titleString);
        }

        // set path
        public void setDataSource(String path) throws IOException {

            if (isMethodInvoked) {
                throw new IllegalStateException("One method is already invoked.");
            }
            isMethodInvoked = true;
            customAudioPlayer.setDataSource(path);
        }


        // set uri
        public void setDataSource(Uri uri) throws IOException {

            if (isMethodInvoked) {
                throw new IllegalStateException("One method is already invoked.");
            }
            isMethodInvoked = true;
            customAudioPlayer.setDataSource(uri);
        }


        public void show() {
            dialog.show();
            customAudioPlayer.play();

        }

        public void dismiss() {
            dialog.dismiss();
        }


    }


}
