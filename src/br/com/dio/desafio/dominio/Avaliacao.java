package br.com.dio.desafio.dominio;

/**
 * Classe que representa uma Avaliação/Teste.
 * Demonstra HERANÇA ao estender Conteudo e POLIMORFISMO ao sobrescrever calcularXp().
 */
public class Avaliacao extends Conteudo {
    private int quantidadeQuestoes;
    private double notaMinima;
    private double notaObtida;

    public Avaliacao() {
    }

    @Override
    public double calcularXp() {
        // XP baseado na quantidade de questões e desempenho
        double xpBase = XP_PADRAO * quantidadeQuestoes;
        if (notaObtida >= notaMinima) {
            // Bônus por aprovação
            return xpBase * 1.5;
        }
        return xpBase * 0.5; // XP reduzido se não passou
    }

    public int getQuantidadeQuestoes() {
        return quantidadeQuestoes;
    }

    public void setQuantidadeQuestoes(int quantidadeQuestoes) {
        this.quantidadeQuestoes = quantidadeQuestoes;
    }

    public double getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(double notaMinima) {
        this.notaMinima = notaMinima;
    }

    public double getNotaObtida() {
        return notaObtida;
    }

    public void setNotaObtida(double notaObtida) {
        this.notaObtida = notaObtida;
    }

    public boolean foiAprovado() {
        return notaObtida >= notaMinima;
    }

    @Override
    public String toString() {
        return "Avaliacao{" +
                "titulo='" + getTitulo() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", quantidadeQuestoes=" + quantidadeQuestoes +
                ", notaMinima=" + notaMinima +
                ", notaObtida=" + notaObtida +
                ", aprovado=" + foiAprovado() +
                '}';
    }
}

