import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal que demonstra o uso prático do Sistema de Gestão de Desenvolvimento Profissional.
 * 
 * Este sistema demonstra os 4 pilares da POO:
 * - ABSTRAÇÃO: Classes abstratas (Conteudo) e interfaces bem definidas
 * - ENCAPSULAMENTO: Atributos privados com métodos de acesso controlado
 * - HERANÇA: Curso, Mentoria e Avaliacao herdam de Conteudo
 * - POLIMORFISMO: Método calcularXp() implementado de forma diferente em cada classe
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE GESTÃO DE DESENVOLVIMENTO PROFISSIONAL        ║");
        System.out.println("║  Demonstração dos Pilares da POO                         ║");
        System.out.println("╚═══════════════════════════════════════════════════════════╝\n");

        // ========== CRIANDO CONTEÚDOS ==========
        // Demonstra HERANÇA: Curso, Mentoria e Avaliacao herdam de Conteudo
        
        System.out.println("📚 CRIANDO CONTEÚDOS...\n");
        
        Curso cursoJava = new Curso();
        cursoJava.setTitulo("Java Básico ao Avançado");
        cursoJava.setDescricao("Aprenda Java do zero até conceitos avançados");
        cursoJava.setCargaHoraria(40);

        Curso cursoSpring = new Curso();
        cursoSpring.setTitulo("Spring Framework");
        cursoSpring.setDescricao("Desenvolvimento de APIs REST com Spring Boot");
        cursoSpring.setCargaHoraria(30);

        Curso cursoJS = new Curso();
        cursoJS.setTitulo("JavaScript Moderno");
        cursoJS.setDescricao("ES6+, Async/Await, Promises");
        cursoJS.setCargaHoraria(20);

        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria: Carreira Java");
        mentoriaJava.setDescricao("Orientações sobre mercado de trabalho Java");
        mentoriaJava.setData(LocalDate.now().plusDays(7));

        Mentoria mentoriaCarreira = new Mentoria();
        mentoriaCarreira.setTitulo("Mentoria: Desenvolvimento de Carreira");
        mentoriaCarreira.setDescricao("Como se destacar no mercado de tecnologia");
        mentoriaCarreira.setData(LocalDate.now().plusDays(14));

        // Nova funcionalidade: Avaliações
        // Demonstra POLIMORFISMO: calcularXp() implementado de forma diferente
        Avaliacao avaliacaoJava = new Avaliacao();
        avaliacaoJava.setTitulo("Avaliação: Fundamentos Java");
        avaliacaoJava.setDescricao("Teste seus conhecimentos em Java");
        avaliacaoJava.setQuantidadeQuestoes(20);
        avaliacaoJava.setNotaMinima(7.0);
        avaliacaoJava.setNotaObtida(8.5); // Aprovado

        Avaliacao avaliacaoSpring = new Avaliacao();
        avaliacaoSpring.setTitulo("Avaliação: Spring Boot");
        avaliacaoSpring.setDescricao("Avaliação prática de Spring Boot");
        avaliacaoSpring.setQuantidadeQuestoes(15);
        avaliacaoSpring.setNotaMinima(7.0);
        avaliacaoSpring.setNotaObtida(6.5); // Não aprovado

        // ========== CRIANDO BOOTCAMPS ==========
        System.out.println("🚀 CRIANDO BOOTCAMPS...\n");

        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("Formação completa em Java e Spring");
        bootcampJava.getConteudos().add(cursoJava);
        bootcampJava.getConteudos().add(cursoSpring);
        bootcampJava.getConteudos().add(mentoriaJava);
        bootcampJava.getConteudos().add(avaliacaoJava);

        Bootcamp bootcampFullStack = new Bootcamp();
        bootcampFullStack.setNome("Bootcamp Full Stack Developer");
        bootcampFullStack.setDescricao("Desenvolvimento completo frontend e backend");
        bootcampFullStack.getConteudos().add(cursoJava);
        bootcampFullStack.getConteudos().add(cursoJS);
        bootcampFullStack.getConteudos().add(mentoriaCarreira);
        bootcampFullStack.getConteudos().add(avaliacaoSpring);

        // ========== CRIANDO DESENVOLVEDORES ==========
        System.out.println("👨‍💻 CRIANDO DESENVOLVEDORES...\n");

        Dev devCamila = new Dev();
        devCamila.setNome("Camila Silva");
        devCamila.inscreverBootcamp(bootcampJava);
        
        Dev devJoao = new Dev();
        devJoao.setNome("João Santos");
        devJoao.inscreverBootcamp(bootcampFullStack);
        
        Dev devMaria = new Dev();
        devMaria.setNome("Maria Oliveira");
        devMaria.inscreverBootcamp(bootcampJava);
        devMaria.inscreverBootcamp(bootcampFullStack);

        // ========== SIMULANDO PROGRESSO ==========
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("           SIMULANDO PROGRESSO DOS DESENVOLVEDORES");
        System.out.println("═══════════════════════════════════════════════════════════\n");

        System.out.println("--- Progresso de " + devCamila.getNome() + " ---");
        System.out.println("Conteúdos Inscritos: " + devCamila.getConteudosInscritos().size());
        
        // Camila progride nos conteúdos
        devCamila.progredir(); // Completa curso Java
        devCamila.progredir(); // Completa curso Spring
        devCamila.progredir(); // Completa mentoria
        devCamila.progredir(); // Completa avaliação
        
        System.out.println("\n--- Progresso de " + devJoao.getNome() + " ---");
        devJoao.progredir(); // Completa curso Java
        devJoao.progredir(); // Completa curso JS
        
        System.out.println("\n--- Progresso de " + devMaria.getNome() + " ---");
        devMaria.progredir(); // Completa curso Java
        devMaria.progredir(); // Completa curso Spring
        devMaria.progredir(); // Completa mentoria Java
        devMaria.progredir(); // Completa avaliação Java
        devMaria.progredir(); // Completa curso JS
        devMaria.progredir(); // Completa mentoria carreira

        // ========== RELATÓRIOS DE PROGRESSO ==========
        // Demonstra ABSTRAÇÃO: métodos estáticos que encapsulam lógica complexa
        System.out.println("\n");
        RelatorioProgresso.gerarRelatorio(devCamila);
        RelatorioProgresso.gerarRelatorio(devJoao);
        RelatorioProgresso.gerarRelatorio(devMaria);

        // ========== RELATÓRIO COMPARATIVO ==========
        List<Dev> todosDevs = new ArrayList<>();
        todosDevs.add(devCamila);
        todosDevs.add(devJoao);
        todosDevs.add(devMaria);
        
        RelatorioProgresso.gerarRelatorioComparativo(todosDevs);

        // ========== SISTEMA DE RECOMENDAÇÕES ==========
        // Demonstra POLIMORFISMO: trabalha com diferentes tipos de Conteudo
        System.out.println("\n");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("              SISTEMA DE RECOMENDAÇÕES");
        System.out.println("═══════════════════════════════════════════════════════════\n");

        List<Bootcamp> bootcampsDisponiveis = new ArrayList<>();
        bootcampsDisponiveis.add(bootcampJava);
        bootcampsDisponiveis.add(bootcampFullStack);

        System.out.println("Recomendações para " + devJoao.getNome() + ":");
        List<Bootcamp> recomendacoesJoao = SistemaRecomendacoes.recomendarBootcamps(devJoao, bootcampsDisponiveis);
        recomendacoesJoao.forEach(b -> System.out.println("  • " + b.getNome()));

        SistemaRecomendacoes.sugerirProximosPassos(devJoao);

        // ========== EXIBINDO CERTIFICADOS E BADGES ==========
        System.out.println("\n");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("              CERTIFICADOS E CONQUISTAS");
        System.out.println("═══════════════════════════════════════════════════════════\n");

        System.out.println("Certificados de " + devCamila.getNome() + ":");
        devCamila.getCertificados().forEach(System.out::println);

        System.out.println("\nBadges de " + devCamila.getNome() + ":");
        devCamila.getBadges().forEach(b -> System.out.println("  " + b));

        System.out.println("\nBadges de " + devMaria.getNome() + ":");
        devMaria.getBadges().forEach(b -> System.out.println("  " + b));

        // ========== DEMONSTRAÇÃO DOS PILARES ==========
        System.out.println("\n");
        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("        DEMONSTRAÇÃO DOS PILARES DA POO");
        System.out.println("═══════════════════════════════════════════════════════════\n");

        System.out.println("1. ABSTRAÇÃO:");
        System.out.println("   - Classe abstrata Conteudo define contrato comum");
        System.out.println("   - Métodos abstratos forçam implementação nas subclasses\n");

        System.out.println("2. ENCAPSULAMENTO:");
        System.out.println("   - Atributos privados protegidos por getters/setters");
        System.out.println("   - Lógica interna (verificarBadges) não exposta externamente\n");

        System.out.println("3. HERANÇA:");
        System.out.println("   - Curso, Mentoria e Avaliacao herdam de Conteudo");
        System.out.println("   - Reutilização de código e estrutura comum\n");

        System.out.println("4. POLIMORFISMO:");
        System.out.println("   - calcularXp() implementado diferente em cada classe:");
        System.out.println("     • Curso: XP_PADRAO * cargaHoraria");
        System.out.println("     • Mentoria: XP_PADRAO + 20");
        System.out.println("     • Avaliacao: XP baseado em questões e desempenho");
        System.out.println("   - Mesmo método, comportamentos diferentes!\n");

        System.out.println("═══════════════════════════════════════════════════════════");
        System.out.println("                    FIM DA DEMONSTRAÇÃO");
        System.out.println("═══════════════════════════════════════════════════════════\n");
    }
}
