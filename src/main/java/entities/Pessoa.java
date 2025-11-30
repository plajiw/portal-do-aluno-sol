package entities;

import entities.valueObjects.Email;
import entities.valueObjects.Endereco;
import interfaces.IIdentificavel;

import java.time.LocalDate;

public abstract class Pessoa extends EntidadeBase implements IIdentificavel {
    private String nome;
    private Email email;
    private Endereco endereco;
    private LocalDate dataNascimento;

    public Pessoa(String nome, Email email, Endereco endereco, LocalDate dataNascimento) {
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }

    public void atualizarContato(Email email) {
        this.email = email;
    }

    public void atualizarEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public abstract String getIdentificacao();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Email getEmail() {
        return email;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
}