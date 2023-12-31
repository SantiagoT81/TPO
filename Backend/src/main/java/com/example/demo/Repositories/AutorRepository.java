package com.example.demo.Repositories;

import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre AND a.apellido = :apellido")
    Autor findByNombreApellido(@Param("nombre") String nombre, @Param("apellido") String apellido);
    @Query("SELECT a FROM Autor a WHERE a.nombre = :nombre")
    Autor findByNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Autor a WHERE a.apellido = :apellido")
    Autor findByApellido(@Param("apellido") String apellido);
}
