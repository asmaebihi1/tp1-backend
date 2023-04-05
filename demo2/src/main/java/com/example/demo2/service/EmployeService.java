package com.example.demo2.service;

import com.example.demo2.bean.Employe;
import com.example.demo2.bean.TypeFacture;
import com.example.demo2.dao.EmployeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeDao employeDao;

    public int save(Employe employe){
        if (findByCin(employe.getCin()) != null) {
            return -1;
        }else{
            employeDao.save(employe);
            return 1;
        }
    }

    public Employe findByCin(String cin) {
        return employeDao.findByCin(cin);
    }
    @Transactional
    public int deleteByCin(String cin) {
        return employeDao.deleteByCin(cin);
    }

    public List<Employe> findAll() {
        return employeDao.findAll();
    }
}
