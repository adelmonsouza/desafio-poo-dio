package br.com.dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que implementa sistema de recomendações baseado em XP e nível.
 * Demonstra ABSTRAÇÃO ao encapsular a lógica de recomendação.
 */
public class SistemaRecomendacoes {

    /**
     * Recomenda bootcamps baseado no nível atual do desenvolvedor.
     * Demonstra POLIMORFISMO ao trabalhar com diferentes tipos de Conteudo.
     */
    public static List<Bootcamp> recomendarBootcamps(Dev dev, List<Bootcamp> bootcampsDisponiveis) {
        List<Bootcamp> recomendacoes = new ArrayList<>();
        NivelProficiencia nivelAtual = NivelProficiencia.determinarNivel(dev.calcularTotalXp());

        for (Bootcamp bootcamp : bootcampsDisponiveis) {
            // Calcula XP médio do bootcamp
            double xpMedioBootcamp = bootcamp.getConteudos().stream()
                .mapToDouble(Conteudo::calcularXp)
                .average()
                .orElse(0);

            // Recomenda se o bootcamp for adequado ao nível do dev
            boolean adequado = false;
            switch (nivelAtual) {
                case INICIANTE:
                    adequado = xpMedioBootcamp <= 50; // Bootcamps mais básicos
                    break;
                case INTERMEDIARIO:
                    adequado = xpMedioBootcamp >= 30 && xpMedioBootcamp <= 100;
                    break;
                case AVANCADO:
                    adequado = xpMedioBootcamp >= 80 && xpMedioBootcamp <= 200;
                    break;
                case ESPECIALISTA:
                    adequado = xpMedioBootcamp >= 150; // Bootcamps avançados
                    break;
            }

            // Não recomenda bootcamps já inscritos
            boolean jaInscrito = dev.getConteudosInscritos().stream()
                .anyMatch(c -> bootcamp.getConteudos().contains(c));

            if (adequado && !jaInscrito) {
                recomendacoes.add(bootcamp);
            }
        }

        return recomendacoes;
    }

    /**
     * Sugere próximos passos baseado no progresso atual.
     */
    public static void sugerirProximosPassos(Dev dev) {
        NivelProficiencia nivelAtual = NivelProficiencia.determinarNivel(dev.calcularTotalXp());
        NivelProficiencia proximoNivel = null;

        // Determina próximo nível
        switch (nivelAtual) {
            case INICIANTE:
                proximoNivel = NivelProficiencia.INTERMEDIARIO;
                break;
            case INTERMEDIARIO:
                proximoNivel = NivelProficiencia.AVANCADO;
                break;
            case AVANCADO:
                proximoNivel = NivelProficiencia.ESPECIALISTA;
                break;
            case ESPECIALISTA:
                System.out.println("Parabéns! Você alcançou o nível máximo!");
                return;
        }

        double xpAtual = dev.calcularTotalXp();
        double xpNecessario = proximoNivel.getXpMinimo() - xpAtual;

        System.out.println("\n--- SUGESTÕES DE DESENVOLVIMENTO ---");
        System.out.println("Nível Atual: " + nivelAtual.getDescricao());
        System.out.println("Próximo Nível: " + proximoNivel.getDescricao());
        System.out.println("XP Necessário: " + xpNecessario);
        System.out.println("Conteúdos Concluídos: " + dev.getConteudosConcluidos().size());
        System.out.println("Conteúdos em Andamento: " + dev.getConteudosInscritos().size());
        System.out.println("---\n");
    }
}

