package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Services.ServicioPatrocinio;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/pdf")
public class PatrocinioController {

    @Autowired
    private ServicioPatrocinio servicioPatrocinio;

    @PostMapping("/convertir")
    public ResponseEntity<byte[]> convertirWord(@RequestParam("ruta") String rutaWord) {
        try {
            byte[] pdfBytes = servicioPatrocinio.convertirWordAPdf(rutaWord);

            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Patrocinio.pdf")
                    .contentType(MediaType.APPLICATION_PDF)
                    .body(pdfBytes);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}