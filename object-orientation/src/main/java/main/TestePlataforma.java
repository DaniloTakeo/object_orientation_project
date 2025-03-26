package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.curso.Curso;
import model.curso.Modulo;
import model.pagamento.Pagamento;
import model.pagamento.PagamentoCartao;
import model.pagamento.PagamentoPix;
import model.pagamento.PagamentoStatus;
import model.pessoa.Aluno;
import model.pessoa.Instrutor;

public class TestePlataforma {
	 private static List<Aluno> alunos = new ArrayList<>();
	    private static Scanner scanner = new Scanner(System.in);

	    public static void main(String[] args) {
	        menuAluno();
	        scanner.close();
	    }

	    private static void menuAluno() {
	        while (true) {
	            System.out.println("\n--- Menu Aluno ---");
	            System.out.println("1 - Criar Aluno");
	            System.out.println("2 - Listar Alunos");
	            System.out.println("3 - Atualizar Aluno");
	            System.out.println("4 - Deletar Aluno");
	            System.out.println("0 - Voltar");
	            System.out.print("Escolha uma opção: ");
	            int opcao = scanner.nextInt();
	            scanner.nextLine();

	            switch (opcao) {
	                case 1:
	                    criarAluno();
	                    break;
	                case 2:
	                    listarAlunos();
	                    break;
	                case 3:
	                    atualizarAluno();
	                    break;
	                case 4:
	                    deletarAluno();
	                    break;
	                case 0:
	                    return;
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	            }
	        }
	    }

	    private static void criarAluno() {
	        System.out.print("Nome do aluno: ");
	        String nome = scanner.nextLine();
	        System.out.print("Email do aluno: ");
	        String email = scanner.nextLine();
	        System.out.print("Senha do aluno: ");
	        String senha = scanner.nextLine();
	        System.out.print("Matrícula do aluno: ");
	        String matricula = scanner.nextLine();

	        Aluno aluno = Aluno.builder().matricula(matricula).nome(nome)
	        		.email(email).senha(senha).build();
	        alunos.add(aluno);
	        System.out.println("Aluno criado com sucesso!");
	    }

	    private static void listarAlunos() {
	        if (alunos.isEmpty()) {
	            System.out.println("Não há alunos cadastrados.");
	            return;
	        }
	        System.out.println("\n--- Lista de Alunos ---");
	        for (int i = 0; i < alunos.size(); i++) {
	            Aluno aluno = alunos.get(i);
	            System.out.println((i + 1) + ". Nome: " + aluno.getNome() + ", Email: " + aluno.getEmail() + ", Matrícula: " + aluno.getMatricula());
	        }
	    }

	    private static void atualizarAluno() {
	        listarAlunos();
	        if (alunos.isEmpty()) {
	            return;
	        }
	        System.out.print("Digite o número do aluno que deseja atualizar: ");
	        int indice = scanner.nextInt() - 1;
	        scanner.nextLine();

	        if (indice >= 0 && indice < alunos.size()) {
	            Aluno aluno = alunos.get(indice);
	            System.out.print("Novo nome do aluno (ou deixe em branco para manter o mesmo): ");
	            String novoNome = scanner.nextLine();
	            if (!novoNome.isEmpty()) {
	                aluno.setNome(novoNome);
	            }
	            System.out.print("Novo email do aluno (ou deixe em branco para manter o mesmo): ");
	            String novoEmail = scanner.nextLine();
	            if (!novoEmail.isEmpty()) {
	                aluno.setEmail(novoEmail);
	            }
	            System.out.print("Nova senha do aluno (ou deixe em branco para manter o mesmo): ");
	            String novaSenha = scanner.nextLine();
	            if (!novaSenha.isEmpty()) {
	                aluno.setSenha(novaSenha);
	            }
	            System.out.print("Nova matrícula do aluno (ou deixe em branco para manter o mesmo): ");
	            String novaMatricula = scanner.nextLine();
	            if (!novaMatricula.isEmpty()) {
	                aluno.setMatricula(novaMatricula);
	            }
	            System.out.println("Aluno atualizado com sucesso!");
	        } else {
	            System.out.println("Índice inválido.");
	        }
	    }

	    private static void deletarAluno() {
	        listarAlunos();
	        if (alunos.isEmpty()) {
	            return;
	        }
	        System.out.print("Digite o número do aluno que deseja deletar: ");
	        int indice = scanner.nextInt() - 1;
	        scanner.nextLine();

	        if (indice >= 0 && indice < alunos.size()) {
	            alunos.remove(indice);
	            System.out.println("Aluno deletado com sucesso!");
	        } else {
	            System.out.println("Índice inválido.");
	        }
	    }
}

