package br.com.fiap.controller;

//      Integrantes do Grupo

//      Tárik Moussa Alma - RM: 571411
//      Giovanni Azevedo - RM: 572894
//      Fabricio Aquiles Sales da Silva - RM: 570985
//      Carlos Eduardo Tsucamoto Chiarelli - RM: 569574
//      Ítalo Neto - RM: 572912

import br.com.fiap.model.dao.ConnectionFactory;
import br.com.fiap.model.dao.FilmeDAO;
import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeController {

    public String inserirFilme(String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.inserir(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String alterarFilme(int codigo, String titulo, String genero, String produtora) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        filme.setTitulo(titulo);
        filme.setGenero(genero);
        filme.setProdutora(produtora);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.alterar(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String excluirFilme(int codigo) throws ClassNotFoundException, SQLException {
        String resultado;
        Connection con = ConnectionFactory.abrirConexao();
        Filme filme = new Filme();
        filme.setCodigo(codigo);
        FilmeDAO filmeDAO = new FilmeDAO(con);
        resultado = filmeDAO.excluir(filme);
        ConnectionFactory.fecharConexao(con);

        return resultado;
    }

    public String listarTodosFilmes() throws ClassNotFoundException, SQLException {
        Connection con = ConnectionFactory.abrirConexao();
        FilmeDAO filmeDAO = new FilmeDAO(con);
        ArrayList<Filme> lista = filmeDAO.listarTodos();
        ConnectionFactory.fecharConexao(con);

        String resultado = "";

        if (lista != null) {
            for (Filme filme : lista) {
                resultado += "Código: " + filme.getCodigo() +
                        " | Título: " + filme.getTitulo() +
                        " | Gênero: " + filme.getGenero() +
                        " | Produtora: " + filme.getProdutora() + "\n";
            }
        }

        return resultado;
    }
}
