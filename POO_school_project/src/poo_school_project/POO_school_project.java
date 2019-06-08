/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_school_project;
import Controler.ClasseDAO;
import view.connexion;
import java.sql.SQLException;
import java.util.ArrayList;
import view.Bulletins;
import java.sql.*;
import java.util.*;
import Model.*;
import Controler.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Pierre
 */
public class POO_school_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        /*TreeMap<Long,Student> students = new TreeMap<>();
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
        */
        
        //Création de l'élève test
        Student Eleve = new Student(2, "Adrien", "Talmont");/*
        
        //Création du bulletin test
        Report Bullet = new Report("1");
        
        //Création de 3 professeur pour 3 matières
        Professor LeCor = new Professor("Luc","Le Cor","Proba");
        Professor Mokber = new Professor("Arash", "Mokber", "TS2");
        Professor Segado = new Professor("Jean-Pierre", "Segado", "Java");
        
        //Création des 3 Detailbulletins
        ReportDetail BulletProb = new ReportDetail(LeCor, "Moyen");
        ReportDetail BulletTs = new ReportDetail(Mokber, "Très bien");
        ReportDetail BulletJava = new ReportDetail(Segado, "Mauvais");
        
        //2 Evaluation en Proba
        Grade ProbaDS1 = new Grade(10, "");
        Grade ProbaDS2 = new Grade(15, "");
        
        //2 Evaluation en TS
        Grade TSDS1 = new Grade(10, "");
        Grade TSDS2 = new Grade(20, "");
        
        //2 Evalution en Java
        Grade JavaDS1 = new Grade(5, "");
        Grade JavaDS2 = new Grade(9, "");
        
        //Ajout des Eval en Proba
        BulletProb.add(ProbaDS1);
        BulletProb.add(ProbaDS2);
        
        //Ajout des Eval en TS
        BulletTs.add(TSDS1);
        BulletTs.add(TSDS2);
        
        //Ajout des Eval en Java
        BulletJava.add(JavaDS1);
        BulletJava.add(JavaDS2);
        
        //Ajout des DetailBulletins dans le bulletin
        Bullet.add(BulletProb);
        Bullet.add(BulletTs);
        Bullet.add(BulletJava);
        */
        
        java.awt.EventQueue.invokeLater(() -> {

            try {
                new Bulletins(Eleve, 1).setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(POO_school_project.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
    }
    
    
}
