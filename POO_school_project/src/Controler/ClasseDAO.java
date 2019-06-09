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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        public boolean create(Classe c)
        {
            try {
                stmt.executeQuery("INSERT INTO class(ID_annee,ID_niveau) VALUES ("+c.getAnnee_scolaire()+","+c.getNiveau()+")");
            }catch (SQLException ex) {return true;}
            return true;
        }
        
        public void init(Ecole e) throws SQLException
        {
            rset = stmt.executeQuery("SELECT * FROM classe WHERE ID_annee = 1");
            while(rset.next())
            {
                Classe c = new Classe(rset.getLong(1),rset.getLong(2),rset.getString(3), "ING"+rset.getString(3));
                System.out.println("CLASSE");
                StudentDAO sDAO = new StudentDAO();
                sDAO.init(e,c);
                e.getClasses().add(c);   
            }
        }
        
        
}
