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
public class StudentDAO extends DAO<Student>{
        public StudentDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(Student s)
        {
            return false;
        }
        
        public void init(Ecole e, Classe c) throws SQLException
        {
            ResultSet rs = null;
            rset = stmt.executeQuery("SELECT e.* FROM personne e, inscription i WHERE i.ID_classe = "+c.getID()+" AND e.ID = i.ID_eleve");
            while(rset.next())
            {
                System.out.println(c.getID());
                Student s = new Student(rset.getLong(1),rset.getString(2),rset.getString(3));
                ReportDAO rDAO = new ReportDAO();
                System.out.println("STUDENT");
                rDAO.init(e,c,s);
                s.display();
                c.getStudents().add(s);
            }
        }
        
        
        public void updateNomBDD(Student s, String fn, String ln)
        {
            try {
                System.out.println(s.getID());
                
                System.out.println(fn+" "+ln);
                stmt.executeUpdate("UPDATE personne SET Nom = '"+ln+"', Prenom = '"+fn+"' WHERE ID = "+s.getID());
            }catch (SQLException ex) {System.out.println("OOOOO\nOOOOO\nOOOOO");}
        }
        
        
}
