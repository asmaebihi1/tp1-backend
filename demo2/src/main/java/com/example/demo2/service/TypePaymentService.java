package com.example.demo2.service;

import com.example.demo2.bean.Comptable;
import com.example.demo2.bean.TypeFacture;
import com.example.demo2.bean.TypePayment;
import com.example.demo2.dao.TypePaymentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypePaymentService {
    @Autowired
    private TypePaymentDao typePaymentDao;

    public int save(TypePayment typePayment){
        if (findByCode(typePayment.getCode()) != null) {
            return -1;
        }else{
            typePaymentDao.save(typePayment);
            return 1;
        }
    }
    public TypeFacture findByCode(String code) {
        return typePaymentDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return typePaymentDao.deleteByCode(code);
    }

    public List<TypePayment> findAll() {
        return typePaymentDao.findAll();
    }
}
