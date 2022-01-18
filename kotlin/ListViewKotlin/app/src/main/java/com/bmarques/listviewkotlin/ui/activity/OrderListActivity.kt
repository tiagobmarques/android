package com.bmarques.listviewkotlin.ui.activity

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.bmarques.listviewkotlin.R
import com.bmarques.listviewkotlin.dao.OrderDao
import com.bmarques.listviewkotlin.model.Order

class OrderListActivity : AppCompatActivity() {
    private val dao: OrderDao = OrderDao()
    private var adapter: ArrayAdapter<Order>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order_list)
        title = APP_BAR_TITLE
        configureList()
        inputOrdersMock()
    }

    private fun inputOrdersMock() {

        var order = Order("Tiago", 50.0)

        dao.save(Order("Tiago", 50.0,))
        dao.save(Order("Samira", 10.0,))
        dao.save(Order("Nicolas", 10.0,))
        dao.save(Order("Valentina", 10.0,))
        dao.save(Order("Carlos", 10.0,))
        dao.save(Order("Roseli", 10.0,))
        dao.save(Order("Alessandra", 10.0,))
        dao.save(Order("Rafael", 10.0,))
        dao.save(Order("André", 10.0,))
        dao.save(Order("Daiane", 10.0,))
        dao.save(Order("Caio", 10.0,))
        dao.save(Order("Letícia", 10.0,))
        dao.save(Order("Lívia", 10.0,))
        dao.save(Order("Kelly", 10.0,))
        dao.save(Order("Maikel", 10.0,))
        dao.save(Order("Jair", 10.0,))
        dao.save(Order("Leonete", 10.0,))
    }

    override fun onResume() {
        super.onResume()
        atualizaAlunos()
    }

    private fun atualizaAlunos() {
        adapter!!.clear()
        adapter!!.addAll(dao.findAll())
    }

    private fun configureList() {
        val listaDeAlunos = findViewById<ListView>(R.id.activity_order_list_listview)
        configuraAdapter(listaDeAlunos)
    }

    private fun configuraAdapter(orderListView: ListView) {
        adapter = ArrayAdapter<Order>(
            this,
            android.R.layout.simple_list_item_1
        )
        orderListView.adapter = adapter
    }

    companion object {
        const val APP_BAR_TITLE = "Order List - Kotlin"
    }
}
