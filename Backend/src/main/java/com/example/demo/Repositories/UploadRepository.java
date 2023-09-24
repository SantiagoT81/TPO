package com.example.demo.Repositories;

import com.example.demo.Models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface UploadRepository extends JpaRepository<Upload, Integer> {

}
