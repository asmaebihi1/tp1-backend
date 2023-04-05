package com.example.demo2.ws;

import com.example.demo2.bean.DeclarationIR;
import com.example.demo2.service.DeclarationIRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declarationIR")
public class DeclarationIRRest {
    @Autowired
    private DeclarationIRService declarationIRService;

    @PostMapping("/")
    public int save(@RequestBody DeclarationIR declarationIR) {
        return declarationIRService.save(declarationIR);
    }
    @GetMapping("/code/{code}")
    public DeclarationIR findByCode(@PathVariable String code) {
        return declarationIRService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return declarationIRService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<DeclarationIR> findAll() {
        return declarationIRService.findAll();
    }
}
