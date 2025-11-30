package entities;

import java.time.LocalDateTime;

public abstract class EntidadeBase {
    protected boolean ativo = true;
    protected LocalDateTime dataCriacao = LocalDateTime.now();

    public void ativar() {
        ativo = true;
    }

    public void inativar() {
        ativo = false;
    }

    public boolean ehAtivo() {
        return ativo;
    }
}