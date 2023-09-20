package com.example.demo.Repositories;

import com.example.demo.Models.Autor;
import com.example.demo.Models.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Integer> {
    //@Query
    //Libro findByTitulo(String titulo);
    @Query("SELECT l FROM Libro l WHERE l.titulo = :title")
    Libro findByTitulo(@Param("title") String title);

    //@Query("SELECT id_autor FROM Libro l JOIN l.autores a WHERE a_id = :libroId ")
    @Query("SELECT l.autores FROM Libro l WHERE l = :libro")
    List<Autor> findAutoresByLibro(@Param("libro") Libro libro);

}
