package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    //Fecha en la que se agregó a la DB
    private Date fechaAgregado;
    //Fecha en la que se publicó el libro
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;
    private String descripcion;
    private String urlPortada;

    //Puede tener uno o más autores
    @ManyToMany(mappedBy = "libros")
    private List<Autor> autores;

    @OneToMany(mappedBy = "libro")
    @JsonManagedReference
    @JsonIgnore
    private List<Upload> uploads;

}
