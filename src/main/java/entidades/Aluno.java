package entidades;

import entidades.interfaces.IIdentificavel;

public class Aluno extends Pessoa implements IIdentificavel {

    @Override
    public int gerarIdentificador() {
        return 0;
    }
}
