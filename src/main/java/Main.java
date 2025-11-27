import entities.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Aluno> alunos = new ArrayList<>();
    private static List<Professor> professores = new ArrayList<>();
    private static List<Turma> turmas = new ArrayList<>();
    private static List<Curso> cursos = new ArrayList<>();
    private static List<Disciplina> disciplinas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean executando = true;

        inicializarDadosFicticios();

        System.out.println("=== SISTEMA DE GESTÃO ACADÊMICA ===");

        while (executando) {
            exibirMenu();
            int opcao = lerInteiro(scanner);

            switch (opcao) {
                case 1:
                    cadastrarAluno(scanner);
                    break;
                case 2:
                    cadastrarProfessor(scanner);
                    break;
                case 3:
                    criarTurma(scanner);
                    break;
                case 4:
                    matricularAluno(scanner);
                    break;
                case 5:
                    exibirRelatorioGeral();
                    break;
                case 0:
                    System.out.println("Encerrando sistema...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- MENU ---");
        System.out.println("1. Cadastrar Aluno");
        System.out.println("2. Cadastrar Professor");
        System.out.println("3. Criar Nova Turma");
        System.out.println("4. Matricular Aluno em Turma");
        System.out.println("5. Exibir Relatório Geral");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static void cadastrarAluno(Scanner scanner) {
        System.out.println("\n--- Novo Aluno ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Data Nascimento (dd/mm/aaaa): ");
        String dataNasc = scanner.nextLine();

        Aluno novoAluno = new Aluno(nome, sobrenome, email, dataNasc);
        alunos.add(novoAluno);
        System.out.println("Aluno cadastrado com Sucesso! Matrícula: " + novoAluno.getMatricula());
    }

    private static void cadastrarProfessor(Scanner scanner) {
        System.out.println("\n--- Novo Professor ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Sobrenome: ");
        String sobrenome = scanner.nextLine();
        System.out.print("Especialidade: ");
        String especialidade = scanner.nextLine();

        Professor novoProf = new Professor(nome, sobrenome, nome.toLowerCase()+"@escola.com", "01/01/1980", especialidade);
        professores.add(novoProf);
        System.out.println("Professor cadastrado!");
    }

    private static void criarTurma(Scanner scanner) {
        if (professores.isEmpty()) {
            System.out.println("ERRO: Cadastre um professor antes de criar uma turma.");
            return;
        }

        System.out.println("\n--- Nova Turma ---");
        System.out.print("Código da Turma (Ex: T01): ");
        String codigo = scanner.nextLine();

        System.out.print("Nome do Curso (Ex: Eng. Software): ");
        String nomeCurso = scanner.nextLine();
        Curso curso = new Curso(nomeCurso);
        cursos.add(curso);

        System.out.print("Nome da Disciplina (Ex: POO): ");
        String nomeDisc = scanner.nextLine();
        Disciplina disciplina = new Disciplina(nomeDisc, 60);
        disciplinas.add(disciplina);

        System.out.println("Selecione o Professor:");
        for (int i = 0; i < professores.size(); i++) {
            System.out.println(i + ". " + professores.get(i).getNomeCompleto());
        }
        int indexProf = lerInteiro(scanner);

        if (indexProf >= 0 && indexProf < professores.size()) {
            Turma novaTurma = new Turma(codigo, curso, disciplina, professores.get(indexProf));
            turmas.add(novaTurma);
            System.out.println("Turma criada com sucesso!");
        } else {
            System.out.println("Professor inválido.");
        }
    }

    private static void matricularAluno(Scanner scanner) {
        if (turmas.isEmpty() || alunos.isEmpty()) {
            System.out.println("ERRO: É necessário ter turmas e alunos cadastrados.");
            return;
        }

        System.out.println("\n--- Matrícula ---");

        System.out.println("Escolha a Turma:");
        for (int i = 0; i < turmas.size(); i++) {
            Turma t = turmas.get(i);
            System.out.println(i + ". " + t.getCodigoTurma() + " - " + t.getDisciplina().getNome());
        }
        int indexTurma = lerInteiro(scanner);

        System.out.println("Escolha o Aluno:");
        for (int i = 0; i < alunos.size(); i++) {
            System.out.println(i + ". " + alunos.get(i).getNomeCompleto());
        }
        int indexAluno = lerInteiro(scanner);

        if (indexTurma >= 0 && indexTurma < turmas.size() && indexAluno >= 0 && indexAluno < alunos.size()) {
            Turma turmaSelecionada = turmas.get(indexTurma);
            Aluno alunoSelecionado = alunos.get(indexAluno);

            turmaSelecionada.matricularAluno(alunoSelecionado);
            System.out.println("Aluno matriculado na turma " + turmaSelecionada.getCodigoTurma());
        } else {
            System.out.println("Seleção inválida.");
        }
    }

    private static void exibirRelatorioGeral() {
        System.out.println("\n=== RELATÓRIO ===");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
        }
        for (Turma t : turmas) {
            System.out.println("-------------------------");
            System.out.println("Turma: " + t.getCodigoTurma());
            System.out.println("Curso: " + t.getCurso().getNome());
            System.out.println("Disciplina: " + t.getDisciplina().getNome());
            System.out.println("Professor: " + t.getProfessor().getNomeCompleto());
            System.out.println("Alunos Matriculados: " + t.getAlunosMatriculados().size());

            for (Aluno a : t.getAlunosMatriculados()) {
                System.out.println(" - " + a.getNomeCompleto() + " (" + a.getMatricula() + ")");
            }
        }
        System.out.println("-------------------------");
    }

    private static int lerInteiro(Scanner scanner) {
        try {
            int numero = Integer.parseInt(scanner.nextLine());
            return numero;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void inicializarDadosFicticios() {
        Professor p1 = new Professor("João", "Silva", "joao@prof.com", "1980-05-20", "Java");
        professores.add(p1);

        Aluno a1 = new Aluno("Maria", "Souza", "maria@gmail.com", "2000-10-10");
        Aluno a2 = new Aluno("Pedro", "Santos", "pedro@hotmail.com", "2001-05-15");
        alunos.add(a1);
        alunos.add(a2);
    }
}