package com.example.demo2.dao;

import com.example.demo2.bean.TypeFacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TypeFactureDao extends JpaRepository<TypeFacture,Long> {
    TypeFacture findByCode(String code);
    int deleteByCode(String code);
}
