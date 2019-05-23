/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luiz Ricardo
 */
public class Conexao {

    private static Connection conexao;

    public static Connection getConexao() {
        
        try {
            if(conexao == null || conexao.isClosed())
                conexao = conectar();
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar no banco");
        }
        
        return conexao;
    }
    
    private static Connection conectar() {

        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection("jdbc:postgresql://localhost:5432/eletro"
                    , "postgres", "markim123");
        } catch (ClassNotFoundException e) {
            System.out.print("Driver não encontrado! Verifique!");
        } catch (SQLException e) {
            System.out.println("Banco, porta, usuário ou senha errado(s). Verifique!");
        }catch (Exception e) {
            System.out.println("Ocorreu um erro desconhecido!");
        }
        return null;
    }
}
