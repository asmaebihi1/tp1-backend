package com.example.demo2.ws;

import com.example.demo2.bean.CategorieSociete;
import com.example.demo2.service.CategorieSocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/categorieSociete")
@RestController
public class CategorieSocieteRest {
    @Autowired
    private CategorieSocieteService categorieSocieteService;

    @PostMapping("/")
    public int save(@RequestBody CategorieSociete categorieSociete) {
        return categorieSocieteService.save(categorieSociete);
    }
    @GetMapping("/code/{code}")
    public CategorieSociete findByCode(@PathVariable String code) {
        return categorieSocieteService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return categorieSocieteService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<CategorieSociete> findAll() {
        return categorieSocieteService.findAll();
    }
}
