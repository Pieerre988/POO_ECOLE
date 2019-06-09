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
public class ProfessorDAO extends DAO<Professor>{
        public ProfessorDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(Professor p)
        {
          /*  try {
                stmt.executeQuery("INSERT INTO class(ID_annee,ID_niveau) VALUES ("+c.getAnnee_scolaire()+","+c.getNiveau()+")");
            }catch (SQLException ex) {return true;}*/
            return true;
        }
        
        public void init(Ecole e) throws SQLException
        {
            rset = stmt.executeQuery("SELECT p.ID, p.Prenom, p.Nom, d.Nom FROM personne p, enseignement e, discipline d WHERE p.type=1 AND e.ID_prof = p.ID AND d.ID = e.ID_discipline ");
            while(rset.next())
            {
                //public Professor(Long ID,String fn,String ln,String m)
                Professor p = new Professor(rset.getLong(1), rset.getString(2),rset.getString(3),rset.getString(4));
                System.out.println("PROFESSOR");
                e.getProfesseurs().add(p);
            }
        }
        
        public void updateNomBDD(Professor p, String fn, String ln)
        {
            try {
                System.out.println(p.getID());
                
                System.out.println(fn+" "+ln);
                stmt.executeUpdate("UPDATE personne SET Nom = '"+ln+"', Prenom = '"+fn+"' WHERE ID = "+p.getID());
            }catch (SQLException ex) {System.out.println("OOOOO\nOOOOO\nOOOOO");}
        }     
}
