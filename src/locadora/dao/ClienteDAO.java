/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.model.Cliente;

/**
 *
 * @author Pantoja
 */
public class ClienteDAO {
    
    public void cadastrarCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "insert into cliente (nome, cpf, email, endereço, dtnascimento) values (?,?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getCpf());
            pStatement.setString(3, cliente.getEmail());
            pStatement.setString(4, cliente.getEndereço());
            pStatement.setDate(5, new Date(cliente.getDtNascimento().getTime()));
            pStatement.execute();       
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao cadastrar Cliente: " + e);
        } finally {
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    public ArrayList<Cliente> listarClientes(String nome) throws ExceptionDAO {
        String sql = "select * from cliente where nome like '%" + nome + "%' order by nome";
        
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Cliente> clientes = null;
                
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery(sql);
            
            if(rs!=null) {
                clientes = new ArrayList<>();
                while(rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setCodCliente(rs.getInt("CodCliente"));
                    cliente.setNome(rs.getString("nome"));
                    cliente.setCpf(rs.getString("cpf"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereço(rs.getString("endereço"));
                    cliente.setDtNascimento(rs.getDate("dtnascimento"));
                    clientes.add(cliente);
                }
            }
            
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar clientes: " + e);
        } finally {
            try {
                if(pStatement!=null){pStatement.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o statement: " + e);
            }
            
            try {
                if(connection!=null){connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o conexão: " + e);
            }
        }
        
        return clientes;        
    }
    
     public void alterarCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "Update cliente set nome = ?, cpf = ?, email = ?, endereço = ?, dtnascimento = ? where codCliente = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getCpf());
            pStatement.setString(3, cliente.getEmail());
            pStatement.setString(4, cliente.getEndereço());
            pStatement.setDate(5, new Date(cliente.getDtNascimento().getTime()));
            pStatement.setInt(6, cliente.getCodCliente());
            pStatement.execute();       
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao alterar Cliente: " + e);
        } finally {
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e){
                throw new ExceptionDAO("Erro ao fechar o Statement: " + e);
            }
            
            try {
                if (connection != null) {connection.close();}
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
    
     public void apagarCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "Delete from Cliente where codCliente = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, cliente.getCodCliente());
            pStatement.execute();       
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar Cliente: " + e);
        } finally {
            try {
                if (pStatement != null) {pStatement.close();}
            } catch (SQLException e){
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
