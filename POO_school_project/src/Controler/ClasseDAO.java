/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author talmo
 */
public class ClasseDAO extends DAO<Classe>{
        public ClasseDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(Classe s)
        {
            return false;
        }
        
        public void init(ArrayList<Classe> a) throws SQLException
        {
            rset = stmt.executeQuery("SELECT * FROM classe WHERE Id_annee = 1");
            while(rset.next())
            {
                Classe c = new Classe(rset.getLong(1),rset.getLong(2),rset.getString(3), "Test");
                StudentDAO sDAO = new StudentDAO();
                sDAO.init(c);
                a.add(c);   
            }
        }
        
        
}
