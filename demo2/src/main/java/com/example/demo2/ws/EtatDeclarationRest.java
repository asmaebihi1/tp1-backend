package com.example.demo2.ws;

import com.example.demo2.bean.EtatDeclaration;
import com.example.demo2.service.EtatDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/etatdeclaration")
public class EtatDeclarationRest {
    @Autowired
    private EtatDeclarationService etatDeclarationService;

    @PostMapping("/")
    public int save(@RequestBody EtatDeclaration etatDeclaration) {
        return etatDeclarationService.save(etatDeclaration);
    }
    @GetMapping("/code/{code}")
    public EtatDeclaration findByCode(@PathVariable String code) {
        return etatDeclarationService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return etatDeclarationService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<EtatDeclaration> findAll() {
        return etatDeclarationService.findAll();
    }
}
