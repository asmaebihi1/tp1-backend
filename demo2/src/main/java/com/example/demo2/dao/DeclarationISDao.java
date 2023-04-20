package com.example.demo2.dao;

import com.example.demo2.bean.DeclarationIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository

public interface DeclarationISDao extends JpaRepository<DeclarationIS, Long> {
    DeclarationIS findByAnnee(Date annee);

    int deleteByAnnee(double annee);

    List<DeclarationIS> findBySocieteIce(String ice);
}
