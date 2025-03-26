package model.curso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.pessoa.Aluno;
import model.pessoa.Instrutor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Curso {
	private String titulo;
	private String descricao;
	private BigDecimal preco;
	private Instrutor instrutor;
	private List<Modulo> modulos;
	private List<Aluno> alunosMatriculados;

	public void adicionarModulo(Modulo modulo) {
		if (modulos == null) {
			modulos = new ArrayList<>();
		}
		modulos.add(modulo);
	}

	public void removerAluno(Aluno aluno) {
		if (alunosMatriculados == null) {
			alunosMatriculados = new ArrayList<>();
		}
		alunosMatriculados.remove(aluno);
	}

	public List<Aluno> listarAlunos() {
		return alunosMatriculados;
	}

	public List<Modulo> listarModulos() {
		return modulos;
	}
}