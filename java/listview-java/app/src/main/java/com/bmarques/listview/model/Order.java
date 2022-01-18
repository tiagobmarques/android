package com.bmarques.listview.model;

import java.io.Serializable;

public class Order implements Serializable {

    private Integer id;
    private String client;
    private Double value;

    public Order(String client,
                 Double value) {
        this.client = client;
        this.value = value;
    }

    public Order() {
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return client;
    }
}
