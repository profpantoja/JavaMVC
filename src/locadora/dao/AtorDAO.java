/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.model.Ator;

/**
 *
 * @author Pantoja
 */
public class AtorDAO {
    
    public void cadastrarAtor(Ator ator) throws ExceptionDAO {        
        String sql = "Insert into ator (nome, nacionalidade) values (?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, ator.getName());
            pStatement.setString(2, ator.getNacionalidade());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO ("Erro ao cadastrar Ator: " + e);
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
    
    public ArrayList<Ator> listarAtores(String nome) throws ExceptionDAO {
        String sql = "select * from ator where nome like '%" + nome + "%' order by nome";
        
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Ator> atores = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery(sql);
            
            if (rs!=null) {
                atores = new ArrayList<Ator>();
                while(rs.next()){
                    Ator ator = new Ator();
                    ator.setCodAtor(rs.getInt("CodAtor"));
                    ator.setName(rs.getString("Nome"));
                    ator.setNacionalidade(rs.getString("Nacionalidade"));
                    atores.add(ator);
                }
            }
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar atores: " + e);
        } finally {
            try {
                if(pStatement != null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o pStatement: " + e);
            }
            try {
                if(connection != null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }        
        return atores;
    }
    
    public void alterarAtor(Ator ator) throws ExceptionDAO {
        
        String sql = "Update ator set nome = ?, nacionalidade = ? where codAtor = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, ator.getName());
            pStatement.setString(2, ator.getNacionalidade());
            pStatement.setInt(3, ator.getCodAtor());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO ("Erro ao alterar Ator: " + e);
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

public void apagarAtor(Ator ator) throws ExceptionDAO {        
        String sql = "Delete from Ator where CodAtor = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, ator.getCodAtor());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO ("Erro ao apagar Ator: " + e);
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
