package entities.valueObjects;

public class Email {
    private String valor;

    public Email(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    public boolean ehValido() {
        return valor != null && valor.contains("@");
    }
}