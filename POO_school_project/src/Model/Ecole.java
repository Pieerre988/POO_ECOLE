/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
import Model.*;
import Controler.*;
import java.sql.SQLException;

/**
 *
 * @author talmo
 */
public class Ecole {
    
    private ArrayList<Classe> classes;
    private ArrayList<Professor> professeurs;
    
    public Ecole() throws SQLException{
        this.classes=new ArrayList<>();
        this.professeurs=new ArrayList<>();
    }
    
    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }

    public ArrayList<Professor> getProfesseurs() {
        return professeurs;
    }

    public void setProfesseurs(ArrayList<Professor> professeurs) {
        this.professeurs = professeurs;
    }
}
