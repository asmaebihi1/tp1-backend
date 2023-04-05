package com.example.demo2.ws;

import com.example.demo2.bean.DeclarationFacture;
import com.example.demo2.service.DeclarationFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declarationFacture")
public class DeclarationFactureRest {
    @Autowired
    private DeclarationFactureService declarationFactureService;

    @PostMapping("/")
    public int save(@RequestBody DeclarationFacture declarationFacture) {
        return declarationFactureService.save(declarationFacture);
    }
    @GetMapping("/ref/{ref}")
    public DeclarationFacture findByRef(@PathVariable String ref) {
        return declarationFactureService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    public int deleteByTypeFactureref(@PathVariable String ref) {
        return declarationFactureService.deleteByRef(ref);
    }
    @GetMapping("/")
    public List<DeclarationFacture> findAll() {
        return declarationFactureService.findAll();
    }
}
