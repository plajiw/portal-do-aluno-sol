package services;

import enums.IdentificadorEnum;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

public class ServicoDoIdentificador {
    private static final String FORMATO_ID = "%s%d-%04d";
    private static final ServicoDoIdentificador instancia = new ServicoDoIdentificador();
    private final Map<IdentificadorEnum, Integer> contadores;

    private ServicoDoIdentificador() {
        contadores = new HashMap<>();
        for (IdentificadorEnum tipo : IdentificadorEnum.values()) {
            contadores.put(tipo, 0);
        }
    }

    public static ServicoDoIdentificador getInstancia() {
        return instancia;
    }

    public String gerarId(IdentificadorEnum tipo) {
        int anoAtual = Year.now().getValue();
        int valorAtual = contadores.getOrDefault(tipo, 0);
        int novoValor = valorAtual + 1;
        contadores.put(tipo, novoValor);
        return String.format(FORMATO_ID, tipo.getPrefixo(), anoAtual, novoValor);
    }
}
