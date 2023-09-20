package com.example.demo.Services;

import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Repositories.AutorRepository;
import com.example.demo.Repositories.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.http.HttpStatus.*;
@Service
public class AutorService {
    @Autowired
    private AutorRepository ar;
    public AutorService(AutorRepository ar){
        this.ar = ar;
    }
    public List<Autor>getAll(){
        return ar.findAll();
    }

}
