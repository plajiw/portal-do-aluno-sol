package entidades;

import java.util.Date;

public abstract class EntidadeBase {
    private String id;
    private Date criadoEm;

    public EntidadeBase() {
        this.criadoEm = new Date();
    }
}
