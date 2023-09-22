package com.example.demo.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    @Id
    private Integer id;
    private String titulo;
    private String descrpicion;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaCreacion;
}
