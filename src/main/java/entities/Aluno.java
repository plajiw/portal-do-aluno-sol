package entities;

import enums.IdentificadorEnum;

import java.util.ArrayList;

public class Aluno extends Pessoa {

    public Aluno(String nome, String sobrenome, String email, String dataDeNascimento) {
        super(nome, sobrenome, email, dataDeNascimento, IdentificadorEnum.ALUNO);
    }

    public String getMatricula() {
        return getId();
    }
}
