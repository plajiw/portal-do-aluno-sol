package entities;

import enums.IdentificadorEnum;

public class Aluno extends Pessoa {

    public Aluno(String nome, String sobrenome, String email, String dataDeNascimento) {
        super(nome, sobrenome, email, dataDeNascimento, IdentificadorEnum.ALUNO);
    }

    public String getMatricula() {
        return getId();
    }
}
