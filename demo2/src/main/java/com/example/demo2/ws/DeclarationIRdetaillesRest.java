package com.example.demo2.ws;

import com.example.demo2.bean.DeclarationIRdetailles;
import com.example.demo2.service.DeclarationIRdetaillesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/declarationIRdetailles")
public class DeclarationIRdetaillesRest {
    @Autowired
    private DeclarationIRdetaillesService declarationIRdetaillesService;

    @PostMapping("/")
    public int save(@RequestBody DeclarationIRdetailles declarationIRdetailles) {
        return declarationIRdetaillesService.save(declarationIRdetailles);
    }
    @GetMapping("/code/{code}")
    public DeclarationIRdetailles findByCode(@PathVariable String code) {
        return declarationIRdetaillesService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return declarationIRdetaillesService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<DeclarationIRdetailles> findAll() {
        return declarationIRdetaillesService.findAll();
    }
}
