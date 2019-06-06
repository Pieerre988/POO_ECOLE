/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package poo_school_project;
import view.connexion;
import connexion.*;
import java.sql.SQLException;
import java.util.ArrayList;
import view.Bulletins;
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
        
        Connexion testTaCo = new Connexion("ecole","root","");
        alpha = testTaCo.remplirChampsTable("personne");
        alpha.forEach((value) -> System.out.println(value));
        
        java.awt.EventQueue.invokeLater(() -> {
            new Bulletins().setVisible(true);
        });
        
    }
    
    
}
