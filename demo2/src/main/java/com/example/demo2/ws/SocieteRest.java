package com.example.demo2.ws;

import com.example.demo2.bean.Societe;
import com.example.demo2.service.SocieteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/societe")
public class SocieteRest {
    @Autowired
    private SocieteService societeService;

    @PostMapping("/")
    public int save(@RequestBody Societe societe) {
        return societeService.save(societe);
    }
    @GetMapping("/ice/{ice}")
    public Societe findByIce(@PathVariable String ice) {
        return societeService.findByIce(ice);
    }
    @DeleteMapping("/ice/{ice}")
    public int deleteByIce(@PathVariable String ice) {
        return societeService.deleteByIce(ice);
    }
    @GetMapping("/")
    public List<Societe> findAll() {
        return societeService.findAll();
    }
}
