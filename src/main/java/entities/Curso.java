package entities;

import enums.CursosEnum;
import enums.IdentificadorEnum;
import services.ServicoDoIdentificador;

import java.util.ArrayList;

public class Curso extends EntidadeBase{
    private CursosEnum nome;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Curso(CursosEnum nome) {
        super(ServicoDoIdentificador.getInstancia().gerarId(IdentificadorEnum.CURSO));
        this.nome = nome;
        this.disciplinas = new ArrayList<>();
    }

    public String getIdentificador() {
        return getId();
    }
}
