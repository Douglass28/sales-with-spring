package com.dsevoluction.sales.services;

import com.dsevoluction.sales.entities.Product;
import com.dsevoluction.sales.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> findAll(){
        return repository.findAll();
    }

    public Product findById(Integer id){
        Optional<Product> obj = repository.findById(id);
        return obj.orElseThrow(() -> new RuntimeException("Not foud"));
    }

    public Product insert(Product product){
        return repository.save(product);
    }

    public Product upDate(Integer id, Product product){
        Product obj = repository.getReferenceById(id);
        upDateData(obj, product);
        return repository.save(obj);
    }
    public void upDateData(Product obj, Product product){
        obj.setDescription(product.getDescription());
        obj.setPrice(product.getPrice());
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }
}
