package com.example.demo.Controllers;

import com.example.demo.DTO.UsuarioDTO;
import com.example.demo.Models.Usuario;
import com.example.demo.Services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
    @Autowired
    UsuarioService us;

    @GetMapping("")
    public List<UsuarioDTO> getAll(){
        return us.getUsuarios();
    }
    @PostMapping("/agregar")
    public ResponseEntity add(@RequestBody Usuario u){
        return us.add(u);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        return us.delete(id);
    }
    @PatchMapping("/actualizar/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody Usuario u){
        return us.update(u, id);
    }
}
