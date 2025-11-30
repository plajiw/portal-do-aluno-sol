package entities;

import enums.IdentificadorEnum;

public class Aluno extends Pessoa {

    public Aluno(String nome, String sobrenome, String email, String dataDeNascimento) {
        super(nome, sobrenome, email, dataDeNascimento, IdentificadorEnum.ALUNO);
    }

    public String getMatricula() {
        return getId();
    }

    @Override
    public String getIdentificacaoFormatada() {
        return "Aluno: " + getNomeCompleto() + " | Matrícula: " + getMatricula();
    }

    @Override
    public String toString() {
        return "Aluno: " + getNomeCompleto() + " (Matrícula: " + getMatricula() + ")";
    }
}