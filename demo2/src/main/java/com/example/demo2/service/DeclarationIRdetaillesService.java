package com.example.demo2.service;

import com.example.demo2.bean.DeclarationIRdetailles;
import com.example.demo2.bean.TypeFacture;
import com.example.demo2.dao.DeclarationIRdetaillesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeclarationIRdetaillesService {
    @Autowired
    private DeclarationIRdetaillesDao declarationIRdetaillesDao;

    public int save(DeclarationIRdetailles declarationIRdetailles){
        if (findByCode(declarationIRdetailles.getCode()) != null) {
            return -1;
        }else{
            declarationIRdetaillesDao.save(declarationIRdetailles);
            return 1;
        }
    }

    public DeclarationIRdetailles findByCode(String code) {
        return declarationIRdetaillesDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return declarationIRdetaillesDao.deleteByCode(code);
    }

    public List<DeclarationIRdetailles> findAll() {
        return declarationIRdetaillesDao.findAll();
    }
}
