package com.example.demo2.service;

import com.example.demo2.bean.DemandeDeclaration;
import com.example.demo2.bean.PaymentDeclaration;
import com.example.demo2.bean.TypePayment;
import com.example.demo2.dao.PaymentDeclarationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PaymentDeclarationService {
    @Autowired
    private PaymentDeclarationDao paymentDeclarationDao;
    @Autowired
    private DemandeDeclarationService demandeDeclarationService;




    public int save(PaymentDeclaration paymentDeclaration){
        if (findByCode(paymentDeclaration.getCode()) != null) {
            return -1;
        }
        DemandeDeclaration demandeDeclaration = demandeDeclarationService.findByRef(paymentDeclaration.getDemandeDeclaration().getRef());
        paymentDeclaration.setDemandeDeclaration(demandeDeclaration);
        if(demandeDeclaration==null){
            return -2;
        } else if (demandeDeclaration.getTotalPaye()+paymentDeclaration.getMontant()>demandeDeclaration.getTotal()) {
            return -3;
        }
        else {
            double nvtotalPaye = demandeDeclaration.getTotalPaye()+paymentDeclaration.getMontant();
            demandeDeclaration.setTotalPaye(nvtotalPaye);
            if(paymentDeclaration.getTypePayment().getCode().equals("ESPECE")){
            double nvtotal1=paymentDeclaration.getMontant()+demandeDeclaration.getTotalEsps();
             demandeDeclaration.setTotalEsps(nvtotal1);
            }
            else{
            double nvtotal2=paymentDeclaration.getMontant()+demandeDeclaration.getTotalNonEsps();
                demandeDeclaration.setTotalEsps(nvtotal2);
            }
            demandeDeclarationService.update(demandeDeclaration);
            paymentDeclarationDao.save(paymentDeclaration);
            return 1;
        }


    }

    public PaymentDeclaration findByCode(String code) {
        return paymentDeclarationDao.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return paymentDeclarationDao.deleteByCode(code);
    }

    public List<PaymentDeclaration> findAll() {
        return paymentDeclarationDao.findAll();
    }

}
