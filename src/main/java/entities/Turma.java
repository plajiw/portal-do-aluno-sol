package entities;

import enums.IdentificadorEnum;
import exceptions.RegraDeNegocioException;
import services.ServicoDoIdentificador;

import java.util.ArrayList;
import java.util.List;

public class Turma extends EntidadeBase {
    private String codigoTurma;
    private Curso curso;
    private Disciplina disciplina;
    private Professor professor;
    private List<Aluno> alunos;

    public Turma(String codigoTurma, Curso curso, Disciplina disciplina, Professor professor) {
        super(ServicoDoIdentificador.getInstancia().gerarId(IdentificadorEnum.TURMA));
        this.codigoTurma = codigoTurma;
        this.curso = curso;
        this.disciplina = disciplina;
        this.professor = professor;
        this.alunos = new ArrayList<>();
    }

    public void matricularAluno(Aluno aluno) {
        if (alunos.contains(aluno)) {
            throw new RegraDeNegocioException("O aluno " + aluno.getNome() + "já está matriculado nesta turma!");
        }

        this.alunos.add(aluno);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunos;
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }

    public Curso getCurso() {
        return curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Professor getProfessor() {
        return professor;
    }
}