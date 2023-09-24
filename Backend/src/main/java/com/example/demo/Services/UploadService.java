package com.example.demo.Services;

import com.example.demo.Models.Upload;
import com.example.demo.Repositories.UploadRepository;
import org.apache.coyote.Response;
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
    private UploadRepository ur;
    private final ModelMapper mm = new ModelMapper();
    public UploadService(UploadRepository ur){
        this.ur = ur;
    }

    public List<Upload> getAll(){
        return ur.findAll();
    }
    public Upload getById(Integer id){
        return ur.findById(id).orElse(null);
    }

    public ResponseEntity add(Upload u){
        try{
            u.setFechaCreacion(new Date());
            ur.save(u);
            return ResponseEntity.status(CREATED).body(u);
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("No se pudo crear la publicación");
        }
    }

    public ResponseEntity delete(Integer id){
        try{
            Upload u = ur.findById(id).orElse(null);
            if(u != null){
                ur.delete(u);
                return ResponseEntity.status(OK).body("Publicación eliminada exitosamente");
            }
            return ResponseEntity.status(CONFLICT).body("Publicación no encontrada");
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al eliminar la publicación");
        }
    }
}
