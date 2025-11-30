import entities.*;
import entities.valueObjects.*;
import enums.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Aluno> alunos = new ArrayList<>();
    private static final List<Professor> professores = new ArrayList<>();
    private static final List<Curso> cursos = new ArrayList<>();
    private static final List<Disciplina> disciplinas = new ArrayList<>();
    private static final List<Turma> turmas = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);

    private static final DateTimeFormatter DATA_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static int proximoNumeroMatricula = 2025001;

    public static void main(String[] args) {
        System.out.println("Bem-vindo ao Sistema Acadêmico SOL - PUC Goiás");
        boolean executando = true;

        // gerarDadosMockados();
        while (executando) {
            exibirMenu();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1 -> listarAlunos();
                case 2 -> listarProfessores();
                case 3 -> listarCursos();
                case 4 -> listarDisciplinas();
                case 5 -> listarTurmas();
                case 6 -> cadastrarAluno();
                case 7 -> cadastrarProfessor();
                case 8 -> cadastrarCurso();
                case 9 -> cadastrarDisciplina();
                case 10 -> cadastrarTurma();
                case 11 -> vincularAlunoACurso();
                case 12 -> matricularAlunoEmTurma();
                case 13 -> inativarAluno();
                case 14 -> {
                    System.out.println("Encerrando o sistema... Obrigado por usar o SOL!");
                    executando = false;
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
            if (executando) pausar();
        }
        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("          SISTEMA ACADÊMICO SOL - MENU PRINCIPAL");
        System.out.println("=".repeat(60));

        System.out.println(" 1. Listar Alunos");
        System.out.println(" 2. Listar Professores");
        System.out.println(" 3. Listar Cursos");
        System.out.println(" 4. Listar Disciplinas");
        System.out.println(" 5. Listar Turmas");
        System.out.println(" 6. Cadastrar Aluno");
        System.out.println(" 7. Cadastrar Professor");
        System.out.println(" 8. Cadastrar Curso");
        System.out.println(" 9. Cadastrar Disciplina");
        System.out.println(" 10. Cadastrar Turma");
        System.out.println(" 11. Vincular Aluno a um Curso");
        System.out.println(" 12. Matricular Aluno em Turma");
        System.out.println(" 13. Inativar Aluno");
        System.out.println("\n 14. Sair");

        System.out.println("-".repeat(60));
        System.out.print("→ Digite a opção desejada: ");
    }

    private static void listarAlunos() {
        System.out.println("\n>>> RELATÓRIO DE ALUNOS");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        System.out.printf("%-10s | %-25s | %-20s | %-10s%n", "MATRÍCULA", "NOME", "CURSO", "STATUS");
        System.out.println("-".repeat(75));

        for (Aluno a : alunos) {
            String status = String.valueOf(a.ehAtivo() ? StatusAluno.ATIVO : StatusAluno.TRANCADO);
            String cursoNome = a.getCurso() != null ? a.getCurso().getNome() : "-- Sem Curso --";

            System.out.printf("%-10s | %-25s | %-20s | %-10s%n",
                    a.getMatricula().getValor(),
                    truncarString(a.getNome(), 25),
                    truncarString(cursoNome, 20),
                    status);
        }
    }

    private static void listarProfessores() {
        System.out.println("\n>>> RELATÓRIO DE PROFESSORES");
        if (professores.isEmpty()) {
            System.out.println("Nenhum professor cadastrado.");
            return;
        }
        System.out.printf("%-10s | %-30s | %-20s%n", "REGISTRO", "NOME", "TITULAÇÃO");
        System.out.println("-".repeat(68));

        professores.forEach(p -> System.out.printf("%-10s | %-30s | %-20s%n",
                p.getRegistro().getValor(),
                truncarString(p.getNome(), 30),
                p.getTitulacao()));
    }

    private static void listarCursos() {
        System.out.println("\n>>> RELATÓRIO DE CURSOS");
        if (cursos.isEmpty()) {
            System.out.println("Nenhum curso cadastrado.");
            return;
        }

        System.out.printf("%-10s | %-30s | %-10s | %-10s%n", "CÓDIGO", "NOME DO CURSO", "DURAÇÃO", "CARGA H.");
        System.out.println("-".repeat(70));

        cursos.forEach(c -> System.out.printf("%-10s | %-30s | %-10s | %dh%n",
                c.getCodigo().getValor(),
                truncarString(c.getNome(), 30),
                c.getDuracaoSemestres() + " sem.",
                c.getCargaHorariaTotal()));
    }

    private static void listarDisciplinas() {
        System.out.println("\n>>> RELATÓRIO DE DISCIPLINAS");
        if (disciplinas.isEmpty()) {
            System.out.println("Nenhuma disciplina cadastrada.");
            return;
        }
        disciplinas.forEach(d -> System.out.println(d.getCodigo().getValor() + " - " + d.getNome()));
    }

    private static void listarTurmas() {
        System.out.println("\n>>> RELATÓRIO DE TURMAS");
        if (turmas.isEmpty()) {
            System.out.println("Nenhuma turma cadastrada.");
            return;
        }

        System.out.printf("%-8s | %-25s | %-20s | %-8s%n", "TURMA", "DISCIPLINA", "PROFESSOR", "VAGAS");
        System.out.println("-".repeat(70));

        turmas.forEach(t -> System.out.printf("%-8s | %-25s | %-20s | %02d/%02d%n",
                t.getCodigo().getValor(),
                truncarString(t.getDisciplina().getNome(), 25),
                truncarString(t.getProfessor().getNome(), 20),
                t.getAlunosMatriculados().size(),
                t.getVagas()));
    }

    private static void cadastrarAluno() {
        System.out.println("\n--- NOVO ALUNO ---");
        String nome = lerString("Nome completo: ");
        Email email = new Email(lerString("E-mail: "));
        Endereco endereco = lerEndereco();

        System.out.println("[Observação: Digite as datas no formato DD/MM/AAAA]");
        LocalDate dataNasc = lerData("Data de nascimento: ");
        LocalDate dataIngresso = lerData("Data de ingresso: ");

        String matriculaGerada = String.valueOf(proximoNumeroMatricula++);
        Matricula matricula = new Matricula(matriculaGerada);

        Aluno aluno = new Aluno(nome, email, endereco, dataNasc, matricula, dataIngresso, null);
        alunos.add(aluno);

        System.out.println("\n✅ Aluno cadastrado com sucesso!");
        System.out.println("   Matrícula gerada: " + matriculaGerada);
        System.out.println("   Lembre-se de vincular o aluno a um curso no menu 'Operações'.");
    }

    private static void cadastrarProfessor() {
        System.out.println("\n--- NOVO PROFESSOR ---");
        String nome = lerString("Nome completo: ");
        Email email = new Email(lerString("E-mail: "));
        Endereco endereco = lerEndereco();
        LocalDate dataNasc = lerData("Data de nascimento (DD/MM/AAAA): ");
        String registro = lerString("Registro (ex: PROF001): ");
        String titulacao = lerString("Titulação (Mestre/Doutor): ");

        Professor prof = new Professor(nome, email, endereco, dataNasc, new RegistroProfessor(registro), titulacao);
        professores.add(prof);
        System.out.println("\n✅ Professor cadastrado!");
    }

    private static void cadastrarCurso() {
        System.out.println("\n--- NOVO CURSO ---");
        String codigo = lerString("Código (ex: BSI): ");
        String nome = lerString("Nome do curso: ");
        int carga = lerInteiro("Carga horária total (horas): ");
        int duracao = lerInteiro("Duração (semestres): ");

        Curso curso = new Curso(new CodigoCurso(codigo), nome, carga, duracao);
        cursos.add(curso);
        System.out.println("\n✅ Curso cadastrado!");
    }

    private static void cadastrarDisciplina() {
        System.out.println("\n--- NOVA DISCIPLINA ---");
        String codigo = lerString("Código (ex: POO1): ");
        String nome = lerString("Nome da disciplina: ");
        int carga = lerInteiro("Carga horária: ");
        int creditos = lerInteiro("Créditos: ");
        String ementa = lerString("Breve ementa: ");

        Disciplina d = new Disciplina(new CodigoDisciplina(codigo), nome, carga, creditos, ementa);
        disciplinas.add(d);
        System.out.println("\n✅ Disciplina cadastrada!");
    }

    private static void cadastrarTurma() {
        if (disciplinas.isEmpty() || professores.isEmpty()) {
            System.out.println("⚠️ Erro: É necessário ter Disciplinas e Professores cadastrados.");
            return;
        }
        System.out.println("\n--- NOVA TURMA ---");

        System.out.println("Selecione a disciplina pelo código:");
        listarDisciplinas();
        Disciplina disc = encontrarDisciplina(lerString("Código da Disciplina: "));
        if (disc == null) {
            System.out.println("❌ Disciplina não encontrada.");
            return;
        }

        System.out.println("\nSelecione o professor pelo registro:");
        listarProfessores();
        Professor prof = encontrarProfessor(lerString("Registro do Professor: "));
        if (prof == null) {
            System.out.println("❌ Professor não encontrado.");
            return;
        }

        String codTurma = lerString("\nCódigo da turma (ex: T01): ");
        int ano = lerInteiro("Ano letivo: ");
        PeriodoLetivo semestre = lerPeriodoLetivo();
        Turno turno = lerTurno();
        int vagas = lerInteiro("Quantidade de vagas: ");

        Turma turma = new Turma(new CodigoTurma(codTurma), ano, semestre, turno, vagas, prof, disc);
        turmas.add(turma);
        disc.adicionarTurma(turma);
        System.out.println("\n✅ Turma criada com sucesso!");
    }

    private static void vincularAlunoACurso() {
        System.out.println("\n--- VINCULAR ALUNO A CURSO ---");
        if (cursos.isEmpty()) {
            System.out.println("⚠️ Nenhum curso cadastrado.");
            return;
        }

        Aluno aluno = encontrarAluno(lerString("Matrícula do aluno: "));
        if (aluno == null || !aluno.ehAtivo()) {
            System.out.println("❌ Aluno não encontrado ou inativo.");
            return;
        }

        if (aluno.getCurso() != null) {
            System.out.println("⚠️ Aluno já está vinculado ao curso: " + aluno.getCurso().getNome());
            return;
        }

        System.out.println("\nCursos disponíveis:");
        listagemSimplesCursos();

        Curso curso = encontrarCurso(lerString("Código do curso desejado: "));
        if (curso == null) {
            System.out.println("❌ Curso não encontrado.");
            return;
        }

        aluno.setCurso(curso);
        curso.adicionarAluno(aluno);
        System.out.printf("\n✅ Sucesso! %s agora faz parte do curso de %s.%n", aluno.getNome(), curso.getNome());
    }

    private static void matricularAlunoEmTurma() {
        System.out.println("\n--- MATRÍCULA EM TURMA ---");

        Aluno aluno = encontrarAluno(lerString("Matrícula do aluno: "));
        if (aluno == null || !aluno.ehAtivo()) {
            System.out.println("❌ Aluno inválido.");
            return;
        }
        if (aluno.getCurso() == null) {
            System.out.println("⚠️ Este aluno ainda não tem curso vinculado. Vá na opção 11 primeiro.");
            return;
        }

        System.out.println("\nTurmas disponíveis:");
        listarTurmas();

        Turma turma = encontrarTurma(lerString("Código da turma: "));
        if (turma == null) {
            System.out.println("❌ Turma não encontrada.");
            return;
        }

        if (turma.matricularAluno(aluno)) {
            System.out.println("\n✅ Matrícula realizada com sucesso!");
        }
        else {
            System.out.println("\n❌ Não foi possível matricular (Turma cheia ou aluno já está na turma).");
        }
    }

    private static void inativarAluno() {
        System.out.println("\n--- INATIVAR ALUNO ---");
        String mat = lerString("Digite a matrícula do aluno: ");
        Aluno aluno = encontrarAluno(mat);

        if (aluno == null) {
            System.out.println("❌ Aluno não encontrado.");
            return;
        }
        if (!aluno.ehAtivo()) {
            System.out.println("⚠️ Este aluno já está inativo.");
            return;
        }

        System.out.printf("Tem certeza que deseja inativar %s? (S/N): ", aluno.getNome());
        String confirmacao = scanner.nextLine();

        if (confirmacao.equalsIgnoreCase("S")) {
            aluno.inativar();
            System.out.println("\n✅ Aluno inativado com sucesso.");
        }
        else {
            System.out.println("Operação cancelada.");
        }
    }

    private static void pausar() {
        System.out.println("\n[Pressione ENTER para continuar...]");
        scanner.nextLine();
    }

    private static int lerOpcao() {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String lerString(String input) {
        System.out.print(input);
        return scanner.nextLine().trim();
    }

    private static int lerInteiro(String input) {
        while (true) {
            try {
                System.out.print(input);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Digite apenas números inteiros.");
            }
        }
    }

    private static LocalDate lerData(String input) {
        while (true) {
            try {
                System.out.print(input);
                String dataStr = scanner.nextLine();
                return LocalDate.parse(dataStr, DATA_FORMATTER);
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ Data inválida! Use o formato DD/MM/AAAA (Ex: 01/01/1000)");
            }
        }
    }

    private static Endereco lerEndereco() {
        System.out.println("\n>> Preenchendo Endereço:");
        return new Endereco(
                lerString("Logradouro: "),
                lerString("Número: "),
                lerString("Complemento: "),
                lerString("Bairro: "),
                lerString("Cidade: "),
                lerString("UF: "),
                lerString("CEP: ")
        );
    }

    private static PeriodoLetivo lerPeriodoLetivo() {
        System.out.println("Selecione o semestre: [1] Primeiro | [2] Segundo");
        int op = lerInteiro("→ ");
        return op == 2 ? PeriodoLetivo.SEGUNDO_SEMESTRE : PeriodoLetivo.PRIMEIRO_SEMESTRE;
    }

    private static Turno lerTurno() {
        System.out.println("Selecione o turno: [1] Matutino [2] Vespertino [3] Noturno [4] Integral");
        return switch (lerInteiro("→ ")) {
            case 2 -> Turno.VESPERTINO;
            case 3 -> Turno.NOTURNO;
            case 4 -> Turno.INTEGRAL;
            default -> Turno.MATUTINO;
        };
    }

    private static String truncarString(String texto, int tamanhoMax) {
        if (texto == null) return "";
        if (texto.length() <= tamanhoMax) return texto;
        return texto.substring(0, tamanhoMax - 3) + "...";
    }

    private static void listagemSimplesCursos() {
        cursos.forEach(c -> System.out.println(" -> [" + c.getCodigo().getValor() + "] " + c.getNome()));
    }

    private static Aluno encontrarAluno(String matricula) {
        return alunos.stream().filter(a -> a.getMatricula().getValor().equals(matricula)).findFirst().orElse(null);
    }

    private static Professor encontrarProfessor(String registro) {
        return professores.stream().filter(p -> p.getRegistro().getValor().equals(registro)).findFirst().orElse(null);
    }

    private static Curso encontrarCurso(String codigo) {
        return cursos.stream().filter(c -> c.getCodigo().getValor().equals(codigo)).findFirst().orElse(null);
    }

    private static Disciplina encontrarDisciplina(String codigo) {
        return disciplinas.stream().filter(d -> d.getCodigo().getValor().equals(codigo)).findFirst().orElse(null);
    }

    private static Turma encontrarTurma(String codigo) {
        return turmas.stream().filter(t -> t.getCodigo().getValor().equals(codigo)).findFirst().orElse(null);
    }

    private static void gerarDadosMockados() {
        Endereco enderecoPuc = new Endereco(
                "Av. Universitária", "1440", "Area 4",
                "Setor Leste Universitário", "Goiânia", "GO", "74605-010"
        );

        Professor p = new Professor("Thalles Bruno",
                new Email("thalles.bruno@pucgoias.edu.br"),
                enderecoPuc,
                LocalDate.of(1990, 5, 20),
                new RegistroProfessor("PROF-POO-01"),
                "Doutor"
        );
        professores.add(p);

        Curso c = new Curso(new CodigoCurso("BCC"), "Ciência da Computação", 3600, 10);
        cursos.add(c);

        Disciplina d = new Disciplina(new CodigoDisciplina("CMP1048"), "Programação Orientada a Objetos", 60, 4, "Encapsulamento, Herança, Polimorfismo e Abstração.");
        disciplinas.add(d);

        Turma t = new Turma(new CodigoTurma("C01"), 2025, PeriodoLetivo.PRIMEIRO_SEMESTRE, Turno.NOTURNO, 40, p, d);
        turmas.add(t);
        d.adicionarTurma(t);

        String[] alunos = {"Pablo Ribeiro", "Pedro Blamires", "Matheus Mendanha", "Gabriel Borges"};

        int count = 1;
        for (String nome : alunos) {
            String matStr = "202500" + count;

            Aluno aluno = new Aluno(
                    nome,
                    new Email(nome.split(" ")[0].toLowerCase() + "@pucgoias.edu.br"),
                    enderecoPuc,
                    LocalDate.of(2003, 1, 1),
                    new Matricula(matStr),
                    LocalDate.of(2023, 2, 1),
                    c
            );

            Main.alunos.add(aluno);
            c.adicionarAluno(aluno);
            t.matricularAluno(aluno);
            count++;
        }
        proximoNumeroMatricula = 2025005;
    }
}