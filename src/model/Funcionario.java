package model;

import java.io.Serializable;

public abstract class Funcionario implements Serializable {
    private String nome;
    private double salario;

    public Funcionario(String nome, double salario) {
        this.nome = nome;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public double getSalario() {
        return salario;
    }

    public void receberAumento(double aumento) {
        this.salario += aumento;
    }

    public abstract void mostrarDetalhes();
}
