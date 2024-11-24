package model;

public class GerenteDesenvolvedor extends Funcionario implements Gerencia, Desenvolve {

    public GerenteDesenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Cargo: Gerente Desenvolvedor");
    }

    @Override
    public void codar() {
        System.out.println("Codando...");
    }

    @Override
    public void resolverProblemas() {
        System.out.println("Resolvendo problemas...");
    }

    @Override
    public void organizarEquipe() {
        System.out.println("Organizando a equipe...");
    }

    @Override
    public void conduzirReunioes() {
        System.out.println("Conduzindo reuniões...");
    }
}