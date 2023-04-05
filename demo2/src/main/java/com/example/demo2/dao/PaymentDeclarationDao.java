package com.example.demo2.dao;

import com.example.demo2.bean.PaymentDeclaration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDeclarationDao extends JpaRepository<PaymentDeclaration,Long> {
    PaymentDeclaration findByCode(String code);
    int deleteByCode(String code);
}
