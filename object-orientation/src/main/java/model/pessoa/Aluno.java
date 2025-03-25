package model.pessoa;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import model.curso.Curso;

@Data
public class Aluno extends Pessoa {
	
    private String matricula;
    private List<Curso> listaDeCursos = new ArrayList<>();

    public void inscreverNoCurso(Curso curso) {
        listaDeCursos.add(curso);
        curso.adicionarAluno(this);
    }
    
    public List<Curso> listarCursos() {
        return listaDeCursos;
    }
}