package com.example.demo.Services;

import com.example.demo.DTO.AutorDTO;
import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Repositories.AutorRepository;
import com.example.demo.Repositories.LibroRepository;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.*;

@Service
public class LibroService {
    @Autowired
    private LibroRepository lr;
    @Autowired
    private AutorRepository ar;
    private final ModelMapper mm = new ModelMapper();
    public LibroService(LibroRepository lr){
        this.lr = lr;
    }
    public List<Libro> getAll(){
        return lr.findAll();
    }
    public Libro getByTitle(String titulo){
        return lr.findByTitulo(titulo);
    }
    public Libro getById(int id){
        return lr.findById(id).orElse(null);
    }
    public ResponseEntity<?> add(Libro l){
        try{
            Libro libroExistente = getByTitle(l.getTitulo());
            if(libroExistente != null){
                return ResponseEntity.status(CONFLICT).body("Libro preexistente");
            }
            l.setFechaAgregado(new Date());
            lr.save(l);
            return ResponseEntity.status(CREATED).body(l);
        }catch(Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(e);
        }


    }
    public ResponseEntity<?> addAutor(Integer idLibro, Integer idAutor){
        try{
            Autor a = ar.findById(idAutor).orElse(null);
            Libro l = getById(idLibro);
            if(a != null && l != null){
                a.getLibros().add(l);
                l.getAutores().add(a);
                lr.save(l);
                return ResponseEntity.status(OK).body(l);
            }
            return ResponseEntity.status(CONFLICT).body("El autor o el libro no existe");
        }catch (Error e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body("Ocurrió un error al agregar el autor al libro");
        }

    }
    public ResponseEntity<?> update(Libro l, Integer id){
        Libro libro = getById(id);
        if(libro != null){
            if(l.getTitulo() != null){
                libro.setTitulo(l.getTitulo());
            }
            if(l.getDescripcion() != null){
                libro.setDescripcion(l.getDescripcion());
            }
            lr.save(libro);
            return ResponseEntity.status(OK).body(libro);
        }
        return ResponseEntity.status(NOT_FOUND).build();
    }
    public ResponseEntity<?> delete(Integer id){
        try{
            lr.deleteById(id);
            return ResponseEntity.status(OK).build();
        }catch(Error e){
            return ResponseEntity.status(NOT_FOUND).body("No se pudo eliminar el libro");
        }
    }

    public ResponseEntity<?> getAutores(Integer idLibro) {
        try{
            List<AutorDTO> autorList = new ArrayList<>();
            Libro libro = getById(idLibro);

            if (libro != null) {
                List<Autor> autoresLibro = libro.getAutores();
                //Por cada autor del libro buscado
                for (Autor autor : autoresLibro) {
                    //Se mappea el autor a autorDTO
                    AutorDTO autorDTO = mm.map(autor, AutorDTO.class);
                    //Se agrega el DTO a la lista de autores
                    autorList.add(autorDTO);
                }
            }
            return ResponseEntity.status(OK).body(autorList);
        }catch (Error e){
            return ResponseEntity.status(NOT_FOUND).body("No se encontraron autores para este libro");
        }

    }


}
