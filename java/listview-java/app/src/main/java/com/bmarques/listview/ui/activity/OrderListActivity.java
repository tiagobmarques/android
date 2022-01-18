package com.bmarques.listview.ui.activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bmarques.listview.R;
import com.bmarques.listview.dao.OrderDao;
import com.bmarques.listview.model.Order;

public class OrderListActivity extends AppCompatActivity {

    public static final String APP_BAR_TITLE = "Order List";
    private final OrderDao dao = new OrderDao();
    private ArrayAdapter<Order> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list);
        setTitle(APP_BAR_TITLE);
        configureList();

        inputOrdersMock();

    }

    private void inputOrdersMock() {
        dao.save(new Order("Tiago", 50D));
        dao.save(new Order("Samira", 10D));
        dao.save(new Order("Nicolas", 10D));
        dao.save(new Order("Valentina", 10D));
        dao.save(new Order("Carlos", 10D));
        dao.save(new Order("Roseli", 10D));
        dao.save(new Order("Alessandra", 10D));
        dao.save(new Order("Rafael", 10D));
        dao.save(new Order("André", 10D));
        dao.save(new Order("Daiane", 10D));
        dao.save(new Order("Caio", 10D));
        dao.save(new Order("Letícia", 10D));
        dao.save(new Order("Lívia", 10D));
        dao.save(new Order("Kelly", 10D));
        dao.save(new Order("Maikel", 10D));
        dao.save(new Order("Jair", 10D));
        dao.save(new Order("Leonete", 10D));
    }

    @Override
    protected void onResume() {
        super.onResume();
        atualizaAlunos();
    }

    private void atualizaAlunos() {
        adapter.clear();
        adapter.addAll(dao.findAll());
    }

    private void configureList() {
        ListView listaDeAlunos = findViewById(R.id.activity_order_list_listview);
        configuraAdapter(listaDeAlunos);
    }

    private void configuraAdapter(ListView orderListView) {
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1);
        orderListView.setAdapter(adapter);
    }
}
