package io.kodebite.fileviewlib.pdf_view;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

import io.kodebite.fileviewer.FileViewer;
import io.kodebite.fileviewlib.databinding.ActivityPdfViewBinding;

public class PdfView extends AppCompatActivity {

    ActivityPdfViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPdfViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.pdfViewDialog.setOnClickListener(v -> {
            FileViewer.CustomPDFViewerDialog dialog = new FileViewer.CustomPDFViewerDialog(this);
            dialog.setPdfTitle("Title");
            dialog.setUpPdf(new File("/storage/emulated/0/Download/LearnJava.pdf"), true, true, 0);
            dialog.show();
        });

        binding.pdfViewActivity.setOnClickListener(v -> {
            startActivity(new Intent(this, PdfViewerActivity.class));
        });


    }
}