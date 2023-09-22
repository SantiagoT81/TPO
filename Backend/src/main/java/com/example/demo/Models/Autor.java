package com.example.demo.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String descripcion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate cumpleanios;
    //Tiene muchos libros
    @ManyToMany
    @JoinTable(
            name = "autor_libro",
            joinColumns = @JoinColumn(name = "id_autor", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_libro", referencedColumnName = "id")
    )
    @JsonIgnore
    private List<Libro> libros;
}
