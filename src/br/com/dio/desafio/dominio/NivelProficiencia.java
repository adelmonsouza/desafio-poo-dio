package br.com.dio.desafio.dominio;

/**
 * Enum que representa os níveis de proficiência de um desenvolvedor.
 * Demonstra ENCAPSULAMENTO ao definir valores constantes e métodos associados.
 */
public enum NivelProficiencia {
    INICIANTE(0, 100, "Iniciante"),
    INTERMEDIARIO(101, 500, "Intermediário"),
    AVANCADO(501, 1500, "Avançado"),
    ESPECIALISTA(1501, Double.MAX_VALUE, "Especialista");

    private final double xpMinimo;
    private final double xpMaximo;
    private final String descricao;

    NivelProficiencia(double xpMinimo, double xpMaximo, String descricao) {
        this.xpMinimo = xpMinimo;
        this.xpMaximo = xpMaximo;
        this.descricao = descricao;
    }

    public static NivelProficiencia determinarNivel(double xpTotal) {
        for (NivelProficiencia nivel : values()) {
            if (xpTotal >= nivel.xpMinimo && xpTotal < nivel.xpMaximo) {
                return nivel;
            }
        }
        return ESPECIALISTA;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getXpMinimo() {
        return xpMinimo;
    }

    public double getXpMaximo() {
        return xpMaximo;
    }
}

