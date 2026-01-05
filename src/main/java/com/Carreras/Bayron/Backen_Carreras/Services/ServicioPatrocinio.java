package com.Carreras.Bayron.Backen_Carreras.Services;

import org.springframework.stereotype.Service;
import java.io.*;

@Service
public class ServicioPatrocinio {

    public byte[] convertirWordAPdf(String wordPath) throws Exception {
        // Ruta temporal segura para PDF
        String pdfPath = System.getProperty("java.io.tmpdir") + "/Patrocinio.pdf";

        ProcessBuilder pb = new ProcessBuilder(
                "python3",  // usar python3 en servidores
                "src/main/java/com/Carreras/Bayron/Backen_Carreras/python-scripts/convert_word_to_pdf.py",
                wordPath, pdfPath
        );

        pb.redirectErrorStream(true);
        Process process = pb.start();

        // Leer logs de Python para debug
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("[PYTHON] " + line);
            }
        }

        int exitCode = process.waitFor();
        if (exitCode != 0) {
            throw new RuntimeException("Error al ejecutar Python, código de salida: " + exitCode);
        }

        // Leer PDF generado
        try (FileInputStream fis = new FileInputStream(pdfPath);
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            fis.transferTo(baos);
            return baos.toByteArray();
        }
    }
}
