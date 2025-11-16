package entities;

import enums.IdentificadorEnum;
import services.ServicoDoIdentificador;

public abstract class Pessoa extends EntidadeBase {
    private String nome;
    private String sobrenome;
    private String email;
    private String dataDeNascimento;

    public Pessoa(String nome, String sobrenome, String email, String dataDeNascimento, IdentificadorEnum tipo) {
        super(ServicoDoIdentificador.getInstancia().gerarId(tipo));
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getNomeCompleto() {
        return getNome() + getSobrenome();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }
}
