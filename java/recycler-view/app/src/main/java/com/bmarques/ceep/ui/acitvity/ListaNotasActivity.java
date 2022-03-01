package com.bmarques.ceep.ui.acitvity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bmarques.R;
import com.bmarques.ceep.dao.NotaDAO;
import com.bmarques.ceep.model.Nota;
import com.bmarques.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

import java.io.Serializable;
import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {

    private ListaNotasAdapter adapter;
    private List<Nota> todasNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        todasNotas = notasDeExemplo();

        configuraRecyclerView(todasNotas);

        TextView insereNotas = findViewById(R.id.lista_notas_insere_nota);
        insereNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciaFormularioNota = new Intent(ListaNotasActivity.this, FormulatioNotaActivity.class);
                startActivityForResult(iniciaFormularioNota, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 1 && resultCode == 2 && data.hasExtra("nota")) {
            Nota nota = (Nota) data.getSerializableExtra("nota");
            new NotaDAO().insere(nota);
            adapter.adiciona(nota);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    private List<Nota> notasDeExemplo() {
        NotaDAO dao = new NotaDAO();
        for (int i = 0; i < 2; i++) {
            dao.insere(new Nota("Title " + i,
                    "Description" + i));
        }

        return dao.todos();
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listadeNotas = findViewById(R.id.lista_notas_recyclerview);
        configurarAdapter(todasNotas, listadeNotas);
//        configuraLayoutManager(listadeNotas);
    }

//    private void configuraLayoutManager(RecyclerView listadeNotas) {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
//        listadeNotas.setLayoutManager(linearLayoutManager);
//    }

    private void configurarAdapter(List<Nota> todasNotas, RecyclerView listadeNotas) {
        adapter = new ListaNotasAdapter(this, todasNotas);
        listadeNotas.setAdapter(adapter);
    }
}