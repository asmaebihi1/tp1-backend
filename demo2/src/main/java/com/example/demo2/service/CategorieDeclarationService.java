package com.example.demo2.service;

import com.example.demo2.bean.CategorieDeclaration;
import com.example.demo2.dao.CategorieDeclarationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service


public class CategorieDeclarationService {
    @Autowired
    private CategorieDeclarationDao categorieDeclarationDao;

    public int save(CategorieDeclaration categorieDeclaration){
        if (findByCode(categorieDeclaration.getCode()) != null) {
            return -1;
        }else{
            categorieDeclarationDao.save(categorieDeclaration);
            return 1;
        }
    }
    public CategorieDeclaration findByCode(String code) {
        return categorieDeclarationDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return categorieDeclarationDao.deleteByCode(code);
    }

    public List<CategorieDeclaration> findAll() {
        return categorieDeclarationDao.findAll();
    }
}
