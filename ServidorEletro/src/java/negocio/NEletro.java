/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import entidade.Eletro;
import java.sql.SQLException;
import java.util.List;
import persistencia.PEletro;

/**
 *
 * @author Luiz Ricardo
 */
public class NEletro {
    
    PEletro persistencia;

    public NEletro() {
        persistencia = new PEletro();
    }
    
    public void salvar(Eletro eletro) throws SQLException{

        //validação
        if(eletro.getProduto().isEmpty()
           || eletro.getCor().isEmpty()
           || eletro.getDescricao().isEmpty()){
            
            throw new IllegalArgumentException("É necessário"
                    + " preencher todos os campos para salvar.");
            
        }
        
        if(eletro.getCodigo() == 0){
            persistencia.incluir(eletro);
        }else{
            persistencia.alterar(eletro);
        }
        
    }
    
    public void excluir(int codigo) throws SQLException{
        persistencia.excluir(codigo);
    }
   
    public Eletro consultar (int codigo) throws SQLException{
        return persistencia.consultar(codigo);
    }
    
    public List<Eletro> listar(Eletro cor) throws SQLException{
        return persistencia.listar(cor);
    }
    
}
