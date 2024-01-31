package com.example.team6demo.model;
import lombok.Getter;
public class ProductCategory {

    @Getter
    public enum ProductCategory {
        COFFEE(), BURGER(), PIZZA(), MEXICAN(), SOUVLAKI();



    }
}
