package com.kevin.fakestore.model;

import javax.validation.constraints.NotBlank;

public class Customer {
    private final Integer id;
    @NotBlank
    private final String name;
    @NotBlank
    private final String email;


    public Customer(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
