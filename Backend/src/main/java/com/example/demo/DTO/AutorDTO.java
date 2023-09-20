package com.example.demo.DTO;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private String descripcion;
}
