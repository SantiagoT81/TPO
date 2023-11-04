package com.example.demo.DTO;

import com.example.demo.Models.Libro;
import com.example.demo.Models.Usuario;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UploadDTO {
    @Id
    private Integer id;
    private Date fechaCreacion;
    private Integer rate;
    private String descripcion;
    private String titulo;
    //
    private Libro l;
    private UsuarioDTO u;
}
