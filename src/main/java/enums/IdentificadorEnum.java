package enums;

public enum IdentificadorEnum {
    ALUNO("ALUNO"),
    DOCENTE("DOCENTE"),
    CURSO("CURSO"),
    DISCIPLINA("DISCIPLINA"),
    TURMA("TURMA");

    private final String prefixo;

    IdentificadorEnum(String prefixo) {
        this.prefixo = prefixo;
    }

    public String getPrefixo() {
        return prefixo;
    }
}
