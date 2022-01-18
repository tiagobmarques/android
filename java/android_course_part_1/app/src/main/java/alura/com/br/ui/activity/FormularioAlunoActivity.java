package alura.com.br.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import alura.com.br.R;
import alura.com.br.dao.AlunoDAO;
import alura.com.br.model.Aluno;

public class FormularioAlunoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Novo aluno");
        setContentView(R.layout.activity_formulario_aluno);
        AlunoDAO alunoDao = new AlunoDAO();
        Button botaoSalvar = findViewById(R.id.activity_formulario_aluno_botao_salvar);
        final EditText nomeALuno = findViewById(R.id.activity_formulario_aluno_nome);
        final EditText nomeTelefone = findViewById(R.id.activity_formulario_aluno_telefone);
        final EditText nomeEmail = findViewById(R.id.activity_formulario_aluno_email);

        botaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = nomeALuno.getText().toString();
                String telefone = nomeTelefone.getText().toString();
                String email = nomeEmail.getText().toString();

                Aluno aluno = new Aluno(nome, telefone, email);

                alunoDao.save(aluno);

                finish();
            }
        });
    }
}