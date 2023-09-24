package com.example.demo.Models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "usuario_id")
    @JsonBackReference // Use this on the "many" side (to prevent circular reference)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    @JsonBackReference(value = "upload-libro") // Use this on the "many" side (to prevent circular reference)
    private Libro libro;
}
