package entities;

import entities.valueObjects.Email;
import entities.valueObjects.Endereco;
import entities.valueObjects.Matricula;
import enums.StatusAluno;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Aluno extends Pessoa {
    private Matricula matricula;
    private LocalDate dataIngresso;
    private StatusAluno status = StatusAluno.ATIVO;
    private Curso curso;
    private List<Turma> turmasMatriculadas = new ArrayList<>();

    public Aluno(String nome, Email email, Endereco endereco, LocalDate dataNascimento, Matricula matricula, LocalDate dataIngresso, Curso curso) {
        super(nome, email, endereco, dataNascimento);
        this.matricula = matricula;
        this.dataIngresso = dataIngresso;
        this.curso = curso;
    }

    public void alterarStatus(StatusAluno status) {
        this.status = status;
    }

    @Override
    public String getIdentificacao() {
        return "Aluno: " + matricula.getValor();
    }

    public void adicionarTurma(Turma turma) {
        turmasMatriculadas.add(turma);
    }

    public List<Turma> getTurmasMatriculadas() {
        return turmasMatriculadas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public LocalDate getDataIngresso() {
        return dataIngresso;
    }

    public StatusAluno getStatus() {
        return status;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}