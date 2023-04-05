package com.example.demo2.service;

import com.example.demo2.bean.DeclarationFacture;
import com.example.demo2.dao.DeclarationFactureDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeclarationFactureService {
    @Autowired
    private DeclarationFactureDao declarationFactureDao;

    public int save(DeclarationFacture declarationFacture){
        if (findByRef(declarationFacture.getRef()) != null) {
            return -1;
        }else{
            declarationFactureDao.save(declarationFacture);
            return 1;
        }
    }

    public DeclarationFacture findByRef(String ref) {
        return declarationFactureDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return declarationFactureDao.deleteByRef(ref);
    }

    public List<DeclarationFacture> findAll() {
        return declarationFactureDao.findAll();
    }
}
