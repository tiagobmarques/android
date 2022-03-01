package com.bmarques.ceep.ui.acitvity;

import static com.bmarques.ceep.ui.acitvity.NotaActivityConstantes.CHAVE_NOTA;
import static com.bmarques.ceep.ui.acitvity.NotaActivityConstantes.CODIGO_REQUISICAO_INSERE_NOTA;
import static com.bmarques.ceep.ui.acitvity.NotaActivityConstantes.CODIGO_RESULTADO_NOTA_CRIADA;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.bmarques.R;
import com.bmarques.ceep.dao.NotaDAO;
import com.bmarques.ceep.model.Nota;
import com.bmarques.ceep.ui.recyclerview.adapter.ListaNotasAdapter;

import java.util.List;

public class ListaNotasActivity extends AppCompatActivity {


    private ListaNotasAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_notas);

        List<Nota> todasNotas = pegaTodasNotas();

        configuraRecyclerView(todasNotas);

        configuraBotaoInsereNota();
    }

    private void configuraBotaoInsereNota() {
        TextView insereNotas = findViewById(R.id.lista_notas_insere_nota);
        insereNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vaiParaFormularioNotaActivity();
            }
        });
    }

    private void vaiParaFormularioNotaActivity() {
        Intent iniciaFormularioNota = new Intent(ListaNotasActivity.this, FormulatioNotaActivity.class);
        startActivityForResult(iniciaFormularioNota, CODIGO_REQUISICAO_INSERE_NOTA);
    }

    private List<Nota> pegaTodasNotas() {
        NotaDAO dao = new NotaDAO();
        List<Nota> todasNotas = dao.todos();
        return todasNotas;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (ehResultadoComNota(requestCode, resultCode, data)) {
            Nota notaRecebida = (Nota) data.getSerializableExtra(CHAVE_NOTA);
            adiciona(notaRecebida);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    private void adiciona(Nota nota) {
        new NotaDAO().insere(nota);
        adapter.adiciona(nota);
    }

    private boolean ehResultadoComNota(int requestCode, int resultCode, @Nullable Intent data) {
        return ehCodigoRequisicaoInsereNota(requestCode) && ehCodigoResultadoNotaCriada(resultCode) && temNota(data);
    }

    private boolean temNota(@Nullable Intent data) {
        return data.hasExtra(CHAVE_NOTA);
    }

    private boolean ehCodigoResultadoNotaCriada(int resultCode) {
        return resultCode == CODIGO_RESULTADO_NOTA_CRIADA;
    }

    private boolean ehCodigoRequisicaoInsereNota(int requestCode) {
        return requestCode == CODIGO_REQUISICAO_INSERE_NOTA;
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