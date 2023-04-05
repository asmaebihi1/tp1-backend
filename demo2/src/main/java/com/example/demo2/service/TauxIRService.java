package com.example.demo2.service;

import com.example.demo2.bean.TauxIR;
import com.example.demo2.dao.TauxIRDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service

public class TauxIRService {
    @Autowired
    private TauxIRDao tauxIRDao;

    public List<TauxIR> findByLibelle(String libelle) {
        return tauxIRDao.findByLibelle(libelle);
    }

    @Transactional
    public int deleteByLibelle(String libelle) {
        return tauxIRDao.deleteByLibelle(libelle);
    }

    public List<TauxIR> findAll() {
        return tauxIRDao.findAll();
    }

    @Query("SELECT t FROM TauxIR t WHERE t.salaireMax >= :salaireNet and t.salaireMin <= :salaireNet")
    public TauxIR findBySalaireNet(double salaireNet) {
        return tauxIRDao.findBySalaireNet(salaireNet);
    }

    public TauxIR findBySalaireMaxAndSalaireMin(double salaireNet) {

        List<TauxIR> tauxs = tauxIRDao.findAll();
        TauxIR taux1 = new TauxIR();

        for (TauxIR taux : tauxs) {
            if ((taux.getSalaireMin() <= salaireNet && taux.getSalaireMax() == null) ||
                    (taux.getSalaireMin() <= salaireNet && taux.getSalaireMax() >= salaireNet)) {
                return taux;
            }
        }
        return null;

    }
}
