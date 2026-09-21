package br.com.fiap.view;

//      Integrantes do Grupo

//      Tárik Moussa Alma - RM: 571411
//      Giovanni Azevedo - RM: 572894
//      Fabricio Aquiles Sales da Silva - RM: 570985
//      Carlos Eduardo Tsucamoto Chiarelli - RM: 569574
//      Ítalo Neto - RM: 572912

import br.com.fiap.controller.FilmeController;

import javax.swing.*;

public class FilmeView {
    static void main() {

        String titulo, genero, produtora;
        int codigo;
        String[] escolha = {"Inserir", "Alterar", "Excluir", "Listar"};
        int opcao;
        FilmeController filmeController = new FilmeController();

        do {
            try {

                opcao = JOptionPane.showOptionDialog(
                        null,
                        "Escolha uma das opções abaixo para manipular um Filme",
                        "Escolha",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        escolha,
                        escolha[0]
                );

                switch (opcao) {
                    case 0:
                        titulo = JOptionPane.showInputDialog(null, "Digite o título do filme");
                        genero = JOptionPane.showInputDialog(null, "Digite o gênero do filme");
                        produtora = JOptionPane.showInputDialog(null, "Digite a produtora do filme");
                        System.out.println(filmeController.inserirFilme(titulo, genero, produtora));
                        break;
                    case 1:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do filme que deseja alterar"));
                        titulo = JOptionPane.showInputDialog(null, "Digite o NOVO título do filme");
                        genero = JOptionPane.showInputDialog(null, "Digite o NOVO gênero do filme");
                        produtora = JOptionPane.showInputDialog(null, "Digite a NOVA produtora do filme");
                        System.out.println(filmeController.alterarFilme(codigo, titulo, genero, produtora));
                        break;
                    case 2:
                        codigo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o código do filme que deseja excluir"));
                        System.out.println(filmeController.excluirFilme(codigo));
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, filmeController.listarTodosFilmes());
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }

            } catch (Exception e) {
                System.out.println("Erro: " + e.getMessage());
            }

        } while (JOptionPane.showConfirmDialog(null, "Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == 0);

        System.out.println("Fim de Programa");
    }
}
