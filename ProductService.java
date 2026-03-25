package com.example.Product.Service;

import com.example.Product.Dto.ProductDto;
import com.example.Product.Entity.Product;
import com.example.Product.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service

public class ProductService {

    @Autowired
    private ProductRepo productrepo ;

    public ProductDto addProduct(Product p)
    {
        ProductDto pd = new ProductDto();
        Product product  = productrepo.save(p);
        pd = convert(product);
        return pd;
    }

    public List<ProductDto> getAllProducts()
    {
        List<Product> result = productrepo.findAll();
        List<ProductDto> ans = new ArrayList<>();

        for(Product p :result)
        {
            ans.add(convert(p));
        }

        return ans;
    }

    public ProductDto getById(Long id)
    {
        Product p = productrepo.findById(id).orElse(null);

        if(p==null)
            return null;

        return convert(p);
    }


    public ProductDto deleteitem(Long id){

        ProductDto pr = new ProductDto();
        Product p = productrepo.findById(id).orElse(null);

        if(p!=null){
            productrepo.deleteById(id);
        }

        pr = convert(p);
        return pr;
    }

    private ProductDto convert(Product p)
    {
        ProductDto pd = new ProductDto();
        pd.setName(p.getName());
        pd.setSp(p.getSp());
        pd.setQuantity(p.getQuantity());

        return pd;
    }
}

