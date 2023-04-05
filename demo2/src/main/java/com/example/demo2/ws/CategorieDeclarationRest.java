package com.example.demo2.ws;

import com.example.demo2.bean.CategorieDeclaration;
import com.example.demo2.service.CategorieDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorieDeclaration")
public class CategorieDeclarationRest {
    @Autowired
    private CategorieDeclarationService categorieDeclarationService;
    @PostMapping("/")
    public int save(@RequestBody CategorieDeclaration categorieDeclaration) {
        return categorieDeclarationService.save(categorieDeclaration);
    }
    @GetMapping("/code/{code}")
    public CategorieDeclaration findByCode(@PathVariable String code) {
        return categorieDeclarationService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieDeclarationService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<CategorieDeclaration> findAll() {
        return categorieDeclarationService.findAll();
    }
}
