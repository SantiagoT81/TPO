package com.example.demo.Controllers;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Models.Usuario;
import com.example.demo.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService us;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return us.getUsuarios();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        return us.getById(id);
    }
    @PostMapping("/agregar")
    public ResponseEntity<?> add(@RequestBody Usuario u){
        return us.add(u);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return us.delete(id);
    }
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Usuario u){
        return us.update(u, id);
    }

    @GetMapping("/nombre/{username}")
    public ResponseEntity<?> getByUsername(@PathVariable String username){
        return us.findByUsername(username);
    }
}
