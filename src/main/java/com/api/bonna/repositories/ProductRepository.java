package com.api.bonna.repositories;

import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.api.bonna.models.ProductModel;

@Repository
public interface ProductRepository extends CrudRepository<ProductModel, Long>{
    public abstract ArrayList<ProductModel> findByCategoria(String categoria);
}
