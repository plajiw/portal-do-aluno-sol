package entities;

import entities.valueObjects.CodigoTurma;
import entities.valueObjects.Matricula;
import enums.PeriodoLetivo;
import enums.Turno;
import interfaces.IIdentificavel;

import java.util.ArrayList;
import java.util.List;

public class Turma extends EntidadeBase implements IIdentificavel {
    private CodigoTurma codigo;
    private int ano;
    private PeriodoLetivo semestre;
    private Turno turno;
    private int vagas;
    private List<Aluno> alunosMatriculados = new ArrayList<>();
    private Professor professor;
    private Disciplina disciplina;

    public Turma(CodigoTurma codigo, int ano, PeriodoLetivo semestre, Turno turno, int vagas, Professor professor, Disciplina disciplina) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
        this.turno = turno;
        this.vagas = vagas;
        this.professor = professor;
        this.disciplina = disciplina;
    }

    public boolean matricularAluno(Aluno a) {
        if (alunosMatriculados.size() < vagas && !alunosMatriculados.contains(a)) {
            alunosMatriculados.add(a);
            a.adicionarTurma(this);
            return true;
        }
        return false;
    }

    public boolean cancelarMatricula(Matricula m) {
        for (Aluno a : alunosMatriculados) {
            if (a.getMatricula().getValor().equals(m.getValor())) {
                alunosMatriculados.remove(a);
                return true;
            }
        }
        return false;
    }

    public boolean temVagaDisponivel() {
        return alunosMatriculados.size() < vagas;
    }

    @Override
    public String getIdentificacao() {
        return "Turma: " + codigo.getValor();
    }

    public CodigoTurma getCodigo() {
        return codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public PeriodoLetivo getSemestre() {
        return semestre;
    }

    public void setSemestre(PeriodoLetivo semestre) {
        this.semestre = semestre;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}