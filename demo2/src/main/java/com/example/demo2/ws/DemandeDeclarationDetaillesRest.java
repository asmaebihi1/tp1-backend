package com.example.demo2.ws;

import com.example.demo2.bean.DemandeDeclarationDetailles;
import com.example.demo2.service.DemandeDeclarationDetaillesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/demandeDeclarationDetailles")
public class DemandeDeclarationDetaillesRest {
    @Autowired
    private DemandeDeclarationDetaillesService demandeDeclarationDetaillesService;

    @PostMapping("/")
    public int save(@RequestBody DemandeDeclarationDetailles demandeDeclarationDetailles) {
        return demandeDeclarationDetaillesService.save(demandeDeclarationDetailles);
    }
    @GetMapping("/ref/{ref}")
    public DemandeDeclarationDetailles findByRef(@PathVariable String ref) {
        return demandeDeclarationDetaillesService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return demandeDeclarationDetaillesService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<DemandeDeclarationDetailles> findAll() {
        return demandeDeclarationDetaillesService.findAll();
    }
}
