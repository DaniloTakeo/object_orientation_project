package main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
    private static List<Instrutor> instrutores = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Pagamento> pagamentos = new ArrayList<>(); 
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Menu Principal ---");
            System.out.println("1 - Aluno");
            System.out.println("2 - Instrutor");
            System.out.println("3 - Curso");
            System.out.println("4 - Pagamento");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuAluno();
                    break;
                case 2:
                    menuInstrutor();
                    break;
                case 3:
                    menuCurso();
                    break;
                case 4:
                	menuPagamento();
                	break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
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

    private static void menuInstrutor() {
        while (true) {
            System.out.println("\n--- Menu Instrutor ---");
            System.out.println("1 - Criar Instrutor");
            System.out.println("2 - Listar Instrutores");
            System.out.println("3 - Atualizar Instrutor");
            System.out.println("4 - Deletar Instrutor");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarInstrutor();
                    break;
                case 2:
                    listarInstrutores();
                    break;
                case 3:
                    atualizarInstrutor();
                    break;
                case 4:
                    deletarInstrutor();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarInstrutor() {
        System.out.print("Nome do instrutor: ");
        String nome = scanner.nextLine();
        System.out.print("Email do instrutor: ");
        String email = scanner.nextLine();
        System.out.print("Senha do instrutor: ");
        String senha = scanner.nextLine();
        System.out.print("Biografia do instrutor: ");
        String biografia = scanner.nextLine();
        Instrutor instrutor = Instrutor.builder().nome(nome).email(email)
        		.senha(senha).biografia(biografia).build();
        instrutores.add(instrutor);
        System.out.println("Instrutor criado com sucesso!");
    }

    private static void listarInstrutores() {
        if (instrutores.isEmpty()) {
            System.out.println("Não há instrutores cadastrados.");
            return;
        }
        System.out.println("\n--- Lista de Instrutores ---");
        for (int i = 0; i < instrutores.size(); i++) {
            Instrutor instrutor = instrutores.get(i);
            System.out.println((i + 1) + ". Nome: " + instrutor.getNome() + ", Email: " + instrutor.getEmail() + ", Biografia: " + instrutor.getBiografia());
        }
    }

    private static void atualizarInstrutor() {
        listarInstrutores();
        if (instrutores.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do instrutor que deseja atualizar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < instrutores.size()) {
            Instrutor instrutor = instrutores.get(indice);
            System.out.print("Novo nome do instrutor (ou deixe em branco para manter o mesmo): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                instrutor.setNome(novoNome);
            }
            System.out.print("Novo email do instrutor (ou deixe em branco para manter o mesmo): ");
            String novoEmail = scanner.nextLine();
            if (!novoEmail.isEmpty()) {
                instrutor.setEmail(novoEmail);
            }
            System.out.print("Nova senha do instrutor (ou deixe em branco para manter o mesmo): ");
            String novaSenha = scanner.nextLine();
            if (!novaSenha.isEmpty()) {
                instrutor.setSenha(novaSenha);
            }
            System.out.print("Nova biografia do instrutor (ou deixe em branco para manter o mesmo): ");
            String novaBiografia = scanner.nextLine();
            if (!novaBiografia.isEmpty()) {
                instrutor.setBiografia(novaBiografia);
            }
            System.out.println("Instrutor atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void deletarInstrutor() {
        listarInstrutores();
        if (instrutores.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do instrutor que deseja deletar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < instrutores.size()) {
            instrutores.remove(indice);
            System.out.println("Instrutor deletado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void menuCurso() {
        while (true) {
            System.out.println("\n--- Menu Curso ---");
            System.out.println("1 - Criar Curso");
            System.out.println("2 - Listar Cursos");
            System.out.println("3 - Atualizar Curso");
            System.out.println("4 - Deletar Curso");
            System.out.println("5 - Adicionar Aluno ao Curso");
            System.out.println("6 - Adicionar Módulo ao Curso");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarCurso();
                    break;
                case 2:
                    listarCursos();
                    break;
                case 3:
                    atualizarCurso();
                    break;
                case 4:
                    deletarCurso();
                    break;
                case 5:
                    adicionarAlunoAoCurso();
                    break;
                case 6:
                    adicionarModuloAoCurso();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarCurso() {
        System.out.print("Título do curso: ");
        String titulo = scanner.nextLine();
        System.out.print("Descrição do curso: ");
        String descricao = scanner.nextLine();
        System.out.print("Preço do curso: ");
        double precoDouble = scanner.nextDouble();
        BigDecimal preco = BigDecimal.valueOf(precoDouble);
        System.out.println("Instrutor responsável: ");
        String instrutorNome = scanner.nextLine();
        Optional<Instrutor> instrutor = instrutores.stream().filter(i -> i.getNome().equals(instrutorNome)).findFirst();
        
        scanner.nextLine();

        Curso curso = new Curso(titulo, descricao, preco, instrutor.get(), new ArrayList<>(), new ArrayList<>());
        cursos.add(curso);
        System.out.println("Curso criado com sucesso!");
    }

    private static void listarCursos() {
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return;
        }
        System.out.println("\n--- Lista de Cursos ---");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            System.out.println((i + 1) + ". Título: " + curso.getTitulo() + ", Descrição: " + curso.getDescricao() + ", Preço: " + curso.getPreco());
        }
    }

    private static void atualizarCurso() {
        listarCursos();
        if (cursos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do curso que deseja atualizar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < cursos.size()) {
            Curso curso = cursos.get(indice);
            System.out.print("Novo título do curso (ou deixe em branco para manter o mesmo): ");
            String novoTitulo = scanner.nextLine();
            if (!novoTitulo.isEmpty()) {
                curso.setTitulo(novoTitulo);
            }
            System.out.print("Nova descrição do curso (ou deixe em branco para manter o mesmo): ");
            String novaDescricao = scanner.nextLine();
            if (!novaDescricao.isEmpty()) {
                curso.setDescricao(novaDescricao);
            }
            System.out.print("Novo preço do curso (ou deixe em branco para manter o mesmo): ");
            if (scanner.hasNextDouble()) {
                double novoPrecoDouble = scanner.nextDouble();
                BigDecimal novoPreco = BigDecimal.valueOf(novoPrecoDouble);
                scanner.nextLine();
                curso.setPreco(novoPreco);
            }
            System.out.println("Curso atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void deletarCurso() {
        listarCursos();
        if (cursos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do curso que deseja deletar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < cursos.size()) {
            cursos.remove(indice);
            System.out.println("Curso deletado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void adicionarAlunoAoCurso() {
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return;
        }
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return;
        }

        listarCursos();
        System.out.print("Digite o número do curso: ");
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        listarAlunos();
        System.out.print("Digite o número do aluno: ");
        int alunoIndex = scanner.nextInt() - 1;
        scanner.nextLine();

        if (cursoIndex >= 0 && cursoIndex < cursos.size() && alunoIndex >= 0 && alunoIndex < alunos.size()) {
            Curso curso = cursos.get(cursoIndex);
            Aluno aluno = alunos.get(alunoIndex);
            curso.getAlunosMatriculados().add(aluno);
            System.out.println("Aluno adicionado ao curso com sucesso!");
        } else {
            System.out.println("Índice de curso ou aluno inválido.");
        }
    }

    private static void adicionarModuloAoCurso() {
        listarCursos();
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return;
        }

        System.out.print("Digite o número do curso ao qual deseja adicionar um módulo: ");
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        scanner.nextLine();

        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            Curso curso = cursos.get(cursoIndex);
            System.out.print("Título do módulo: ");
            String tituloModulo = scanner.nextLine();

            Modulo modulo = new Modulo(tituloModulo, new ArrayList<>());
            curso.adicionarModulo(modulo);
            System.out.println("Módulo adicionado ao curso com sucesso!");
        } else {
            System.out.println("Índice de curso inválido.");
        }
    }
    
    private static void menuPagamento() {
        while (true) {
            System.out.println("\n--- Menu Pagamento ---");
            System.out.println("1 - Criar Pagamento");
            System.out.println("2 - Listar Pagamentos");
            System.out.println("3 - Atualizar Pagamento");
            System.out.println("4 - Deletar Pagamento");
            System.out.println("0 - Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    criarPagamento();
                    break;
                case 2:
                    listarPagamentos();
                    break;
                case 3:
                    atualizarPagamento();
                    break;
                case 4:
                    deletarPagamento();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static void criarPagamento() {
        System.out.print("Tipo de Pagamento (1 - Cartão, 2 - Pix): ");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        if (tipo != 1 && tipo != 2) {
            System.out.println("Tipo de pagamento inválido.");
            return;
        }

        System.out.print("Valor do pagamento: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Data de Vencimento (AAAA-MM-DD): ");
        String dataVencimento = scanner.nextLine();

        Aluno aluno = selecionarAluno();
        if (aluno == null) return;  
        Curso curso = selecionarCurso();
        if (curso == null) return;

        Pagamento pagamento;
        if (tipo == 1) {
            System.out.print("Número do Cartão: ");
            String numeroCartao = scanner.nextLine();
            System.out.print("Nome do Titular do Cartão: ");
            String nomeTitular = scanner.nextLine();
            System.out.print("Data de Validade do Cartão (MM/AAAA): ");
            String dataValidade = scanner.nextLine();
            System.out.print("CVV do Cartão: ");
            String cvv = scanner.nextLine();
            pagamento = PagamentoCartao.builder().valor(BigDecimal.valueOf(valor)).aluno(aluno)
            		.curso(curso).status(PagamentoStatus.PAGO).bandeira("MasterCard")
            		.numeroCartao(numeroCartao).nomeTitular(nomeTitular).dataValidade(dataValidade)
            		.cvv(cvv).build();
        } else {
            System.out.print("Tempo de Expiração (em segundos): ");
            int tempoExpiracao = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Chave Pix: ");
            String chavePix = scanner.nextLine();
            pagamento = PagamentoPix.builder().valor(BigDecimal.valueOf(valor)).dataVencimento(dataVencimento)
            		.aluno(aluno).curso(curso).tempoExpiracao(tempoExpiracao).chavePix(chavePix)
            		.build();
        }

        pagamentos.add(pagamento);
        System.out.println("Pagamento criado com sucesso!");
    }

    private static void listarPagamentos() {
        if (pagamentos.isEmpty()) {
            System.out.println("Não há pagamentos cadastrados.");
            return;
        }
        System.out.println("\n--- Lista de Pagamentos ---");
        for (int i = 0; i < pagamentos.size(); i++) {
            Pagamento pagamento = pagamentos.get(i);
            System.out.println((i + 1) + ". " + pagamento.toString());
        }
    }

    private static void atualizarPagamento() {
        listarPagamentos();
        if (pagamentos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do pagamento que deseja atualizar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < pagamentos.size()) {
            Pagamento pagamento = pagamentos.get(indice);

            System.out.print("Novo valor do pagamento (ou deixe em branco para manter o mesmo): ");
            if (scanner.hasNextDouble()) {
                double novoValor = scanner.nextDouble();
                scanner.nextLine();
                pagamento.setValor(BigDecimal.valueOf(novoValor));
            }

            System.out.print("Nova data de vencimento (AAAA-MM-DD) (ou deixe em branco para manter a mesma): ");
            String novaDataVencimento = scanner.nextLine();
            if (!novaDataVencimento.isEmpty()) {
                pagamento.setDataVencimento(novaDataVencimento);
            }

             if (pagamento instanceof PagamentoCartao) {
                System.out.print("Novo número do cartão (ou deixe em branco para manter o mesmo): ");
                String novoNumeroCartao = scanner.nextLine();
                if (!novoNumeroCartao.isEmpty()) {
                    ((PagamentoCartao) pagamento).setNumeroCartao(novoNumeroCartao);
                }
                System.out.print("Novo nome do titular do cartão (ou deixe em branco para manter o mesmo): ");
                String novoNomeTitular = scanner.nextLine();
                if (!novoNomeTitular.isEmpty()) {
                    ((PagamentoCartao) pagamento).setNomeTitular(novoNomeTitular);
                }
                System.out.print("Nova data de validade do cartão (MM/AAAA) (ou deixe em branco para manter a mesma): ");
                String novaDataValidade = scanner.nextLine();
                if (!novaDataValidade.isEmpty()) {
                    ((PagamentoCartao) pagamento).setDataValidade(novaDataValidade);
                }
                System.out.print("Novo CVV do cartão (ou deixe em branco para manter o mesmo): ");
                String novoCvv = scanner.nextLine();
                if (!novoCvv.isEmpty()) {
                    ((PagamentoCartao) pagamento).setCvv(novoCvv);
                }
            } else if (pagamento instanceof PagamentoPix) {
                System.out.print("Novo tempo de expiração (em segundos) (ou deixe em branco para manter o mesmo): ");
                if (scanner.hasNextInt()) {
                    int novoTempoExpiracao = scanner.nextInt();
                    scanner.nextLine();
                    ((PagamentoPix) pagamento).setTempoExpiracao(novoTempoExpiracao);
                }
                 System.out.print("Nova Chave Pix (ou deixe em branco para manter o mesmo): ");
                String novaChavePix = scanner.nextLine();
                if (!novaChavePix.isEmpty()) {
                    ((PagamentoPix) pagamento).setChavePix(novaChavePix);
                }
            }
            System.out.println("Pagamento atualizado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static void deletarPagamento() {
        listarPagamentos();
        if (pagamentos.isEmpty()) {
            return;
        }
        System.out.print("Digite o número do pagamento que deseja deletar: ");
        int indice = scanner.nextInt() - 1;
        scanner.nextLine();

        if (indice >= 0 && indice < pagamentos.size()) {
            pagamentos.remove(indice);
            System.out.println("Pagamento deletado com sucesso!");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    private static Aluno selecionarAluno() {
        if (alunos.isEmpty()) {
            System.out.println("Não há alunos cadastrados.");
            return null;
        }
        System.out.println("\n--- Lista de Alunos ---");
        for (int i = 0; i < alunos.size(); i++) {
            Aluno aluno = alunos.get(i);
            System.out.println((i + 1) + ". Nome: " + aluno.getNome());
        }
        System.out.print("Digite o número do aluno: ");
        int alunoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (alunoIndex >= 0 && alunoIndex < alunos.size()) {
            return alunos.get(alunoIndex);
        } else {
            System.out.println("Índice de aluno inválido.");
            return null;
        }
    }

    private static Curso selecionarCurso() {
        if (cursos.isEmpty()) {
            System.out.println("Não há cursos cadastrados.");
            return null;
        }
        System.out.println("\n--- Lista de Cursos ---");
        for (int i = 0; i < cursos.size(); i++) {
            Curso curso = cursos.get(i);
            System.out.println((i + 1) + ". Título: " + curso.getTitulo());
        }
        System.out.print("Digite o número do curso: ");
        int cursoIndex = scanner.nextInt() - 1;
        scanner.nextLine();
        if (cursoIndex >= 0 && cursoIndex < cursos.size()) {
            return cursos.get(cursoIndex);
        } else {
            System.out.println("Índice de curso inválido.");
            return null;
        }
    }
}
