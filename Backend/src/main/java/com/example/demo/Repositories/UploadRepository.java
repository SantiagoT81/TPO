package com.example.demo.Repositories;

import com.example.demo.Models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;


public interface UploadRepository extends JpaRepository<Upload, Integer> {


    @Query("SELECT u FROM Upload u WHERE u.fechaCreacion = :fechaCreacion")
    Upload findByFechaCreacion(@Param("fechaCreacion") Date fechaCreacion);

    @Query("SELECT u FROM Upload u WHERE u.rate = :rate")
    Upload findByRate(@Param("rate") Integer rate);

    @Query("SELECT u FROM Upload u WHERE u.descripcion = :descripcion")
    Upload findByDescripcion(@Param("descripcion") String descripcion);

    @Query("SELECT u FROM Upload u WHERE u.urlImagenPublicacion = :urlImagenPublicacion")
    Upload findByUrlImagenPublicacion(@Param("urlImagenPublicacion") String urlImagenPublicacion);

}
