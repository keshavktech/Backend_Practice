package com.example.Product.Controller;

import com.example.Product.Dto.ProductDto;
import com.example.Product.Entity.Product;
import com.example.Product.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController
{
    @Autowired
    private ProductService ps;


    @PostMapping

    public ProductDto create(@RequestBody Product p){

        ProductDto dto = ps.addProduct(p);
        return dto;

    }

    @GetMapping

    public List<ProductDto> products()
    {
        return ps.getAllProducts();
    }

    @GetMapping("/{id}")

    public ProductDto findProduct(@PathVariable Long id){

        return ps.getById(id);
    }

    @DeleteMapping("/{id}")

    public ProductDto delete(@PathVariable Long id){

        return ps.deleteitem(id);
    }


}

