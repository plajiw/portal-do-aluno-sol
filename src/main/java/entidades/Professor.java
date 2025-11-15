package entidades;

import entidades.interfaces.IIdentificador;

public class Professor extends Pessoa implements IIdentificador {
    @Override
    public int gerarIdentificador() {
        return 0;
    }
}
