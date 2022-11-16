package com.api.bonna.services;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.bonna.models.ProductModel;
import com.api.bonna.repositories.ProductRepository;

// @EntityScan("com.api.bonna.models.ProductoModel")
@Service
public class ProductService {
    @Autowired(required = false)
    ProductRepository productoRepository;

    public ArrayList<ProductModel> getProducts(){
        return (ArrayList<ProductModel>) productoRepository.findAll();
    }

    public ProductModel postProducts(ProductModel product){
        return productoRepository.save(product);
    }

    public Optional<ProductModel> getById(Long id){
        return productoRepository.findById(id);
    }
    
    public  ArrayList<ProductModel> getByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    public boolean deleteProduct(Long id){
        try{
            productoRepository.deleteById(id);

            return true;

        } catch(Exception err){
            return false;
        }
    }
}
