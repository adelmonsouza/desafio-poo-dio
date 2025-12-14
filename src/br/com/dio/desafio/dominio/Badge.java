package br.com.dio.desafio.dominio;

/**
 * Classe que representa uma Badge/Conquista.
 * Demonstra ENCAPSULAMENTO com atributos privados e métodos de acesso.
 */
public class Badge {
    private String nome;
    private String descricao;
    private String icone;
    private double xpRequerido;

    public Badge(String nome, String descricao, String icone, double xpRequerido) {
        this.nome = nome;
        this.descricao = descricao;
        this.icone = icone;
        this.xpRequerido = xpRequerido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public double getXpRequerido() {
        return xpRequerido;
    }

    public void setXpRequerido(double xpRequerido) {
        this.xpRequerido = xpRequerido;
    }

    @Override
    public String toString() {
        return icone + " " + nome + " - " + descricao;
    }
}

