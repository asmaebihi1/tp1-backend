package com.example.demo2.service;

import com.example.demo2.bean.Comptable;
import com.example.demo2.bean.DeclarationIS;
import com.example.demo2.bean.Societe;
import com.example.demo2.bean.TauxIS;
import com.example.demo2.dao.DeclarationISDao;
import com.example.demo2.util.StringUtil;
import com.example.demo2.vo.DeclarationIsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Date;
import java.util.List;

@Service
public class DeclarationISService {
    @Autowired
    private DeclarationISDao declarationISDao;
    @Autowired
    private SocieteService societeService;
    @Autowired
    private TauxISService tauxISService;
    @Autowired
    private EntityManager entityManager;

    public List<DeclarationIS> searchCriteria(DeclarationIsVo declarationIsVo){
        String query = "SELECT d FROM DeclarationIS d WHERE 1=1";
        if(StringUtil.isNotEmpty(declarationIsVo.getRef())) {
            query+= " AND d.ref LIKE '%"+ declarationIsVo.getRef()+ "%'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getAnnee())) {
            query+= " AND d.annee = '"+ declarationIsVo.getAnnee()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getAnneeMin())) {
            query+= " AND d.annee >= '"+ declarationIsVo.getAnneeMin()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getAnneeMax())) {
            query+= " AND d.annee <= '"+ declarationIsVo.getAnneeMax()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTGain())) {
            query+= " AND d.totalHTGain = '"+ declarationIsVo.getTotalHTGain()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTGainMin())) {
            query+= " AND d.totalHTGain >= '"+ declarationIsVo.getTotalHTGainMin()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTGainMax())) {
            query+= " AND d.totalHTGain <= '"+ declarationIsVo.getTotalHTGainMax()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTCharge())) {
            query+= " AND d.totalHTCharge = '"+ declarationIsVo.getTotalHTCharge()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTChargeMin())) {
            query+= " AND d.totalHTCharge >= '"+ declarationIsVo.getTotalHTChargeMin()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTChargeMax())) {
            query+= " AND d.totalHTCharge <= '"+ declarationIsVo.getTotalHTChargeMax()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTDiff())) {
            query+= " AND d.totalHTDiff = '"+ declarationIsVo.getTotalHTDiff()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTDiffMin())) {
            query+= " AND d.totalHTDiff >= '"+ declarationIsVo.getTotalHTDiffMin()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTotalHTDiffMax())) {
            query+= " AND d.totalHTDiff <= '"+ declarationIsVo.getTotalHTDiffMax()+ "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISCalcule())){
            query+= " AND d.montantISCalcule = '"+ declarationIsVo.getMontantISCalcule() + "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISCalculeMin())){
            query+= " AND d.montantISCalcule >= '"+ declarationIsVo.getMontantISCalculeMin() + "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISCalculeMax())){
            query+= " AND d.montantISCalcule <= '"+ declarationIsVo.getMontantISCalculeMax() + "'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISPaye())) {
            query+= " AND d.montantISPaye = '" + declarationIsVo.getMontantISPaye() +"'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISPayeMin())) {
            query+= " AND d.montantISPaye >= '" + declarationIsVo.getMontantISPayeMin() +"'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getMontantISPayeMax())) {
            query+= " AND d.montantISPaye <= '" + declarationIsVo.getMontantISPayeMax() +"'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getSociete())) {
            query+= " AND d.societe.ice LIKE '%" + declarationIsVo.getSociete() +"%'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTauxIS())) {
            query+= " AND d.tauxIS.ref LIKE '%" + declarationIsVo.getTauxIS() +"%'";
        }
        if(StringUtil.isNotEmpty(declarationIsVo.getTauxIsConfig())) {
            query+= " AND d.tauxISConfig.ref LIKE '%" + declarationIsVo.getTauxIsConfig() +"%'";
        }

        return entityManager.createQuery(query).getResultList();
    }
    public DeclarationIS findByAnnee(Date annee) {
        return declarationISDao.findByAnnee(annee);
    }

    public List<DeclarationIS> findBySocieteIce(String ice) {
        return declarationISDao.findBySocieteIce(ice);
    }

    public double calculMontantIS(double rf){
        List<TauxIS> tauxISList = tauxISService.findAll();
        Double montantC =0.0;
        for (TauxIS taux: tauxISList) {
            if (rf >= taux.getResultatFiscalMin() && rf <= taux.getResultatFiscalMax()){
                if(tauxISList.indexOf(taux) == 0){
                    montantC = (rf - taux.getResultatFiscalMin())* taux.getPourcentage()/100;
                }
                else{
                    montantC = (rf - taux.getResultatFiscalMin())* taux.getPourcentage()/100;
                    for (int i = tauxISList.indexOf(taux)-1; i>=0; i--){
                        TauxIS t = tauxISList.get(i);
                        montantC += (t.getResultatFiscalMax() - t.getResultatFiscalMin())* t.getPourcentage()/100;
                    }
                }
            }
        }
        return montantC;
    }

    public double affectMontantPaye(DeclarationIS declarationIS){
        double montantP =0.0;

        if (declarationIS.getMontantISCalcule() < 3000){
            montantP = 3000.0;
        }
        else {
            montantP = declarationIS.getMontantISCalcule();}


        return montantP;
    }



    public int save(DeclarationIS declarationIS){
        if (findByAnnee(declarationIS.getAnnee()) != null) {
            return -1;
        }else{
            declarationISDao.save(declarationIS);
            return 1;
        }
    }

    public List<DeclarationIS> findAll() {
        return declarationISDao.findAll();
    }

}
