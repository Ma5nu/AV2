package model;

public class Treinador extends Funcionario implements Treina {

    public Treinador(String nome, double salario) {
        super(nome, salario);
    }

    @Override
    public void mostrarDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Salário: " + getSalario());
        System.out.println("Cargo: Treinador");
    }

    @Override
    public void ensinarTecnologia() {
        System.out.println("Ensinando tecnologia...");
    }

    @Override
    public void motivarEquipe() {
        System.out.println("Motivando a equipe...");
    }
}
