package alura.com.br.dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.br.model.Aluno;

public class AlunoDAO {

    private final static List<Aluno> alunos = new ArrayList<>();

    public AlunoDAO() {
    }

    public void save(Aluno aluno) {
        alunos.add(aluno);
    }

    public List<Aluno> getList() {
        return alunos;
    }


}
