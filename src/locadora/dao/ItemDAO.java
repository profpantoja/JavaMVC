/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import locadora.model.Item;

/**
 *
 * @author Pantoja
 */
public class ItemDAO {
 
    public void cadastrarItem(Item item) throws ExceptionDAO {        
        String sql = "Insert into item (codFilme, preço, tipo) values (?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, item.getFilme().getCodFilme());
            pStatement.setDouble(2, item.getPreço());
            pStatement.setString(3, item.getTipo());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO ("Erro ao cadastrar Item: " + e);
        } finally {
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);                
            }
        }
    }
    
}
