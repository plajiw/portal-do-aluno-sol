package entidades;

import entidades.interfaces.IIdentificador;

public class Aluno extends Pessoa implements IIdentificador {

    @Override
    public String gerarIdentificador() {
    return "a";
    }
}
