package com.example.demo.Services;

import com.example.demo.Models.Libro;
import com.example.demo.Repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Service
public class LibroService {
    @Autowired
    private LibroRepository lr;
    public LibroService(LibroRepository lr){
        this.lr = lr;
    }
    public List<Libro> getAll(){
        return lr.findAll();
    }
    public Libro getByTitle(String titulo){
        return lr.findByTitulo(titulo);
    }
    public ResponseEntity add(Libro l){
        Libro libroExistente = getByTitle(l.getTitulo());
        if(libroExistente != null){
            return ResponseEntity.status(CONFLICT).body("Libro preexistente");
        }
        lr.save(l);
        return ResponseEntity.status(CREATED).build();

    }
    public ResponseEntity update(Libro l, Integer id){
        Libro libro = lr.findById(id).get();
        libro.setStock(l.getStock());
        libro.setPrecio(l.getPrecio());
        libro.setTitulo(l.getTitulo());
        lr.save(libro);
        return ResponseEntity.status(OK).build();
    }
    public ResponseEntity delete(Integer id){
        lr.deleteById(id);
        return ResponseEntity.status(OK).build();
    }


}
