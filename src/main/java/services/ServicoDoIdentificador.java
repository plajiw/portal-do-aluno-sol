package services;

import enums.IdentificadorEnum;
import java.util.UUID;

public class ServicoDoIdentificador {
    public static String gerarId(IdentificadorEnum tipo) {
        return tipo.name() + "-" + UUID.randomUUID().toString().substring(0, 8);
    }
}