package com.example.demo2.service;

import com.example.demo2.bean.Comptable;
import com.example.demo2.dao.ComptableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ComptableService {
    @Autowired
    private ComptableDao comptableDao;

    public int save(Comptable comptable){
        if (findByCin(comptable.getCin()) != null) {
            return -1;
        }else{
            comptableDao.save(comptable);
            return 1;
        }
    }

    public Comptable findByCin(String cin) {
        return comptableDao.findByCin(cin);
    }
    @Transactional
    public int deleteByCin(String cin) {
        return comptableDao.deleteByCin(cin);
    }

    public List<Comptable> findAll() {
        return comptableDao.findAll();
    }
}
