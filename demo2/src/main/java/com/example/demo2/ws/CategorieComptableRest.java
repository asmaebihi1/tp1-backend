package com.example.demo2.ws;

import com.example.demo2.bean.CategorieComptable;
import com.example.demo2.service.CategorieComptableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categorieComptable")
public class CategorieComptableRest {
    @Autowired
    private CategorieComptableService categorieComptableService;
    @PostMapping("/")
    public int save(@RequestBody CategorieComptable categorieComptable) {
        return categorieComptableService.save(categorieComptable);
    }
    @GetMapping("/code/{code}")
    public CategorieComptable findByCode(@PathVariable String code) {
        return categorieComptableService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieComptableService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<CategorieComptable> findAll() {
        return categorieComptableService.findAll();
    }
}
