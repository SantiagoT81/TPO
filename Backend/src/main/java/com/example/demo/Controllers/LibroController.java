package com.example.demo.Controllers;

import com.example.demo.DTO.AutorDTO;
import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import com.example.demo.Services.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/libros")
@RestController
public class LibroController {
    @Autowired
    private LibroService ls;

    @GetMapping("")
    public List<Libro> getAll(){
        return ls.getAll();
    }
    @GetMapping("/{id}")
    public Libro getLibroById(@PathVariable int id){
        return ls.getById(id);
    }
    @GetMapping("/titulo/{title}")
    public Libro getByTitle(@PathVariable String title){
        return ls.getByTitle(title);
    }
    @GetMapping("/autores/{id}")
    public List<AutorDTO> getLibroAutores(@PathVariable Integer id){
        return ls.getAutores(id);
    }
    @PostMapping("/agregar")
    public ResponseEntity add(@RequestBody Libro l){
        return ls.add(l);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity delete(@PathVariable int id){
        return ls.delete(id);
    }

    //Usar  @RequestBody Map<String, String> mapa | en lugar de @RequestBody libro l ?
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Libro l){
        return ls.update(l, id);
    }
}
