package model;

public class Professor extends Pessoa implements IIdentificavel{
    @Override
    public int gerarIdentificador() {
        return 0;
    }
}
