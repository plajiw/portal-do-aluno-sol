package entities;

import entities.valueObjects.CodigoCurso;
import interfaces.IIdentificavel;

import java.util.ArrayList;
import java.util.List;

public class Curso extends EntidadeBase implements IIdentificavel {
    private CodigoCurso codigo;
    private String nome;
    private int cargaHorariaTotal;
    private int duracaoSemestres;
    private List<Disciplina> disciplinas = new ArrayList<>();
    private List<Aluno> alunosMatriculados = new ArrayList<>();

    public Curso(CodigoCurso codigo, String nome, int cargaHorariaTotal, int duracaoSemestres) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHorariaTotal = cargaHorariaTotal;
        this.duracaoSemestres = duracaoSemestres;
    }

    @Override
    public String getIdentificacao() {
        return "Curso: " + codigo.getValor();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void adicionarAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public CodigoCurso getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHorariaTotal() {
        return cargaHorariaTotal;
    }

    public void setCargaHorariaTotal(int cargaHorariaTotal) {
        this.cargaHorariaTotal = cargaHorariaTotal;
    }

    public int getDuracaoSemestres() {
        return duracaoSemestres;
    }

    public void setDuracaoSemestres(int duracaoSemestres) {
        this.duracaoSemestres = duracaoSemestres;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public List<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
}