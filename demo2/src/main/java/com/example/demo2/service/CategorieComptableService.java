package com.example.demo2.service;

import com.example.demo2.bean.CategorieComptable;
import com.example.demo2.dao.CategorieComptableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class CategorieComptableService {
    @Autowired
    private CategorieComptableDao categorieComptableDao;

    public int save(CategorieComptable categorieComptable){
        if (findByCode(categorieComptable.getCode()) != null) {
            return -1;
        }else{
            categorieComptableDao.save(categorieComptable);
            return 1;
        }
    }

    public CategorieComptable findByCode(String code) {
        return categorieComptableDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return categorieComptableDao.deleteByCode(code);
    }

    public List<CategorieComptable> findAll() {
        return categorieComptableDao.findAll();
    }
}
