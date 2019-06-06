/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_school_project;
import view.connexion;
import java.sql.*;
import java.util.*;
import view.Bulletins;
import Model.*;
/**
 *
 * @author Pierre
 */
public class POO_school_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<String> alpha = null;
        TreeMap<Long,Student> students = new TreeMap<>();
        try {
            ArrayList<String> x = new ArrayList<>();
            Connexion co = new Connexion("ecole","root","");
            ResultSet rs = co.executeQuery("SELECT * FROM personne WHERE type = 0");
            while(rs.next())
            {
                
                Student student = new Student(rs.getLong("ID"),rs.getString("Prenom"),rs.getString("Nom"));
                Long key=student.getID();
                students.put(key,student);
            }
            for(HashMap.Entry<Long, Student> entry : students.entrySet())
            {
                System.out.println("ID: "+entry.getKey());
                entry.getValue().display();
            }
                
        
        }catch (ClassNotFoundException e) {System.err.println(e);} 
        catch (SQLException ex) {}
        
        /*Connexion testTaCo = new Connexion("ecole","root","");
        alpha = testTaCo.remplirChampsTable("personne");
        alpha.forEach((value) -> System.out.println(value));
        
        java.awt.EventQueue.invokeLater(() -> {
            new connexion().setVisible(true);
        });*/
        
    }
    
    
}
