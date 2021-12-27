package com.productfeedersystem.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.productfeedersystem.domain.Product;
import com.productfeedersystem.enums.Format;
import com.productfeedersystem.service.ProductService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.json.XML;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("feederSystemObjectMapper")
    private ObjectMapper objectMapper;


    @Override
    public Object getAllProductsForGivenSystem(String systemName, String format) {
        TypeReference<List<Product>> typeReference = new TypeReference<List<Product>>() {
        };
        InputStream inputStream = TypeReference.class.getResourceAsStream("/json/" + systemName + "-products.json");
        try {
            List<Product> products = objectMapper.readValue(inputStream, typeReference);
            if (format.toUpperCase().equals(Format.JSON.name())) {
                return products;
            }
            return XML.toString(new JSONArray(new Gson().toJson(products)));
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
