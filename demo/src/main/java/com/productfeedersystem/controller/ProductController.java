package com.productfeedersystem.controller;

import com.productfeedersystem.constraint.EnumConstraint;
import com.productfeedersystem.enums.Format;
import com.productfeedersystem.enums.SystemName;
import com.productfeedersystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/")
@Validated
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "products")
    public ResponseEntity<Object> getAllProducts(@RequestParam("systemName") @EnumConstraint(enumClass = SystemName.class) String systemName,
                                                 @RequestParam("format") @EnumConstraint(enumClass = Format.class) String format) {

        HttpHeaders httpHeaders = new HttpHeaders();
        return new ResponseEntity<>(productService.getAllProductsForGivenSystem(systemName,format),httpHeaders, HttpStatus.OK);
    }
}
