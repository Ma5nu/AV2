package model;

public class Desenvolvedor extends Funcionario implements Desenvolve {

    public Desenvolvedor(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Cargo: Desenvolvedor");
    }

    @Override
    public void codar() {
        System.out.println("Codando...");
    }

    @Override
    public void resolverProblemas() {
        System.out.println("Resolvendo problemas...");
    }  
}
