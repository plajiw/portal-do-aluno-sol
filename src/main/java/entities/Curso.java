package entities;

import enums.IdentificadorEnum;
import services.ServicoDoIdentificador;

public class Curso extends EntidadeBase {
    private String nome;

    public Curso(String nome) {
        super(ServicoDoIdentificador.getInstancia().gerarId(IdentificadorEnum.CURSO));
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}