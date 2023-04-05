package com.example.demo2.dao;

import com.example.demo2.bean.Comptable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ComptableDao extends JpaRepository<Comptable,Long> {
    Comptable findByCin(String cin);
    int deleteByCin(String cin);
}
