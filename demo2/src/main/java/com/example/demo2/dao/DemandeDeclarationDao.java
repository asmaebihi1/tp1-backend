package com.example.demo2.dao;

import com.example.demo2.bean.DemandeDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DemandeDeclarationDao extends JpaRepository<DemandeDeclaration,Long> {
    DemandeDeclaration findByRef(String ref);
    int deleteByRef(String ref);
}
