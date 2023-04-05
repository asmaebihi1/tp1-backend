package com.example.demo2.ws;

import com.example.demo2.bean.TypeFacture;
import com.example.demo2.bean.TypePayment;
import com.example.demo2.service.TypePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/typePayment")
public class TypePaymentRest {
    @Autowired
    private TypePaymentService typePaymentService;
    @GetMapping("/code/{code}")
    public TypeFacture findByCode(@PathVariable String code) {
        return typePaymentService.findByCode(code);
    }
    @DeleteMapping ("/code/{code}")
    public int deleteByCode(@PathVariable String code) {
        return typePaymentService.deleteByCode(code);
    }
    @GetMapping("/")
    public List<TypePayment> findAll() {
        return typePaymentService.findAll();
    }
    @PostMapping("/")
    public int save(@RequestBody TypePayment typePayment) {
        return typePaymentService.save(typePayment);
    }
}
