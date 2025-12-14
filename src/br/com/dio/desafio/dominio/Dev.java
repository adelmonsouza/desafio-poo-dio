package br.com.dio.desafio.dominio;

import java.util.*;

/**
 * Classe que representa um Desenvolvedor.
 * Demonstra ENCAPSULAMENTO com atributos privados e métodos públicos.
 * Demonstra POLIMORFISMO ao trabalhar com diferentes tipos de Conteudo.
 */
public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Set<Certificado> certificados = new HashSet<>();
    private Set<Badge> badges = new HashSet<>();
    private Set<Bootcamp> bootcampsInscritos = new HashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        this.bootcampsInscritos.add(bootcamp);
        bootcamp.getDevsInscritos().add(this);
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if(conteudo.isPresent()) {
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosInscritos.remove(conteudo.get());
            
            // Verifica se completou algum bootcamp
            verificarCompletacaoBootcamp();
            
            // Verifica se ganhou alguma badge
            verificarBadges();
        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo!");
        }
    }

    /**
     * Verifica se completou todos os conteúdos de algum bootcamp.
     * Demonstra ABSTRAÇÃO ao encapsular a lógica de verificação.
     */
    private void verificarCompletacaoBootcamp() {
        for (Bootcamp bootcamp : bootcampsInscritos) {
            boolean completou = bootcamp.getConteudos().stream()
                .allMatch(conteudo -> conteudosConcluidos.contains(conteudo));
            
            if (completou && !temCertificado(bootcamp)) {
                Certificado certificado = new Certificado(
                    this.nome, 
                    bootcamp.getNome(), 
                    calcularTotalXp()
                );
                certificados.add(certificado);
                System.out.println("\n🎉 Parabéns! Você completou o bootcamp: " + bootcamp.getNome());
                System.out.println(certificado);
            }
        }
    }

    /**
     * Verifica se o desenvolvedor ganhou alguma badge baseado em XP.
     */
    private void verificarBadges() {
        double xpTotal = calcularTotalXp();
        
        // Badge de Primeiros Passos
        if (xpTotal >= 50 && !temBadge("Primeiros Passos")) {
            badges.add(new Badge("Primeiros Passos", "Alcançou 50 XP", "🌱", 50));
            System.out.println("🏆 Nova Badge: Primeiros Passos!");
        }
        
        // Badge de Dedicação
        if (conteudosConcluidos.size() >= 5 && !temBadge("Dedicação")) {
            badges.add(new Badge("Dedicação", "Completou 5 conteúdos", "🔥", 0));
            System.out.println("🏆 Nova Badge: Dedicação!");
        }
        
        // Badge de Especialista
        if (xpTotal >= 500 && !temBadge("Especialista")) {
            badges.add(new Badge("Especialista", "Alcançou 500 XP", "⭐", 500));
            System.out.println("🏆 Nova Badge: Especialista!");
        }
    }

    private boolean temCertificado(Bootcamp bootcamp) {
        return certificados.stream()
            .anyMatch(c -> c.getNomeBootcamp().equals(bootcamp.getNome()));
    }

    private boolean temBadge(String nomeBadge) {
        return badges.stream()
            .anyMatch(b -> b.getNome().equals(nomeBadge));
    }

    /**
     * Verifica se completou um bootcamp específico.
     */
    public boolean completouBootcamp(Bootcamp bootcamp) {
        return bootcamp.getConteudos().stream()
            .allMatch(conteudo -> conteudosConcluidos.contains(conteudo));
    }

    /**
     * Obtém o nível atual de proficiência.
     * Demonstra POLIMORFISMO ao usar o enum NivelProficiencia.
     */
    public NivelProficiencia getNivelAtual() {
        return NivelProficiencia.determinarNivel(calcularTotalXp());
    }

    public double calcularTotalXp() {
        Iterator<Conteudo> iterator = this.conteudosConcluidos.iterator();
        double soma = 0;
        while(iterator.hasNext()){
            double next = iterator.next().calcularXp();
            soma += next;
        }
        return soma;

        /*return this.conteudosConcluidos
                .stream()
                .mapToDouble(Conteudo::calcularXp)
                .sum();*/
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    public Set<Certificado> getCertificados() {
        return certificados;
    }

    public void setCertificados(Set<Certificado> certificados) {
        this.certificados = certificados;
    }

    public Set<Badge> getBadges() {
        return badges;
    }

    public void setBadges(Set<Badge> badges) {
        this.badges = badges;
    }

    public Set<Bootcamp> getBootcampsInscritos() {
        return bootcampsInscritos;
    }

    public void setBootcampsInscritos(Set<Bootcamp> bootcampsInscritos) {
        this.bootcampsInscritos = bootcampsInscritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
