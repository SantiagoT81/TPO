package com.example.demo.Services;

import com.example.demo.Models.Upload;
import com.example.demo.Repositories.UploadRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Service
public class UploadService {
    @Autowired

    private UploadRepository upr;
    private final ModelMapper mm = new ModelMapper();

    public UploadService(UploadRepository upr){this.upr = upr;}
    public List<Upload> getAll(){return  upr.findAll();}
    public Upload getById(int id){return upr.findById(id).orElse(null);}


    public ResponseEntity add(Upload u){
        u.setFechaCreacion(new Date());
        upr.save(u);
        return ResponseEntity.status(CREATED).body(u);
    }

    public ResponseEntity delete(Integer id){
        try{
            if(upr.findById(id) == null){
                return ResponseEntity.status(NOT_FOUND).body("No se encontro la publicacion a eliminar");
            }
            upr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al eliminar una publicion");
        }
    }

    public ResponseEntity update(Upload u, Integer id){
        try{
            Upload upload = getById(id);
            if(upload != null){
                if(u.getFechaCreacion() != null){
                    upload.setFechaCreacion(u.getFechaCreacion());
                }
                if(u.getRate() != null){
                    upload.setRate(u.getRate());
                }
                if(u.getDescripcion() != null){
                    upload.setDescripcion(u.getDescripcion());
                }
                if(u.getUrlImagenPublicacion() != null){
                    upload.setUrlImagenPublicacion(u.getUrlImagenPublicacion());
                }
                upr.save(upload);
                return ResponseEntity.status(OK).body(upload);
            }
            return ResponseEntity.status(NOT_FOUND).body("No se encontró la publicacion a actualizar");
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al actualizar los datos de la publicacion");
        }
    }



}
