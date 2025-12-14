package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Classe que representa um Certificado de conclusão.
 * Demonstra ENCAPSULAMENTO e ABSTRAÇÃO ao modelar um certificado.
 */
public class Certificado {
    private String id;
    private String nomeDev;
    private String nomeBootcamp;
    private LocalDate dataEmissao;
    private double xpTotal;
    private NivelProficiencia nivel;

    public Certificado(String nomeDev, String nomeBootcamp, double xpTotal) {
        this.id = UUID.randomUUID().toString();
        this.nomeDev = nomeDev;
        this.nomeBootcamp = nomeBootcamp;
        this.dataEmissao = LocalDate.now();
        this.xpTotal = xpTotal;
        this.nivel = NivelProficiencia.determinarNivel(xpTotal);
    }

    public String getId() {
        return id;
    }

    public String getNomeDev() {
        return nomeDev;
    }

    public String getNomeBootcamp() {
        return nomeBootcamp;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public double getXpTotal() {
        return xpTotal;
    }

    public NivelProficiencia getNivel() {
        return nivel;
    }

    @Override
    public String toString() {
        return "\n═══════════════════════════════════════════\n" +
               "         CERTIFICADO DE CONCLUSÃO\n" +
               "═══════════════════════════════════════════\n" +
               "Certificamos que " + nomeDev + "\n" +
               "concluiu com sucesso o bootcamp:\n" +
               nomeBootcamp + "\n\n" +
               "XP Total: " + xpTotal + "\n" +
               "Nível Alcançado: " + nivel.getDescricao() + "\n" +
               "Data de Emissão: " + dataEmissao + "\n" +
               "ID do Certificado: " + id + "\n" +
               "═══════════════════════════════════════════\n";
    }
}

