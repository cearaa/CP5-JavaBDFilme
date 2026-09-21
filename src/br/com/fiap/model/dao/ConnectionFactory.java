package br.com.fiap.model.dao;

//      Integrantes do Grupo

//      Tárik Moussa Alma - RM: 571411
//      Giovanni Azevedo - RM: 572894
//      Fabricio Aquiles Sales da Silva - RM: 570985
//      Carlos Eduardo Tsucamoto Chiarelli - RM: 569574
//      Ítalo Neto - RM: 572912

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public static Connection abrirConexao(){
        Connection con = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL";
            final String USER = "rm571411";
            final String PASS = "030208";
            con = DriverManager.getConnection(url,USER,PASS);
            System.out.println("Conexão Aberta!!");

        } catch (ClassNotFoundException e) {
            System.out.println("Erro: A classse de conexão não foi encontrada." + e.getMessage());
        } catch (SQLException e) {
        System.out.println("Erro de SQL: " + e.getMessage());
        }

        return con;
    }

    public static void fecharConexao(Connection con){
        try {
            con.close();
            System.out.println("Conexão encerrada.");
        } catch (SQLException e){
            System.out.println("Erro de SQL: " + e.getMessage());
        }
    }

}
