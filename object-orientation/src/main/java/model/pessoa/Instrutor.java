package model.pessoa;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import model.curso.Curso;

@Data
public class Instrutor extends Pessoa {
	
    private String biografia;
    private List<Curso> cursosCriados = new ArrayList<>();

    public Curso criarCurso(String titulo, String descricao, BigDecimal preco) {
        Curso curso = new Curso(titulo, descricao, preco, this);
        cursosCriados.add(curso);
        return curso;
    }
}