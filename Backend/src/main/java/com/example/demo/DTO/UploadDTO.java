package com.example.demo.DTO;

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
    private Date fechaCreacion;
    private Integer rate;
    private String descripcion;
    private String urlImagenPublicacion;
}
