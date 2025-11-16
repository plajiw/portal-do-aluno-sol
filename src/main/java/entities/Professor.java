package entities;

import enums.IdentificadorEnum;

public class Professor extends Pessoa {


    public Professor(String nome, String sobrenome, String email, String dataDeNascimento) {
        super(nome, sobrenome, email, dataDeNascimento, IdentificadorEnum.DOCENTE);
    }

    public String getIdentificador() {
        return super.getId();
    }
}
