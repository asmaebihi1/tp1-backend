package com.example.demo2.ws;

import com.example.demo2.bean.DeclarationIS;
import com.example.demo2.service.DeclarationISService;
import com.example.demo2.vo.DeclarationIsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declarationIS")
public class DeclarationISRest {
    @Autowired
    private DeclarationISService declarationISService;

    @GetMapping("/societe/ice/{ice}")
    public List<DeclarationIS> findBySocieteIce(@PathVariable String ice) {
        return declarationISService.findBySocieteIce(ice);
    }

    @GetMapping("/annee/{annee}")
    public DeclarationIS findByAnnee(@PathVariable double annee) {
        return declarationISService.findByAnnee(annee);
    }

    @GetMapping("/montantISCalcule/rf/{rf}")
    public double calculMontantIS(@PathVariable double rf) {
        return declarationISService.calculMontantIS(rf);
    }

    @GetMapping("/")
    public List<DeclarationIS> findAll() {
        return declarationISService.findAll();
    }

    @PostMapping("/")
    public int save(@RequestBody DeclarationIS declarationIS) {
        return declarationISService.save(declarationIS);
    }
    @PostMapping("/criteria/")
    public List<DeclarationIS> searchCriteria(@RequestBody DeclarationIsVo declarationIsVo) {
        return declarationISService.searchCriteria(declarationIsVo);
    }


}
