package alura.com.br.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;

public class ListaAlunosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Lista de alunos");
        setContentView(R.layout.activity_lista_alunos);


        FloatingActionButton botaoNovo = findViewById(R.id.activity_lista_alunos_fab_novo_aluno);
        botaoNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ListaAlunosActivity.this, FormularioAlunoActivity.class));
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView listaAlunos = findViewById(R.id.activity_lista_alunos_list_view);
        AlunoDAO alunoDAO = new AlunoDAO();

        listaAlunos.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_expandable_list_item_1, alunoDAO.getList()));
    }
}
