package com.vishwanath.pservice.controller;

import com.vishwanath.pservice.model.ProductRequest;
import com.vishwanath.pservice.model.ProductResponse;
import com.vishwanath.pservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<Long> addProduct(@RequestBody ProductRequest productRequest) {
        long productid = productService.addProduct(productRequest);
        return new ResponseEntity<>(productid, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable("id") long id) {
        ProductResponse productResponse = productService.getProduct(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }
}
