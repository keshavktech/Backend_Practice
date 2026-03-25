package com.example.Product.Entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter

@Table(name = "Products")

public class Product
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "CostPrice")
    private double cp;

    @Column(name = "SellingPrice")
    private double sp;

    @Column(name = "Quantity")
    private int quantity;

}
