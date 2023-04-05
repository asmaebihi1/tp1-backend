package com.example.demo2.service;

import com.example.demo2.bean.DemandeDeclaration;
import com.example.demo2.bean.EtatDeclaration;
import com.example.demo2.dao.DemandeDeclarationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DemandeDeclarationService {
    @Autowired
    private DemandeDeclarationDao demandeDeclarationDao;

    public int save(DemandeDeclaration demandeDeclaration){
        if (findByRef(demandeDeclaration.getRef()) != null) {
            return -1;
        } else if (demandeDeclaration.getTotal()<demandeDeclaration.getTotalPaye()) {
            return -2;

        } else{
            demandeDeclarationDao.save(demandeDeclaration);
            return 1;
        }
    }
    public void update(DemandeDeclaration demandeDeclaration){
        demandeDeclarationDao.save(demandeDeclaration);
    }
    public DemandeDeclaration findByRef(String ref) {
        return demandeDeclarationDao.findByRef(ref);
    }
    @Transactional
    public int deleteByRef(String ref) {
        return demandeDeclarationDao.deleteByRef(ref);
    }
    public void updateEtat(DemandeDeclaration demandeDeclaration , EtatDeclaration newEtatDeclaration) {
        if (demandeDeclaration != null) {
            demandeDeclaration.setEtatDeclaration(newEtatDeclaration);
            demandeDeclarationDao.save(demandeDeclaration);
        }
    }

    public List<DemandeDeclaration> findAll() {
        return demandeDeclarationDao.findAll();
    }
}
