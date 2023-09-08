package com.example.demo.Controllers;

import com.example.demo.Models.Libro;
import com.example.demo.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/libros")
@RestController
public class LibroController {
    @Autowired
    private LibroService ls;

    @GetMapping("")
    public List<Libro> getAll(){
        return ls.getAll();
    }
    @PostMapping("/agregar")
    public ResponseEntity add(@RequestBody Libro l){
        return ls.add(l);
    }
}
