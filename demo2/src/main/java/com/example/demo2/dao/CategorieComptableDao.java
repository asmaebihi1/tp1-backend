package com.example.demo2.dao;

import com.example.demo2.bean.CategorieComptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieComptableDao extends JpaRepository<CategorieComptable,Long> {
    CategorieComptable findByCode(String code);
    int deleteByCode(String code);
}
