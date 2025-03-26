package main;

import java.math.BigDecimal;

import model.curso.Curso;
import model.pagamento.Pagamento;
import model.pagamento.PagamentoCartao;
import model.pessoa.Aluno;
import model.pessoa.Instrutor;

public class TestePlataforma {
    public static void main(String[] args) {
        Instrutor instrutor = new Instrutor();
        instrutor.setNome("Carlos Silva");
        
        Curso curso = instrutor.criarCurso("Java Básico", "Curso introdutório de Java", new BigDecimal("99.99"));
        
        Aluno aluno = new Aluno();
        aluno.setNome("Maria Souza");
        aluno.inscreverNoCurso(curso);
        
        System.out.println("O curso " + curso.getTitulo() + " foi criado por " + instrutor.getNome());
        System.out.println("Aluno " + aluno.getNome() + " inscrito no curso: " + aluno.getListaDeCursos().get(0).getTitulo());
        
        Pagamento pagamento = new PagamentoCartao();
        pagamento.pagar(new BigDecimal("99.99"));
        System.out.println("Status do pagamento: " + pagamento.consultarStatus());
    }
}