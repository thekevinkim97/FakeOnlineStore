package com.kevin.fakestore.model;

import javax.validation.constraints.NotNull;

public class CustomerStatistic {
    @NotNull
    private final Integer customer_id;
    private final Integer total_sales;
    private final Double total_spent;
    private final Integer favorite_category;

    public CustomerStatistic(Integer customer_id, Integer total_sales, Double total_spent, Integer favorite_category) {
        this.customer_id = customer_id;
        this.total_sales = total_sales;
        this.total_spent = total_spent;
        this.favorite_category = favorite_category;
    }

    public Integer getCustomer_id() {
        return customer_id;
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
}
