package io.kodebite.fileviewlib.pdf_view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.util.Objects;

import io.kodebite.fileviewlib.databinding.ActivityPdfViewerBinding;

public class PdfViewerActivity extends AppCompatActivity {

    ActivityPdfViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfViewerBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.pdfView.fromFile(new File("/storage/emulated/0/Download/LearnJava.pdf"))
                .enableSwipe(true)
                .swipeHorizontal(false)
                .defaultPage(0)
                .load();

        Objects.requireNonNull(getSupportActionBar()).setTitle("Test PDF");

    }
}