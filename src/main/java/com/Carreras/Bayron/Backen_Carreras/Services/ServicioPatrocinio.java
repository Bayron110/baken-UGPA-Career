package com.Carreras.Bayron.Backen_Carreras.Services;

import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ServicioPatrocinio {

    public byte[] convertirWordAPdf(String wordPath) throws Exception {
        String pdfPath = "Patrocinio.pdf"; // puedes usar una ruta temporal si prefieres

        ProcessBuilder pb = new ProcessBuilder(
                "python", "python-scripts/convert_word_to_pdf.py",
                wordPath, pdfPath
        );
        pb.redirectErrorStream(true);
        Process process = pb.start();
        process.waitFor();

        try (FileInputStream fis = new FileInputStream(pdfPath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            fis.transferTo(baos);
            return baos.toByteArray();
        }
    }
}