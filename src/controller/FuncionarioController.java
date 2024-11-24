package controller;

import java.util.ArrayList;
import java.io.*;
import model.*;
import view.FuncionarioView;

public class FuncionarioController {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private FuncionarioView view;
    private final String FILE_NAME = "funcionarios.dat";

    public FuncionarioController(FuncionarioView view) {
        this.view = view;
        carregarDados();
    }

    public void iniciarSistema() {
        boolean executando = true;

        while (executando) {
            int opcao = view.mostrarMenuPrincipal();
            switch (opcao) {
                case 1:
                    cadastrarFuncionario();
                    break;
                case 2:
                    listarFuncionarios();
                    break;
                case 3:
                    atualizarFuncionario();
                    break;
                case 4:
                    excluirFuncionario();
                    break;
                case 5:
                    executando = false;
                    salvarDados();
                    break;
                default:
                    view.mostrarMensagem("Opção inválida.");
            }
        }
    }

    private void cadastrarFuncionario() {
        Funcionario funcionario = view.capturarDadosFuncionario();
        funcionarios.add(funcionario);
        salvarDados();
        view.mostrarMensagem("Funcionário cadastrado com sucesso.");
    }

    private void listarFuncionarios() {
        if (funcionarios.isEmpty()) {
            view.mostrarMensagem("Nenhum funcionário cadastrado.");
        } else {
            for (Funcionario funcionario : funcionarios) {
                view.mostrarFuncionario(funcionario);
            }
        }
    }

    private void atualizarFuncionario() {
        int id = view.capturarIdFuncionario();
        if (id >= 0 && id < funcionarios.size()) {
            Funcionario funcionario = funcionarios.get(id);
            
            // Capture os novos dados do funcionário
            scanner.nextLine();  // Limpar o buffer
            System.out.print("Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Novo Salário: ");
            double salario = scanner.nextDouble();
            
            // Atualize os dados do funcionário
            funcionario.setNome(nome);
            funcionario.setSalario(salario);
            
            salvarDados();
            view.mostrarMensagem("Funcionário atualizado com sucesso.");
        } else {
            view.mostrarMensagem("ID inválido.");
        }
    }

    private void excluirFuncionario() {
        int id = view.capturarIdFuncionario();
        if (id >= 0 && id < funcionarios.size()) {
            funcionarios.remove(id);
            salvarDados();
            view.mostrarMensagem("Funcionário excluído com sucesso.");
        } else {
            view.mostrarMensagem("ID inválido.");
        }
    }

    private void salvarDados() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(funcionarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void carregarDados() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
                funcionarios = (ArrayList<Funcionario>) in.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            // Cria o arquivo se ele não existir
            try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
                out.writeObject(new ArrayList<Funcionario>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}