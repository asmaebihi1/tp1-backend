package com.example.demo2.ws;

import com.example.demo2.bean.PaymentDeclaration;
import com.example.demo2.service.PaymentDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paymentDeclaration")
public class PaymentDeclarationRest {
    @Autowired
    private PaymentDeclarationService paymentDeclarationService;

    @PostMapping("/")
    public int save(@RequestBody PaymentDeclaration paymentDeclaration) {
        return paymentDeclarationService.save(paymentDeclaration);
    }
    @GetMapping("/code/{code}")
    public PaymentDeclaration findByType(@PathVariable String code) {
        return paymentDeclarationService.findByCode(code);
    }
    @DeleteMapping("/code/{code}")
    public int deleteByType(@PathVariable String code) {
        return paymentDeclarationService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<PaymentDeclaration> findAll() {
        return paymentDeclarationService.findAll();
    }
}
