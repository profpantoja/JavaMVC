/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

/**
 *
 * @author Pantoja
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.model.Filme;

public class FilmeDAO {
    
    public void cadastrarFilme(Filme filme) throws ExceptionDAO {
        
        String sql = "insert into filme (título, gênero, sinopse, duração) value (?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, filme.getTitulo());
            pStatement.setString(2, filme.getGenero());
            pStatement.setString(3, filme.getSinopse());
            pStatement.setInt(4, filme.getDuração());
            pStatement.execute();
        
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar filme: " + e);
        } finally {
        
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            } try {
                if (connection != null) {connection.close();}                
            } catch (SQLException e) {
                throw new ExceptionDAO ("Erro ao fechar a conexão: " + e);
            }
        }              
    }    

    public ArrayList<Filme> listarFilmes(String nome) throws ExceptionDAO {
        String sql = "select * from filme where título like '%" + nome + "%' order by título";
        
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Filme> filmes = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery(sql);
            
            if(rs!=null){
                filmes = new ArrayList<>();
                while (rs.next()) {
                    Filme filme = new Filme();
                    filme.setCodFilme(rs.getInt("CodFilme"));
                    filme.setTitulo(rs.getString("Título"));
                    filme.setGenero(rs.getString("Gênero"));
                    filme.setSinopse(rs.getString("Sinopse"));
                    filme.setDuração(rs.getInt("Duração"));
                    filmes.add(filme);  
                }
            }   
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar Filmes: " + e);
        } finally {
            try {
                if(pStatement!=null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o pStatement: " + e);
            }
            try {
                if(connection!=null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
        return filmes;
    }

    public void alterarFilme(Filme filme) throws ExceptionDAO {
        String sql = "Update Filme set título = ?, gênero = ?, sinopse = ?, duração = ? where codFilme = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, filme.getTitulo());
            pStatement.setString(2, filme.getGenero());
            pStatement.setString(3, filme.getSinopse());
            pStatement.setInt(4, filme.getDuração());
            pStatement.setInt(5, filme.getCodFilme());
            pStatement.execute();
            
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar Filme: " + e);
        } finally {
            try {
                if(pStatement!=null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o pStatement: " + e);
            }
            try {
                if(connection!=null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }        
    }
    
    public void apagarFilme(Filme filme) throws ExceptionDAO {
        
        String sql = "Delete From Filme where codFilme = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, filme.getCodFilme());
            pStatement.execute();
        
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar filme: " + e);
        } finally {
        
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            } try {
                if (connection != null) {connection.close();}                
            } catch (SQLException e) {
                throw new ExceptionDAO ("Erro ao fechar a conexão: " + e);
            }
        }              
    }
}
