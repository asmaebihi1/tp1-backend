package com.example.demo2.dao;

import com.example.demo2.bean.DeclarationIR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIRDao extends JpaRepository<DeclarationIR, Long > {
    DeclarationIR findByCode(String code);
    int deleteByCode(String code);

}
