package com.example.demo2.service;

import com.example.demo2.bean.DemandeDeclarationDetailles;
import com.example.demo2.dao.DemandeDeclarationDetaillesDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class DemandeDeclarationDetaillesService {
    @Autowired
    private DemandeDeclarationDetaillesDao demandeDeclarationDetaillesDao;

    public int save(DemandeDeclarationDetailles demandeDeclarationDetailles){
        if (findByRef(demandeDeclarationDetailles.getRef()) != null) {
            return -1;
        }else{
            demandeDeclarationDetaillesDao.save(demandeDeclarationDetailles);
            return 1;
        }
    }
    public DemandeDeclarationDetailles findByRef(String ref) {
        return demandeDeclarationDetaillesDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return demandeDeclarationDetaillesDao.deleteByRef(ref);
    }

    public List<DemandeDeclarationDetailles> findAll() {
        return demandeDeclarationDetaillesDao.findAll();
    }
}
