package com.api.bonna.controllers;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.api.bonna.models.ProductModel;
import com.api.bonna.services.ProductService;

@RestController
@RequestMapping("producto")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public ArrayList<ProductModel> getProduct(){
        return productService.getProducts();
    }

    @PostMapping()
    public ProductModel postProduct(@RequestBody ProductModel user){
        return this.productService.postProducts(user);
    }

    @GetMapping(path = "/{id}")
    public Optional<ProductModel> getProductById(@PathVariable("id") Long id){
        return this.productService.getById(id);
    }

    @GetMapping("/query")
    public ArrayList<ProductModel> getProductBycategoria(@RequestParam("categoria") String categoria){
        return this.productService.getByCategoria(categoria);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        boolean ok = this.productService.deleteProduct(id);
        if(ok){
            return "Se elimino el producto con id: " + id;
        } else {
            return "No se pudo eliminar el producto con id: " + id;
        }
    }
}
