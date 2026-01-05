package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Services.ServicioPatrocinio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api/pdf")
public class PatrocinioController {

    @Autowired
    private ServicioPatrocinio servicioPatrocinio;

    @PostMapping("/convertir")
    public ResponseEntity<byte[]> convertirWord(@RequestParam("file") MultipartFile file) {
        try {
            // Guardar temporalmente el Word
            File tempWord = File.createTempFile("patrocinio-", ".docx");
            file.transferTo(tempWord);

            byte[] pdfBytes = servicioPatrocinio.convertirWordAPdf(tempWord.getAbsolutePath());

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Patrocinio.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}