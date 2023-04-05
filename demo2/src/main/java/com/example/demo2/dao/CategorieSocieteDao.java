package com.example.demo2.dao;
import com.example.demo2.bean.CategorieSociete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieSocieteDao extends JpaRepository<CategorieSociete, Long> {
    CategorieSociete findByCode(String code);
    int deleteByCode(String code);
}