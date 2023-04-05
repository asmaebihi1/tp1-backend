package com.example.demo2.service;

import com.example.demo2.bean.CategorieSociete;
import com.example.demo2.bean.Comptable;
import com.example.demo2.dao.CategorieSocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CategorieSocieteService {
    @Autowired
    private CategorieSocieteDao categorieSocieteDao;

    public int save(CategorieSociete categorieSociete){
        if (findByCode(categorieSociete.getCode()) != null) {
            return -1;
        }else{
            categorieSocieteDao.save(categorieSociete);
            return 1;
        }
    }

    public CategorieSociete findByCode(String code) {
        return categorieSocieteDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return categorieSocieteDao.deleteByCode(code);
    }

    public List<CategorieSociete> findAll() {
        return categorieSocieteDao.findAll();
    }
}
