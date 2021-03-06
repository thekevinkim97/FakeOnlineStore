package com.kevin.fakestore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

public class Sale {
    private final Integer id;
    @NotNull
    private final Integer customer_id;
    private final UUID item_serial_number;
    @NotNull
    private final Integer quantity;
    @NotNull
    private final Integer stock_location;
    @NotBlank
    private final String shipping_address;
    private final Date sale_date;

    public Sale(Integer id, Integer customer_id, UUID item_serial_number, @NotNull Integer quantity, @NotNull Integer stock_location, String shipping_address, Date sale_date) {
        this.id = id;
        this.customer_id = customer_id;
        this.item_serial_number = item_serial_number;
        this.quantity = quantity;
        this.stock_location = stock_location;
        this.shipping_address = shipping_address;
        this.sale_date = sale_date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public UUID getItem_serial_number() {
        return item_serial_number;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Integer getStock_location() {
        return stock_location;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public Date getSale_date() {
        return sale_date;
    }
}
