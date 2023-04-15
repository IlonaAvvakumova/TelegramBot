package com.example.repository;
import com.example.entity.AppDocument;
import com.example.entity.AppPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppPhotoDAO extends JpaRepository<AppPhoto, Long> {

}
