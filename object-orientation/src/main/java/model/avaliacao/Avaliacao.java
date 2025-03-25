package model.avaliacao;

import java.util.List;

import lombok.Data;
import model.curso.Curso;
import model.pessoa.Aluno;

@Data
public class Avaliacao {
	
    private Aluno aluno;
    private Curso curso;
    private double nota;
    private String comentario;

    public static double calcularMedia(List<Avaliacao> avaliacoes) {
        return avaliacoes.stream().mapToDouble(a -> a.nota).average().orElse(0.0);
    }
}