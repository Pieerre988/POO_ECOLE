/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_school_project;
import view.*;
import java.sql.*;
import java.util.*;
import Model.*;
import view.studentGraph;
import Controler.*;
/**
 *
 * @author Pierre
 */
public class POO_school_project {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ArrayList<Classe> a = new ArrayList<>();
        ClasseDAO c = new ClasseDAO();
        c.init(a);
       for(Classe temp: a)
            System.out.println("Niveau: "+temp.getNiveau()+"\nNom: "+temp.getNom());
        java.awt.EventQueue.invokeLater(() -> {
           new connexion().setVisible(true);
        });
        
    }
    
    
}
