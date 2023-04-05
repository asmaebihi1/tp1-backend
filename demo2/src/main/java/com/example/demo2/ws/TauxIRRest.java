package com.example.demo2.ws;

import com.example.demo2.bean.TauxIR;
import com.example.demo2.service.TauxIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tauxIR")
public class TauxIRRest {
    @Autowired
    private TauxIRService tauxIRService;

    @GetMapping("/libelle/{libelle}")
    public List<TauxIR> findByLibelle(@PathVariable String libelle) {
        return tauxIRService.findByLibelle(libelle);
    }
    @DeleteMapping("/libelle/{libelle}")
    public int deleteByLibelle(@PathVariable String libelle) {
        return tauxIRService.deleteByLibelle(libelle);
    }
    @GetMapping("/")
    public List<TauxIR> findAll() {
        return tauxIRService.findAll();
    }

    @Query("SELECT t FROM TauxIR t WHERE t.salaireMax >= :salaireNet and t.salaireMin <= :salaireNet")
    public TauxIR findBySalaireNet(double salaireNet) {
        return tauxIRService.findBySalaireNet(salaireNet);
    }
    @GetMapping ("/salaireMax/{salaireMax}/salaireMin/{salaireMin}")
    public TauxIR findBySalaireMaxAndSalaireMin(@PathVariable double salaireNet) {
        return tauxIRService.findBySalaireMaxAndSalaireMin(salaireNet);
    }
}
