package com.example.demo2.ws;

import com.example.demo2.bean.TypeFacture;
import com.example.demo2.service.TypeFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/typeFacture")
public class TypeFactureRest {
    @Autowired
    private TypeFactureService typeFactureService;


    @PostMapping("/")
    public int save(@RequestBody TypeFacture typeFacture) {
        return typeFactureService.save(typeFacture);
    }
    @GetMapping("/code/{code}")
    public TypeFacture findByCode(@PathVariable String code) {
        return typeFactureService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typeFactureService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<TypeFacture> findAll() {
        return typeFactureService.findAll();
    }
}
