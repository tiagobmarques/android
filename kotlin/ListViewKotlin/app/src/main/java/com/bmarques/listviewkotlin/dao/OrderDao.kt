package com.bmarques.listviewkotlin.dao

import com.bmarques.listviewkotlin.model.Order
import java.util.ArrayList

class OrderDao {

    var orders = ArrayList<Order>()
    var idCounter = 1

    fun save(order: Order) {
        order.updateIds(idCounter)
        orders.add(order)
        updateIds()
    }

    private fun updateIds() {
        idCounter++
    }

    fun findAll(): List<Order> {
        return orders
    }

}
