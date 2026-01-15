package com.Carreras.Bayron.Backen_Carreras.Services;
import com.Carreras.Bayron.Backen_Carreras.Entity.Documento;
import com.Carreras.Bayron.Backen_Carreras.Repository.DocumentoRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class DocumentoService {

    @Autowired
    private GridFsTemplate gridFsTemplate;

    @Autowired
    private DocumentoRepository documentoRepository;

    public String saveDocumento(MultipartFile file, String nombre, String descripcion) throws IOException {
        ObjectId fileId = gridFsTemplate.store(file.getInputStream(), file.getOriginalFilename(), file.getContentType());

        Documento documento = new Documento();
        documento.setNombre(nombre);
        documento.setDescripcion(descripcion);
        documento.setFileId(fileId.toString());

        documentoRepository.save(documento);

        return documento.getId();
    }

    public List<Documento> listDocumentos() {
        return documentoRepository.findAll();
    }
}