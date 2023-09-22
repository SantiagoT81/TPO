package com.example.demo.Repositories;

import com.example.demo.Models.Upload;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UploadRepository extends JpaRepository<Upload, Integer> {
}
