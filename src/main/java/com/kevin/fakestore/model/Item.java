package com.kevin.fakestore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

public class Item {
    private final UUID serial_number;
    @NotNull
    private final Integer category_id;
    @NotBlank
    private final String name;
    @NotNull
    private final Double price;
    @NotBlank
    private final String description;
    private final Integer store_quantity;
    private final Integer online_quantity;

    public Item(UUID serial_number, Integer category_id, String name, Double price, String description, Integer store_quantity, Integer online_quantity) {
        this.serial_number = serial_number;
        this.category_id = category_id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.store_quantity = store_quantity;
        this.online_quantity = online_quantity;
    }

    public UUID getSerialNumber() {
        return serial_number;
    }

    public Integer getCategoryId() {
        return category_id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStoreQuantity() {
        return store_quantity;
    }

    public Integer getOnlineQuantity() {
        return online_quantity;
    }
}
