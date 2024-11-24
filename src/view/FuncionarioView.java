package view;

import java.util.Scanner;
import model.Funcionario;
import model.Desenvolvedor;
import model.Gerente;
import model.Treinador;
import model.GerenteDesenvolvedor;

public class FuncionarioView {
    private Scanner scanner = new Scanner(System.in);

    public int mostrarMenuPrincipal() {
        System.out.println("\n--- Sistema de Gerenciamento de Funcionários ---");
        System.out.println("1. Cadastrar Funcionário");
        System.out.println("2. Listar Funcionários");
        System.out.println("3. Atualizar Dados do Funcionário");
        System.out.println("4. Excluir Funcionário");
        System.out.println("5. Sair");
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public Funcionario capturarDadosFuncionario() {
        scanner.nextLine();  // Limpar buffer
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        
        System.out.println("Escolha o tipo de funcionário:");
        System.out.println("1. Desenvolvedor");
        System.out.println("2. Gerente");
        System.out.println("3. Treinador");
        System.out.println("4. Gerente Desenvolvedor");
        System.out.print("Escolha uma opção: ");
        int tipo = scanner.nextInt();

        switch (tipo) {
            case 1:
                return new Desenvolvedor(nome, salario);
            case 2:
                return new Gerente(nome, salario);
            case 3:
                return new Treinador(nome, salario);
            case 4:
                return new GerenteDesenvolvedor(nome, salario);
            default:
                System.out.println("Opção inválida. Cadastrando como Desenvolvedor por padrão.");
                return new Desenvolvedor(nome, salario); 
        }
    }

    public void mostrarFuncionario(Funcionario funcionario) {
        funcionario.mostrarDetalhes();
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public int capturarIdFuncionario() {
        System.out.print("Informe o ID do funcionário: ");
        return scanner.nextInt();
    }
}
