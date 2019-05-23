/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import entidade.Eletro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Luiz Ricardo
 */
public class PEletro {

    public void incluir(Eletro parametro) throws SQLException {

        Connection cnn = util.Conexao.getConexao();

        String sql = "INSERT INTO eletro(produto, cor, descricao)"
                + " VALUES (?,?,?)";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getProduto());
        prd.setString(2, parametro.getCor());
        prd.setString(3, parametro.getDescricao());

        prd.execute();

    }

    public void alterar(Eletro parametro) throws SQLException {
        Connection cnn = util.Conexao.getConexao();

        String sql = "UPDATE eletro SET produto=?, cor=?, descricao = ?"
                + " WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setString(1, parametro.getProduto());
        prd.setString(2, parametro.getCor());
        prd.setString(3, parametro.getDescricao());
        prd.setInt(4, parametro.getCodigo());

        prd.execute();
    }

    public void excluir(int parametro) throws SQLException {
        Connection cnn = util.Conexao.getConexao();

        String sql = "DELETE FROM eletro WHERE codigo = ?";

        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, parametro);

        prd.execute();
    }

    //Retorna um contato a partir do código do mesmo
    public Eletro consultar(int codigo) throws SQLException {

        Connection cnn = util.Conexao.getConexao();
        String sql = "SELECT * FROM eletro WHERE codigo = ?";
        PreparedStatement prd = cnn.prepareStatement(sql);
        prd.setInt(1, codigo);

        ResultSet rs = prd.executeQuery();

        Eletro retorno = new Eletro();
        if (rs.next()) {

            retorno.setCodigo(rs.getInt("codigo"));
            retorno.setProduto(rs.getString("produto"));
            retorno.setCor(rs.getString("cor"));
            retorno.setDescricao(rs.getString("descricao"));

        }

        return retorno;
    }

    //Retornará uma lista de contatos que 
    //satisfaçam os parametros listados
    public ArrayList<Eletro> listar(Eletro parametro) throws SQLException {
        Connection cnn = util.Conexao.getConexao();
        String sql = "SELECT * FROM eletro WHERE 1=1 ";

        if (parametro.getProduto() != null) {
            if (!parametro.getProduto().isEmpty()) {
                sql += " AND produto like ?";
            }
        }
        
        if (parametro.getDescricao() != null) {
            if (!parametro.getDescricao().isEmpty()) {
                sql += " AND descricao like ?";
            }
        }

        
        sql += " ORDER BY codigo";
        
        PreparedStatement prd = cnn.prepareStatement(sql);
        int cont = 1;
        if (parametro.getProduto() != null) {
            if (!parametro.getProduto().isEmpty()) {
                prd.setString(cont, "%" + parametro.getProduto() + "%");
                cont++;
            }
        }
        if (parametro.getDescricao() != null) {
            if (!parametro.getDescricao().isEmpty()) {
                prd.setString(cont, "%" + parametro.getDescricao() + "%");
            }
        }
        
        
        
        ResultSet rs = prd.executeQuery();

        ArrayList<Eletro> retorno = new ArrayList<>();

        while (rs.next()) {
            Eletro eletro = new Eletro();
            eletro.setCodigo(rs.getInt("codigo"));
            eletro.setProduto(rs.getString("produto"));
            eletro.setCor(rs.getString("cor"));
            eletro.setDescricao(rs.getString("descricao"));
            retorno.add(eletro);
        }

        return retorno;
    }

}
