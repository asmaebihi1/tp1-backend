package com.example.demo2.dao;

import com.example.demo2.bean.CategorieDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CategorieDeclarationDao extends JpaRepository<CategorieDeclaration,Long> {
    CategorieDeclaration findByCode(String code);
    int deleteByCode(String code);
}
