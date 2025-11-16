package enums;

public enum DisciplinasEnum {
    METODOLOGIA_CIENTIFICA("Metodologia Científica"),
    PORTUGUES_INSTRUMENTAL("Português Instrumental"),
    FILOSOFIA("Filosofia e Ética"),
    SOCIOLOGIA_GERAL("Sociologia Geral"),
    ESTATISTICA_APLICADA("Estatística Aplicada"),
    ALGORITMOS_E_ESTRUTURAS_DE_DADOS_I("Algoritmos e Estruturas de Dados I"),
    PROGRAMACAO_ORIENTADA_A_OBJETOS("Programação Orientada a Objetos"),
    BANCO_DE_DADOS("Banco de Dados"),
    ENGENHARIA_DE_SOFTWARE_I("Engenharia de Software I"),
    SISTEMAS_OPERACIONAIS("Sistemas Operacionais"),
    REDES_DE_COMPUTADORES("Redes de Computadores"),
    CALCULO_I("Cálculo I"),
    FISICA_I("Física Geral e Experimental I"),
    DESENHO_TECNICO("Desenho Técnico"),
    RESISTENCIA_DOS_MATERIAIS("Resistência dos Materiais"),
    TOPOGRAFIA("Topografia"),
    HISTORIA_DA_ARTE_E_ARQUITETURA("História da Arte e Arquitetura"),
    ANATOMIA_HUMANA("Anatomia Humana"),
    ANATOMIA_ANIMAL("Anatomia Veterinária"),
    FISIOLOGIA("Fisiologia"),
    BIOQUIMICA("Bioquímica"),
    PATOLOGIA_GERAL("Patologia Geral"),
    NEUROANATOMIA("Neuroanatomia"),
    TEORIAS_DA_PERSONALIDADE("Teorias da Personalidade"),
    DIREITO_CONSTITUCIONAL("Direito Constitucional"),
    DIREITO_PENAL_I("Direito Penal I"),
    TEORIA_GERAL_DA_ADMINISTRACAO("Teoria Geral da Administração"),
    CONTABILIDADE_GERAL("Contabilidade Geral"),
    FUNDAMENTOS_DE_MARKETING("Fundamentos de Marketing"),
    TEORIA_DA_COMUNICACAO("Teoria da Comunicação");

    private String nomeDaDisciplina;

    DisciplinasEnum(String nomeDaDisciplina) {
        this.nomeDaDisciplina = nomeDaDisciplina;
    }

    public String getNomeDaDisciplina() {
        return this.nomeDaDisciplina;
    }
}