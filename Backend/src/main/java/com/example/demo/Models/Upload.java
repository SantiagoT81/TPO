package com.example.demo.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//Publicación hecha por cada usuario sobre un libro, para aplicar el ONE TO MANY.
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Upload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date fechaCreacion;
    //Puntaje de la publicación en cuanto al libro (1-5)
    private Integer rate;
    //Texto de la reseña
    private String descripcion;
    private String urlImagenPublicacion;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;

}
