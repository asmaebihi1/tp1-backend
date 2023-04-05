package com.example.demo2.service;

import com.example.demo2.bean.EtatDeclaration;
import com.example.demo2.bean.TypeFacture;
import com.example.demo2.dao.EtatDeclarationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class EtatDeclarationService {
    @Autowired
    private EtatDeclarationDao etatDeclarationDao;

    public int save(EtatDeclaration etatDeclaration){
        if (findByCode(etatDeclaration.getCode()) != null) {
            return -1;
        }else{
            etatDeclarationDao.save(etatDeclaration);
            return 1;
        }
    }

    public EtatDeclaration findByCode(String code) {
        return etatDeclarationDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return etatDeclarationDao.deleteByCode(code);
    }

    public List<EtatDeclaration> findAll() {
        return etatDeclarationDao.findAll();
    }
}
