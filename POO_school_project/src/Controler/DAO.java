/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import java.sql.*;

/**
 *
 * @author talmo
 * @param <T>
 */
public abstract class DAO<T> {
    protected Connection connect = null;
    protected Statement stmt;
    protected ResultSet rset;
    
    public DAO() throws SQLException
    {
        try {
            // chargement driver "com.mysql.jdbc.Driver"
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        String urlDatabase = "jdbc:mysql://localhost/ecole";
        String loginDatabase = "root";
        String passwordDatabase = "";
        try{
           connect = DriverManager.getConnection(urlDatabase,loginDatabase,passwordDatabase);
           stmt = connect.createStatement();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }
    
    // CRUD
    
    public boolean create(T a)
    {
        return false;
    }
    
    public boolean research(T a)
    {
        return false;
    }
    
    public boolean update(T a)
    {
        return false;
    }
    
    public boolean delete(T a)
    {
        return false;
    }
    
}
