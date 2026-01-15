package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Documento;
import com.Carreras.Bayron.Backen_Carreras.Services.DocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/documentos")
public class DocumentosController {

    @Autowired
    private DocumentoService documentoService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadDocumento(@RequestParam("file") MultipartFile file,
                                                  @RequestParam("nombre") String nombre,
                                                  @RequestParam("descripcion") String descripcion) throws IOException {
        String id = documentoService.saveDocumento(file, nombre, descripcion);
        return ResponseEntity.ok("Documento guardado con ID: " + id);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Documento>> listDocumentos() {
        return ResponseEntity.ok(documentoService.listDocumentos());
    }
}
