package com.example.demo2.ws;

import com.example.demo2.bean.Comptable;
import com.example.demo2.service.ComptableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comptable")
public class ComptableRest {
    @Autowired
    private ComptableService comptableService;

    @PostMapping("/")
    public int save(@RequestBody Comptable comptable) {
        return comptableService.save(comptable);
    }
    @GetMapping("/cin/{cin}")
    public Comptable findByCin(@PathVariable String cin) {
        return comptableService.findByCin(cin);
    }
    @DeleteMapping("/cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return comptableService.deleteByCin(cin);
    }
    @GetMapping("/")
    public List<Comptable> findAll() {
        return comptableService.findAll();
    }
}
