package com.example.demo2.service;

import com.example.demo2.bean.DeclarationIR;
import com.example.demo2.bean.DeclarationIRdetailles;
import com.example.demo2.bean.TauxIR;
import com.example.demo2.dao.DeclarationIRDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DeclarationIRService {
    @Autowired
    private DeclarationIRDao declarationIRDao;
    @Autowired
    private TauxIRService tauxIRService;
    @Autowired
    private DeclarationIRdetaillesService declarationIRdetailleService;

    public int save(DeclarationIR declarationIR){
        for (DeclarationIRdetailles declarationIRdetaille : declarationIR.getDeclarationIRdetailles()) {
            TauxIR tauxIR = tauxIRService.findBySalaireNet(declarationIRdetaille.getSalaireEmployeNet());
            if (tauxIR != null) {
                declarationIRdetaille.setMontantIR(tauxIR.getPourcentage()*declarationIRdetaille.getSalaireEmployeNet());
                declarationIRdetaille.setSalaireEmployeBrute(declarationIRdetaille.getSalaireEmployeNet()-declarationIRdetaille.getMontantIR());
            }
        }
        double totalBrut=0;
        double totalNet=0;
        for (DeclarationIRdetailles declarationIRdetaille : declarationIR.getDeclarationIRdetailles()) {
            totalBrut+=declarationIRdetaille.getSalaireEmployeBrute();
            totalNet+=declarationIRdetaille.getSalaireEmployeNet();
        }
        declarationIR.setSalaireTotalBrute(totalBrut);
        declarationIR.setSalaireTotalNet(totalNet);

        declarationIRDao.save(declarationIR);
        for (DeclarationIRdetailles declarationIRdetaille : declarationIR.getDeclarationIRdetailles()) {
            declarationIRdetaille.setDeclarationIR(declarationIR);
            declarationIRdetailleService.save(declarationIRdetaille);
        }

    return 1 ;}


    public DeclarationIR findByCode(String code) {
        return declarationIRDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return declarationIRDao.deleteByCode(code);
    }

    public List<DeclarationIR> findAll() {
        return declarationIRDao.findAll();
    }
}
