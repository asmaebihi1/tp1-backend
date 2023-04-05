package com.example.demo2.service;

import com.example.demo2.bean.TypeFacture;
import com.example.demo2.dao.TypeFactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TypeFactureService {
    @Autowired
    private TypeFactureDao typeFactureDao;

    public int save(TypeFacture typeFacture){
        if (findByCode(typeFacture.getCode()) != null) {
            return -1;
        }else{
            typeFactureDao.save(typeFacture);
            return 1;
        }
    }

    public TypeFacture findByCode(String code) {
        return typeFactureDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return typeFactureDao.deleteByCode(code);
    }

    public List<TypeFacture> findAll() {
        return typeFactureDao.findAll();
    }
}
