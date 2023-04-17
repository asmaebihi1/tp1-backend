package com.example.demo2.ws;

import com.example.demo2.bean.TauxIS;
import com.example.demo2.service.TauxISService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/tauxIS")
public class TauxISRest {
    @Autowired
    private TauxISService tauxISService;

    @GetMapping("/reference/{ref}")
    public TauxIS findByRef(@PathVariable String ref) {
        return tauxISService.findByRef(ref);
    }

    @DeleteMapping("/reference/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return tauxISService.deleteByRef(ref);
    }

    @GetMapping("/")
    public List<TauxIS> findAll() {
        return tauxISService.findAll();
    }

    @PostMapping("/")
    public int save(TauxIS tauxIS) {
        return tauxISService.save(tauxIS);
    }
}
