package com.example.demo2.ws;

import com.example.demo2.bean.DemandeDeclaration;
import com.example.demo2.bean.EtatDeclaration;
import com.example.demo2.service.DemandeDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/demandeDeclaration")
public class DemandeDeclarationRest {
    @Autowired
    private DemandeDeclarationService demandeDeclarationService;

    @PostMapping("/")
    public int save(DemandeDeclaration demandeDeclaration) {
        return demandeDeclarationService.save(demandeDeclaration);
    }
    @PutMapping("/")
    public void update(@RequestBody DemandeDeclaration demandeDeclaration) {
        demandeDeclarationService.update(demandeDeclaration);
    }
    @GetMapping("/ref/{ref}")
    public DemandeDeclaration findByRef(@PathVariable String ref) {
        return demandeDeclarationService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return demandeDeclarationService.deleteByRef(ref);
    }
    @PutMapping("/etat")
    public void updateEtat(@RequestBody DemandeDeclaration demandeDeclaration, @RequestBody EtatDeclaration newEtatDeclaration) {
        demandeDeclarationService.updateEtat(demandeDeclaration, newEtatDeclaration);
    }
    @GetMapping("/")
    public List<DemandeDeclaration> findAll() {
        return demandeDeclarationService.findAll();
    }
}
