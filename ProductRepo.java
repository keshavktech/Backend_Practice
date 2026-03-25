package com.example.Product.Repository;

import com.example.Product.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Long>
{

}
