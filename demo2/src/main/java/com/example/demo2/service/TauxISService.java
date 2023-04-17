package com.example.demo2.service;

import com.example.demo2.bean.TauxIS;
import com.example.demo2.dao.TauxISDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TauxISService {
    @Autowired
   private TauxISDao tauxISDao;

    public TauxIS findByRef(String ref) {
        return tauxISDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return tauxISDao.deleteByRef(ref);
    }


    public List<TauxIS> findAll() {
        return tauxISDao.findAll();
    }

    public int save(TauxIS tauxIS) {
        if (findByRef(tauxIS.getRef()) != null){
            return -1;
        }else {
            tauxISDao.save(tauxIS);
            return 1;
        }
    }

}
