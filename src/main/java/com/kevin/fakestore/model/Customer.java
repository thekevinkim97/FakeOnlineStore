package com.kevin.fakestore.model;

import javax.validation.constraints.NotBlank;

public class Customer {
    private final Integer id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String email;
    private final Integer total_sales;
    private final Double total_spent;
    private final Integer favorite_category;


    public Customer(Integer id, String name, String email, Integer total_sales, Double total_spent, Integer favorite_category) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.total_sales = total_sales;
        this.total_spent = total_spent;
        this.favorite_category = favorite_category;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getTotal_sales() {
        return total_sales;
    }

    public Double getTotal_spent() {
        return total_spent;
    }

    public Integer getFavorite_category() {
        return favorite_category;
    }

    public String getEmail() {
        return email;
    }

}
