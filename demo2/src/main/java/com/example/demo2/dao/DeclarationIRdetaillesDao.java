package com.example.demo2.dao;

import com.example.demo2.bean.DeclarationIRdetailles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeclarationIRdetaillesDao extends JpaRepository<DeclarationIRdetailles, Long> {
    DeclarationIRdetailles findByCode(String code);
    int deleteByCode(String code);
}
