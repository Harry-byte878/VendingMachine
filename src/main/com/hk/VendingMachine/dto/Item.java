package main.com.hk.VendingMachine.dto;

import java.math.BigDecimal;

public class Item {
    private String name;
    BigDecimal price;
    int quantity;     // in inventory

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name) {
        this.name = name;
    }
}
