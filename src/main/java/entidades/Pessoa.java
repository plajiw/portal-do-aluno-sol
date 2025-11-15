package entidades;

import java.util.Date;

public abstract class Pessoa extends EntidadeBase {
    private String nome;
    private String sobrenome;
    private String email;
    private Date dataDeNascimento;

    public Pessoa(String nome, String sobrenome, String email, String dataDeNascimento) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
    }
}
