package com.bmarques.listviewkotlin.model

import java.io.Serializable

class Order(val client: String, val value: Double) : Serializable {

    var id: Int = 0
        private set

    fun updateIds(newId: Int) {
        id = newId
    }

    override fun toString(): String {
        return client
    }

}
