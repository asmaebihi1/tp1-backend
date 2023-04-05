package com.example.demo2.service;

import com.example.demo2.bean.Societe;
import com.example.demo2.dao.SocieteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SocieteService {
    @Autowired
    private SocieteDao societeDao;

    public int save(Societe societe){
        if (findByIce(societe.getIce()) != null) {
            return -1;
        }else{
            societeDao.save(societe);
            return 1;
        }
    }

    public Societe findByIce(String ice) {
        return societeDao.findByIce(ice);
    }

    @Transactional
    public int deleteByIce(String ice) {
        return societeDao.deleteByIce(ice);
    }

    public List<Societe> findAll() {
        return societeDao.findAll();
    }
}
