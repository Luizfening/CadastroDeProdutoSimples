/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import entidade.Eletro;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import negocio.NEletro;

/**
 *
 * @author Luiz Ricardo
 */
@WebService(serviceName = "WEletro")
public class WEletro {

    /**
     * Operação de Web service
     *
     * @param parameter
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "salvar")
    public void salvar(@WebParam(name = "parameter") Eletro parameter) {
        NEletro negocio = new NEletro();
        try {
            negocio.salvar(parameter);
        } catch (SQLException ex) {
            Logger.getLogger(WEletro.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * Operação de Web service
     *
     * @param parameter
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "excluir")
    public void excluir(@WebParam(name = "parameter") int parameter) {
        NEletro negocio = new NEletro();
        try {
            negocio.excluir(parameter);
        } catch (SQLException ex) {
            Logger.getLogger(WEletro.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Operação de Web service
     *
     * @param parameter
     * @return
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "consultar")
    public Eletro consultar(@WebParam(name = "parameter") int parameter) {
        NEletro negocio = new NEletro();
        try {
            return negocio.consultar(parameter);
        } catch (SQLException ex) {
            Logger.getLogger(WEletro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * Operação de Web service
     *
     * @param parameter
     * @return
     * @throws java.sql.SQLException
     */
    @WebMethod(operationName = "listar")
    public List<Eletro> listar(@WebParam(name = "parameter") Eletro parameter) {
        NEletro negocio = new NEletro();
        try {
            return negocio.listar(parameter);
        } catch (SQLException ex) {
            Logger.getLogger(WEletro.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
