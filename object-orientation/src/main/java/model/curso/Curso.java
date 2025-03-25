package model.curso;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;
import model.pessoa.Aluno;
import model.pessoa.Instrutor;

@Data
public class Curso {
	
    private String titulo;
    private String descricao;
    private BigDecimal preco;
    private Instrutor instrutor;
    private List<Modulo> modulos = new ArrayList<>();
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public Curso(String titulo, String descricao, BigDecimal preco, Instrutor instrutor) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.preco = preco;
        this.instrutor = instrutor;
    }
    
    public void adicionarModulo(Modulo modulo) {
        modulos.add(modulo);
    }
    
    public List<Aluno> listarAlunos() {
        return alunosMatriculados;
    }
    
    public void removerAluno(Aluno aluno) {
        alunosMatriculados.remove(aluno);
    }
    
    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }
}