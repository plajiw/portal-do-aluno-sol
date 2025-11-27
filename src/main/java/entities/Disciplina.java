package entities;

import enums.IdentificadorEnum;
import services.ServicoDoIdentificador;

public class Disciplina extends EntidadeBase {
    private String nome;
    private int cargaHoraria;

    public Disciplina(String nome, int cargaHoraria) {
        super(ServicoDoIdentificador.getInstancia().gerarId(IdentificadorEnum.DISCIPLINA));
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
}