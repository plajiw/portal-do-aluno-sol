package entities;

import entities.valueObjects.Email;
import entities.valueObjects.Endereco;
import entities.valueObjects.RegistroProfessor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Professor extends Pessoa {
    private RegistroProfessor registro;
    private String titulacao;
    private List<Disciplina> disciplinasMinistradas = new ArrayList<>();

    public Professor(String nome, Email email, Endereco endereco, LocalDate dataNascimento, RegistroProfessor registro, String titulacao) {
        super(nome, email, endereco, dataNascimento);
        this.registro = registro;
        this.titulacao = titulacao;
    }

    @Override
    public String getIdentificacao() {
        return "Professor: " + registro.getValor();
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinasMinistradas.add(disciplina);
    }

    public List<Disciplina> getDisciplinasMinistradas() {
        return disciplinasMinistradas;
    }

    public RegistroProfessor getRegistro() {
        return registro;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
}