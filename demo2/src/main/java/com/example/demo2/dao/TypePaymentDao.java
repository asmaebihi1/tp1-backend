package com.example.demo2.dao;

import com.example.demo2.bean.TypeFacture;
import com.example.demo2.bean.TypePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypePaymentDao extends JpaRepository<TypePayment, Long> {
    TypeFacture findByCode(String code);
    int deleteByCode(String code);
}
