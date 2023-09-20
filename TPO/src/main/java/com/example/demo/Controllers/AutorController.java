package com.example.demo.Controllers;

import com.example.demo.Models.Autor;
import com.example.demo.Services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/autores")
@RestController
public class AutorController {
    //Hacer CRUD de autor
    //Evitar eliminar autor si tiene libros escritos


    @Autowired
    private AutorService as;
    @GetMapping("")
    public List<Autor> getAll(){
        return as.getAll();
    }

}
