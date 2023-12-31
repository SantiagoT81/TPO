package com.example.demo.Controllers;

import com.example.demo.DTO.UploadDTO;
import com.example.demo.Models.Libro;
import com.example.demo.Models.Upload;
import com.example.demo.Services.UploadService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("http://localhost:4200")
@RequestMapping("/publicaciones")
@RestController
public class UploadController {
    @Autowired
    UploadService ups;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return ups.getAll();
    }

    //prueba
    @GetMapping("{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {return ups.getByIdSinDTO(id);}
    @PostMapping("/agregar")
    public ResponseEntity<?> add(@RequestBody Upload u){
        return ups.add(u);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        return ups.delete(id);
    }

    @PatchMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Upload u){
        return ups.update(u, id);
    }
}

