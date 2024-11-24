package model;

public class Gerente extends Funcionario implements Gerencia {

    public Gerente(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Cargo: Gerente");
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
