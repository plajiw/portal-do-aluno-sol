package entities;

import enums.IdentificadorEnum;

public class Professor extends Pessoa {

    private String especialidade;

    public Professor(String nome, String sobrenome, String email, String dataDeNascimento) {
        super(nome, sobrenome, email, dataDeNascimento, IdentificadorEnum.PROFESSOR);
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    @Override
    public String getIdentificacaoFormatada() {
        return "Professor: " + getNomeCompleto() + " | Especialidade: " + getEspecialidade();
    }
}