package services;

import enums.IdentificadorEnum;
import java.util.UUID;

public class ServicoDoIdentificador {

    private static ServicoDoIdentificador instancia;

    private ServicoDoIdentificador() {}

    public static synchronized ServicoDoIdentificador getInstancia() {
        if (instancia == null) {
            instancia = new ServicoDoIdentificador();
        }
        return instancia;
    }

    public String gerarId(IdentificadorEnum tipo) {
        return tipo.name() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}