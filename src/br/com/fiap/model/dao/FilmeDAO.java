package br.com.fiap.model.dao;

//      Integrantes do Grupo

//      Tárik Moussa Alma - RM: 571411
//      Giovanni Azevedo - RM: 572894
//      Fabricio Aquiles Sales da Silva - RM: 570985
//      Carlos Eduardo Tsucamoto Chiarelli - RM: 569574
//      Ítalo Neto - RM: 572912

import br.com.fiap.model.dto.Filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class FilmeDAO {
    //atributo
    private Connection con;

    //construtor
    public FilmeDAO(Connection con) {
        this.con = con;
    }

    //metodo getter
    public Connection getCon() {
        return con;
    }

    //métodos da classe

    //o código n entra no insert porque a coluna é generate by default
    public String inserir(Filme filme) {
        String sql = "insert into ddd_filme(titulo, genero, produtora) values (?,?,?)";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());

            if (ps.executeUpdate() > 0) {
                return "Filme inserido com sucesso!";
            } else {
                return "Erro ao inserir filme!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String alterar(Filme filme) {
        String sql = "update ddd_filme set titulo=?, genero=?, produtora=? where codigo=?";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setString(1, filme.getTitulo());
            ps.setString(2, filme.getGenero());
            ps.setString(3, filme.getProdutora());
            ps.setInt(4, filme.getCodigo());

            if (ps.executeUpdate() > 0) {
                return "Filme alterado com sucesso!";
            } else {
                return "Erro ao alterar o filme!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public String excluir(Filme filme) {
        String sql = "delete from ddd_filme where codigo=?";
        //try-with-resources
        try (PreparedStatement ps = getCon().prepareStatement(sql)) {

            ps.setInt(1, filme.getCodigo());

            if (ps.executeUpdate() > 0) {
                return "Filme excluído com sucesso!";
            } else {
                return "Erro ao excluir o filme!";
            }
        } catch (SQLException e) {
            return "Erro de SQL: " + e.getMessage();
        }
    }

    public ArrayList<Filme> listarTodos() {
        String sql = "select * from ddd_filme order by codigo";
        ArrayList<Filme> listaFilme = new ArrayList<>();

        try (PreparedStatement ps = getCon().prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Filme filme = new Filme();
                filme.setCodigo(rs.getInt("codigo"));
                filme.setTitulo(rs.getString("titulo"));
                filme.setGenero(rs.getString("genero"));
                filme.setProdutora(rs.getString("produtora"));
                listaFilme.add(filme);
            }
            return listaFilme;

        } catch (SQLException e) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return null;
        }
    }
}
