package com.example.demo2.dao;

import com.example.demo2.bean.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeDao extends JpaRepository<Employe , Long> {
    Employe findByCin(String cin);
    int deleteByCin(String cin);
}
