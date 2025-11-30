package entities;

import entities.valueObjects.CodigoDisciplina;
import interfaces.IIdentificavel;

import java.util.ArrayList;
import java.util.List;

public class Disciplina extends EntidadeBase implements IIdentificavel {
    private CodigoDisciplina codigo;
    private String nome;
    private int cargaHoraria;
    private int creditos;
    private String ementa;
    private List<Disciplina> prerequisitos = new ArrayList<>();
    private List<Turma> turmasOferecidas = new ArrayList<>();

    public Disciplina(CodigoDisciplina codigo, String nome, int cargaHoraria, int creditos, String ementa) {
        this.codigo = codigo;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.creditos = creditos;
        this.ementa = ementa;
    }

    @Override
    public String getIdentificacao() {
        return "Disciplina: " + codigo.getValor();
    }

    public void adicionarPrerequisito(Disciplina prereq) {
        prerequisitos.add(prereq);
    }

    public void adicionarTurma(Turma turma) {
        turmasOferecidas.add(turma);
    }

    public CodigoDisciplina getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getEmenta() {
        return ementa;
    }

    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public List<Disciplina> getPrerequisitos() {
        return prerequisitos;
    }

    public List<Turma> getTurmasOferecidas() {
        return turmasOferecidas;
    }
}