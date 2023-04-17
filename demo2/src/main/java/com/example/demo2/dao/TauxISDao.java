package com.example.demo2.dao;

import com.example.demo2.bean.TauxIS;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface TauxISDao extends JpaRepository<TauxIS, Long> {
    TauxIS findByRef(String ref);
    int deleteByRef(String ref);


}
