package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private Date fechaAgregado;
    private String descripcion;

    //Puede tener uno o más autores
    @ManyToMany(mappedBy = "libros")
    @JsonIgnore
    private List<Autor> autores;
    @OneToMany(mappedBy = "libro")
    private List<Upload> uploads;

}
