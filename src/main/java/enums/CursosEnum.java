package enums;

public enum CursosEnum {
    CIENCIAS_DA_COMPUTACAO("Ciências da Computação"),
    DIREITO("Direito"),
    MEDICINA("Medicina"),
    ENGENHARIA_CIVIL("Engenharia Civil"),
    ARQUITETURA_E_URBANISMO("Arquitetura e Urbanismo"),
    PSICOLOGIA("Psicologia"),
    ADMINISTRACAO("Administração"),
    JORNALISMO("Jornalismo"),
    MEDICINA_VETERINARIA("Medicina Veterinária"),
    ENGENHARIA_DE_SOFTWARE("Engenharia de Software");

    private String nomeDoCurso;

    CursosEnum(String nomeDoCurso) {
        this.nomeDoCurso = nomeDoCurso;
    }

    public String getNomeDoCurso() {
        return this.nomeDoCurso;
    }
}