package com.example.demo2.dao;

import com.example.demo2.bean.DemandeDeclarationDetailles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository

public interface DemandeDeclarationDetaillesDao extends JpaRepository<DemandeDeclarationDetailles,Long> {
    DemandeDeclarationDetailles findByRef(String ref);
    int deleteByRef(String ref);
}
