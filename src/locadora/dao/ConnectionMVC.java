/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package locadora.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Pantoja
 */
public class ConnectionMVC {
    
    public Connection getConnection() {
        Connection conn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mvc?useSSL=false", "root", "cefet123");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return conn;
    }
    
}
