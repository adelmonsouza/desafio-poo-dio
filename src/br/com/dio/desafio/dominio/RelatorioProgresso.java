package br.com.dio.desafio.dominio;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe utilitária para gerar relatórios de progresso.
 * Demonstra ABSTRAÇÃO ao fornecer métodos estáticos para análise de dados.
 */
public class RelatorioProgresso {

    /**
     * Gera um relatório completo do progresso de um desenvolvedor.
     * Demonstra POLIMORFISMO ao trabalhar com diferentes tipos de Conteudo.
     */
    public static void gerarRelatorio(Dev dev) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("        RELATÓRIO DE PROGRESSO");
        System.out.println("=".repeat(60));
        System.out.println("Desenvolvedor: " + dev.getNome());
        System.out.println("Nível Atual: " + NivelProficiencia.determinarNivel(dev.calcularTotalXp()).getDescricao());
        System.out.println("XP Total: " + dev.calcularTotalXp());
        System.out.println("\n--- Conteúdos Inscritos: " + dev.getConteudosInscritos().size() + " ---");
        dev.getConteudosInscritos().forEach(c -> 
            System.out.println("  • " + c.getTitulo() + " (XP: " + c.calcularXp() + ")")
        );
        System.out.println("\n--- Conteúdos Concluídos: " + dev.getConteudosConcluidos().size() + " ---");
        dev.getConteudosConcluidos().forEach(c -> 
            System.out.println("  ✓ " + c.getTitulo() + " (XP: " + c.calcularXp() + ")")
        );
        
        // Estatísticas por tipo de conteúdo
        long cursosConcluidos = dev.getConteudosConcluidos().stream()
            .filter(c -> c instanceof Curso)
            .count();
        long mentoriasConcluidas = dev.getConteudosConcluidos().stream()
            .filter(c -> c instanceof Mentoria)
            .count();
        long avaliacoesConcluidas = dev.getConteudosConcluidos().stream()
            .filter(c -> c instanceof Avaliacao)
            .count();
        
        System.out.println("\n--- Estatísticas por Tipo ---");
        System.out.println("  Cursos: " + cursosConcluidos);
        System.out.println("  Mentorias: " + mentoriasConcluidas);
        System.out.println("  Avaliações: " + avaliacoesConcluidas);
        
        System.out.println("=".repeat(60) + "\n");
    }

    /**
     * Gera relatório comparativo entre desenvolvedores.
     */
    public static void gerarRelatorioComparativo(List<Dev> devs) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("     RELATÓRIO COMPARATIVO");
        System.out.println("=".repeat(60));
        
        devs.forEach(dev -> {
            System.out.println(dev.getNome() + ":");
            System.out.println("  XP: " + dev.calcularTotalXp());
            System.out.println("  Nível: " + NivelProficiencia.determinarNivel(dev.calcularTotalXp()).getDescricao());
            System.out.println("  Conteúdos Concluídos: " + dev.getConteudosConcluidos().size());
            System.out.println();
        });
        
        // Ranking
        List<Dev> ranking = devs.stream()
            .sorted((d1, d2) -> Double.compare(d2.calcularTotalXp(), d1.calcularTotalXp()))
            .collect(Collectors.toList());
        
        System.out.println("--- RANKING ---");
        for (int i = 0; i < ranking.size(); i++) {
            System.out.println((i + 1) + "º " + ranking.get(i).getNome() + 
                             " - " + ranking.get(i).calcularTotalXp() + " XP");
        }
        
        System.out.println("=".repeat(60) + "\n");
    }
}

