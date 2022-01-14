package com.bmarques.listview.dao;

import com.bmarques.listview.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderDao {

    private final static List<Order> orders = new ArrayList<>();
    private static int idCounter = 1;

    public OrderDao() {
    }

    public void save(Order order) {
        order.setId(idCounter);
        orders.add(order);
        updateIds();
    }

    private void updateIds() {
        idCounter ++;
    }

    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }
}
