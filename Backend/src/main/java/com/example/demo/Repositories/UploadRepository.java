package com.example.demo.Repositories;

import com.example.demo.Models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Integer> {
    @Query("SELECT u FROM Upload u WHERE u.rate = :rate")
    Upload findByRate(@Param("rate") Integer rate);

    //Promedio de puntaje
    @Query("SELECT AVG(u.rate) FROM Upload u WHERE u.id = :id")
    Upload averageRate(@Param("id") Integer id);
}
