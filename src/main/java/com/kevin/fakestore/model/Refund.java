package com.kevin.fakestore.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.util.UUID;

public class Refund {
    private final Integer id;
    private final Integer sale_id;
    @NotNull
    private final Integer customer_id;
    private final UUID item_serial_number;
    @NotBlank
    private final String shipping_address;
    private final Date refund_date;

    public Refund(Integer id, Integer sale_id, @NotNull Integer customer_id, UUID item_serial_number, @NotBlank String shipping_address, Date refund_date) {
        this.id = id;
        this.sale_id = sale_id;
        this.customer_id = customer_id;
        this.item_serial_number = item_serial_number;
        this.shipping_address = shipping_address;
        this.refund_date = refund_date;
    }

    public Integer getId() {
        return id;
    }

    public Integer getSale_id() {
        return sale_id;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public UUID getItem_serial_number() {
        return item_serial_number;
    }

    public String getShipping_address() {
        return shipping_address;
    }

    public Date getRefund_date() {
        return refund_date;
    }
}
