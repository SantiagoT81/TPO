package com.example.demo.Services;

import com.example.demo.DTO.AutorDTO;
import com.example.demo.DTO.LibroDTO;
import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Repositories.AutorRepository;
import com.example.demo.Repositories.LibroRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Service
public class AutorService {
    @Autowired
    private AutorRepository ar;
    private final ModelMapper mm = new ModelMapper();
    public AutorService(AutorRepository ar){
        this.ar = ar;
    }
    public List<Autor>getAll(){
        return ar.findAll();
    }

    public Autor getByNombre(String nombre){return ar.findByNombre(nombre);}

    public Autor getByApellido(String apellido){return ar.findByApellido(apellido);}

    public Autor getByDescripcion(String Descripcion){return ar.findByDescripcion(Descripcion);}

    public Autor getById(int id){
        return ar.findById(id).orElse(null);
    }


    public Autor getByNombreApellido(String nombre, String apellido){
        return ar.findByNombreApellido(nombre, apellido);
    }
    public ResponseEntity add(Autor a){
        try{
            Autor autorExistente = getByNombreApellido(a.getNombre(), a.getApellido());

            if(autorExistente != null){
                return ResponseEntity.status(CONFLICT).body("autor preexistente");
            }
            ar.save(a);
            return ResponseEntity.status(CREATED).body(a);
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e);
        }
    }

    public ResponseEntity update(Autor a, Integer id){
        try{
            Autor autor = getById(id);
            if(autor != null){
                if(a.getNombre() != null){
                    autor.setNombre(a.getNombre());
                }
                if(a.getApellido() != null){
                    autor.setApellido(a.getApellido());
                }
                if(a.getDescripcion() != null){
                    autor.setDescripcion(a.getDescripcion());
                }
                ar.save(autor);
                return ResponseEntity.status(OK).body(autor);
            }
            return ResponseEntity.status(NOT_FOUND).build();
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).build();
        }

    }


    public ResponseEntity delete(Integer id){
        try{
            ar.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Error e){
            return ResponseEntity.status(NOT_FOUND).body("No se pudo eliminar el libro");
        }
    }

    public List<LibroDTO> getLibros(Integer idAutor){
        List<LibroDTO> libroList = new ArrayList<>();
        Autor autor = getById(idAutor);

        if (autor != null) {
            List<Libro> librosAutor = autor.getLibros();
            for (Libro libro : librosAutor) {
                LibroDTO libroDTO = mm.map(libro, LibroDTO.class);
                libroList.add(libroDTO);
            }
        }
        return libroList;
    }
}