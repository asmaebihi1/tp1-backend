package com.example.demo2.dao;

import com.example.demo2.bean.EtatDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDeclarationDao extends JpaRepository<EtatDeclaration,Long> {
    EtatDeclaration findByCode(String code);
    int deleteByCode(String code);
}
