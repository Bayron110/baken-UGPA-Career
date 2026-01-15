package com.Carreras.Bayron.Backen_Carreras.Controller;

import com.Carreras.Bayron.Backen_Carreras.Entity.Documento;
import com.Carreras.Bayron.Backen_Carreras.Services.DocumentoService;
import com.mongodb.client.gridfs.model.GridFSFile;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.gridfs.GridFsResource;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.http.MediaType;
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

    @Autowired
    private GridFsTemplate gridFsTemplate;

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

    // ✅ Nuevo endpoint para descargar usando fileId
    @GetMapping("/download/{fileId}")
    public ResponseEntity<Resource> downloadDocumento(@PathVariable String fileId) throws IOException {
        GridFSFile file = gridFsTemplate.findOne(new Query(Criteria.where("_id").is(new ObjectId(fileId))));
        if (file == null) {
            return ResponseEntity.notFound().build();
        }

        GridFsResource resource = gridFsTemplate.getResource(file);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(file.getMetadata().getString("_contentType")))
                .body(resource);
    }
}