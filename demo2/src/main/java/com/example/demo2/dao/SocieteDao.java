package com.example.demo2.dao;

import com.example.demo2.bean.Societe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SocieteDao extends JpaRepository<Societe,Long> {
    Societe findByIce(String ice);
    int deleteByIce(String ice);
}
