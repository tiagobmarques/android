package com.bmarques.ceep.ui.acitvity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bmarques.R;
import com.bmarques.ceep.dao.NotaDAO;
import com.bmarques.ceep.model.Nota;
import com.bmarques.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        RecyclerView listadeNotas = findViewById(R.id.lista_notas_recyclerview);

        NotaDAO dao = new NotaDAO();
        for (int i = 0; i < 10000; i++) {
            dao.insere(new Nota("Title " + i,
                    "Description" + i));
        }

        List<Nota> todasNotas = dao.todos();
        listadeNotas.setAdapter(new ListaNotasAdapter(this, todasNotas));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        listadeNotas.setLayoutManager(linearLayoutManager);
    }
}