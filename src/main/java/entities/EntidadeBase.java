package entities;

import interfaces.IIdentificador;

import java.util.Date;

public abstract class EntidadeBase implements IIdentificador {
    private final String id;
    private final Date criadoEm;

    public EntidadeBase(String id) {
        this.id = id;
        this.criadoEm = new Date();
    }

    @Override
    public String getId() {
        return id;
    }

    public Date getCriadoEm() {
        return new Date(criadoEm.getTime());
    }
}