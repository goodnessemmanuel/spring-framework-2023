package com.ocheejeh.practicespringboot.commons;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class CommonController {
    private final ServiceConfiguration configuration;

    public CommonController(ServiceConfiguration configuration) {
        this.configuration = configuration;
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return List.of(
                new Product(1, "Bag"),
                new Product(2, "Shoe"),
                new Product(3, "Game"),
                new Product(4, "Burgers")
        );
    }

    @GetMapping("/config")
    public ServiceConfiguration configurations(){
        return configuration;
    }
}
