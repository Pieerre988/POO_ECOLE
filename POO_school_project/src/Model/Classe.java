/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import java.util.*;
/**
 *
 * @author talmo
 */
public class Classe {
    private String niveau, nom;
    private long ID, annee_scolaire; 
    private ArrayList<Student> students;
    private ArrayList<Professor> professors;

    public Classe(long id,long as, String n, String name)
    {
        this.ID= id;
        students=new ArrayList<>();
        professors=new ArrayList<>();
        this.niveau=n;
        this.nom=name;
        this.annee_scolaire=as;
    }
    public double getAverageYearClasse(){
        double avg=0;
        int count=0;
        for(Student e : this.getStudents()){
            avg+=e.getAverageYear();
            count++;
        }
        avg/=count;
        return avg;
    }
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public long getAnnee_scolaire() {
        return annee_scolaire;
    }

    public void setAnnee_scolaire(int annee_scolaire) {
        this.annee_scolaire = annee_scolaire;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(ArrayList<Professor> professors) {
        this.professors = professors;
    }
    
}
