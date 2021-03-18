package locadora.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import locadora.model.Filme;
import locadora.model.Item;

/**
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
  
    public ArrayList<Item> listarItem(String título) throws ExceptionDAO {
        String sql = "select it.codItem, it.preço, it.tipo, fi.codFilme, fi.título "
                + "from item it, filme fi where it.codFilme = fi.codFilme and "
                + "fi.título like '%" + título + "%' order by fi.título";
        
        Connection connection = null;
        PreparedStatement pStatement = null;
        ArrayList<Item> itens = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            ResultSet rs = pStatement.executeQuery(sql);
            
            if(rs!=null){
                itens = new ArrayList<>();
                while (rs.next()) {
                    Item item = new Item();
                    item.setCodItem(rs.getInt("CodItem"));
                    item.setPreço(rs.getDouble("Preço"));
                    item.setTipo(rs.getString("Tipo"));
                    Filme filme = new Filme();
                    filme.setCodFilme(rs.getInt("CodFilme"));
                    filme.setTitulo(rs.getString("Título"));
                    item.setFilme(filme); 
                    itens.add(item);  
                }
            }   
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao consultar Item: " + e);
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
        return itens;
    }
 
        public void alterarItem(Item item) throws ExceptionDAO {        
        String sql = "update Item set codFilme = ?, preço = ?, tipo = ? where codItem = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, item.getFilme().getCodFilme());
            pStatement.setDouble(2, item.getPreço());
            pStatement.setString(3, item.getTipo());
            pStatement.setInt(4, item.getCodItem());
            pStatement.execute();
        } catch (SQLException e) {
            throw new ExceptionDAO ("Erro ao alterar Item: " + e);
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
        
    public void apagarItem(Item item) throws ExceptionDAO {
        
        String sql = "Delete From item where codItem = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new ConnectionMVC().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, item.getCodItem());
            pStatement.execute();
        
        } catch (SQLException e) {
            throw new ExceptionDAO("Erro ao apagar item: " + e);
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
