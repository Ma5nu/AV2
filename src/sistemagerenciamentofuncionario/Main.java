package sistemagerenciamentofuncionario;

import model.Funcionario;
import model.Desenvolvedor;
import model.Gerente;
import model.GerenteDesenvolvedor;
import model.Treinador;
import controller.FuncionarioController;
import view.FuncionarioView;

public class Main {
    public static void main(String[] args) {
        FuncionarioView view = new FuncionarioView();
        FuncionarioController controller = new FuncionarioController(view);
        controller.iniciarSistema();
    }
}