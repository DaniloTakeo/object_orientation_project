# Plataforma de Cursos Online

Este projeto implementa uma plataforma de cursos online utilizando os conceitos de Programação Orientada a Objetos (POO) em Java.

## 📌 Funcionalidades
- Criar e gerenciar cursos
- Inscrever alunos nos cursos
- Processar pagamentos via Cartão ou Pix
- Avaliação dos cursos pelos alunos
- Organização dos cursos em módulos e aulas

## 📄 Diagrama UML

A estrutura do sistema é representada pelo seguinte diagrama UML:

![Diagrama UML](https://github.com/DaniloTakeo/object_orientation_project/blob/main/object-orientation/src/main/resources/diagrama%20de%20classes.png)

## 🚀 Tecnologias Utilizadas
- Java (POO puro, sem frameworks)
- Collections (List, ArrayList)
- Enum para controle de status de pagamento
- Interface para serviços de pagamento
- Lombok para códigos boiler plate

## 🎯 Como Executar

1. Clone o repositório:
   ```bash
   git clone git@github.com:DaniloTakeo/object_orientation_project.git
   ```
2. Compile e execute o projeto:
   ```bash
   javac *.java && java TestePlataforma
   ```

## Funcionamento do Menu
Menu Principal
O programa começa com um menu principal que oferece as seguintes opções:
1 - Aluno: Acessa o submenu de gerenciamento de alunos.

2 - Instrutor: Acessa o submenu de gerenciamento de instrutores.

3 - Curso: Acessa o submenu de gerenciamento de cursos.

4 - Pagamento: Acessa o submenu de gerenciamento de pagamentos.

0 - Sair: Encerra o programa.

O programa utiliza um loop while para exibir o menu repetidamente até que o usuário escolha a opção "0 - Sair". A entrada do usuário é lida usando a classe Scanner.


Submenu Aluno

Este submenu permite realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em alunos:

1 - Criar Aluno: Permite cadastrar um novo aluno, solicitando nome, email, senha e matrícula.

2 - Listar Alunos: Exibe todos os alunos cadastrados.

3 - Atualizar Aluno: Permite modificar os dados de um aluno existente.

4 - Deletar Aluno: Remove um aluno do sistema.

0 - Voltar: Retorna ao menu principal.


Submenu Instrutor

Semelhante ao submenu de alunos, este submenu permite gerenciar instrutores:

1 - Criar Instrutor: Cadastra um novo instrutor, solicitando nome, email, senha e biografia.

2 - Listar Instrutores: Exibe todos os instrutores cadastrados.

3 - Atualizar Instrutor: Permite modificar os dados de um instrutor.

4 - Deletar Instrutor: Remove um instrutor do sistema.

0 - Voltar: Retorna ao menu principal.


Submenu Curso

Este submenu oferece funcionalidades para gerenciar cursos:

1 - Criar Curso: Cadastra um novo curso, solicitando título, descrição e preço.

2 - Listar Cursos: Exibe todos os cursos cadastrados.

3 - Atualizar Curso: Permite modificar os dados de um curso.

4 - Deletar Curso: Remove um curso do sistema.

5 - Adicionar Aluno ao Curso: Permite vincular um aluno a um curso.

6 - Adicionar Módulo ao Curso: Permite adicionar um módulo a um curso.

0 - Voltar: Retorna ao menu principal.

Submenu Pagamento

Este submenu é usado para gerenciar pagamentos:

1 - Criar Pagamento: Permite registrar um novo pagamento, solicitando o tipo (Cartão ou Pix), valor, data de vencimento, aluno e curso.

2 - Listar Pagamentos: Exibe todos os pagamentos registrados.

3 - Atualizar Pagamento: Permite modificar os dados de um pagamento existente.

4 - Deletar Pagamento: Remove um pagamento do sistema.

0 - Voltar: Retorna ao menu principal.


Em resumo, o código fornece uma estrutura de menu interativa para gerenciar diferentes entidades do sistema (alunos, instrutores, cursos e pagamentos) através de operações CRUD.

## 📌 Melhorias Futuras
- Implementar persistência dos dados (Banco de Dados ou arquivos)
- Criar interface gráfica ou API REST
- Adicionar autenticação e controle de usuários

---
📌 **Autor:** Danilo Takeo Kanizawa

