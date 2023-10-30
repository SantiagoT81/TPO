package com.example.demo.Controllers;

import com.example.demo.DTO.AutorDTO;
import com.example.demo.DTO.LibroDTO;
import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Services.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/autores")
@RestController
public class AutorController {
    @Autowired
    private AutorService as;
    @GetMapping("")
    public List<Autor> getAll(){
        return as.getAll();
    }

    @GetMapping("/{id}")
    public Autor getAutorById(@PathVariable int id){
        return as.getById(id);
    }
    @GetMapping("/nombre/{nombre}")
    public Autor getByNombre(@PathVariable String nombre){
        return as.getByNombre(nombre);
    }

    @GetMapping("/apellido/{apellido}")
    public Autor getByApellido(@PathVariable String apellido){
        return as.getByApellido(apellido);
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<?> getAutorLibros(@PathVariable Integer id){
        return as.getLibros(id);
    }

    @PostMapping("/agregar")
    public ResponseEntity<?> add(@RequestBody Autor a){
        return as.add(a);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        return as.delete(id);
    }
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Autor a){
        return as.update(a, id);
    }

}
