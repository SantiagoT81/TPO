package com.example.demo.Services;

import com.example.demo.DTO.UploadDTO;
import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Models.Libro;
import com.example.demo.Models.Upload;
import com.example.demo.Repositories.LibroRepository;
import com.example.demo.Repositories.UploadRepository;
import com.example.demo.Repositories.UsuarioRepository;
import org.apache.coyote.Response;
import org.hibernate.exception.ConstraintViolationException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class UploadService {
    @Autowired
    private UploadRepository ur;
    @Autowired
    private UsuarioRepository usr;
    @Autowired
    private LibroRepository lr;
    private final ModelMapper mm = new ModelMapper();
    public UploadService(UploadRepository ur){
        this.ur = ur;
    }

    public ResponseEntity<?> getAll(){
        try{
            List<UploadDTO> uploadDTOS = new ArrayList<>();
            List<Upload> uploads = ur.findAll();
            for(Upload u: uploads){
                UploadDTO ud = mm.map(u, UploadDTO.class);
                ud.setU(mm.map(u.getUsuario(), UsuarioDTO.class));
                ud.setL(u.getLibro());
                uploadDTOS.add(ud);

            }
            return ResponseEntity.status(OK).body(uploadDTOS);
            //return ResponseEntity.status(OK).body(ur.findAll());
        }catch (Error e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Ocurrió un error al traer la lista de publicaciones");
        }
    }
    public Upload getById(Integer id){
        return ur.findById(id).orElse(null);
    }
    public ResponseEntity<?> getByIdSinDTO(Integer id){
        return ResponseEntity.status(OK).body(ur.findById(id));
    }

    public ResponseEntity<?> add(Upload u){
        try{
            if(u.getTitulo().isEmpty() || u.getRate() == 0 || u.getDescripcion().isEmpty()){
                return ResponseEntity.status(BAD_REQUEST).build();
            }
            u.setFechaCreacion(new Date());
            //Validar existencia usuario
            //Validar existencia libro

            ur.save(u);
            return ResponseEntity.status(CREATED).body(u);
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }
    }

    public ResponseEntity<?>delete(Integer id){
        try{
            Upload u = ur.findById(id).orElse(null);
            if(u != null){
                ur.delete(u);
                return ResponseEntity.status(OK).build();
            }
            return ResponseEntity.status(CONFLICT).body("Publicación no encontrada");
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al eliminar la publicación");
        }catch (ConstraintViolationException e){
            return ResponseEntity.badRequest().body("El usuario o el libro no existe");
        }
    }

    public ResponseEntity<?> update(Upload u, Integer id){
        try{
            System.out.println(u);
            System.out.println(id);
            Upload upload = getById(id);
            if(upload != null){
                if(u.getDescripcion() != null){
                    upload.setDescripcion(u.getDescripcion());
                }
                if(u.getTitulo() != null){
                    upload.setTitulo(u.getTitulo());
                }
                ur.save(upload);
                return ResponseEntity.status(OK).body(upload);
            }
            return ResponseEntity.status(NOT_FOUND).build();
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }
}
