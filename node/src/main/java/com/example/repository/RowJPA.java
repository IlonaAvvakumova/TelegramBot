package com.example.repository;
import com.example.entity.RowData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RowJPA extends JpaRepository<RowData, Long> {

}
