/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controler.ProfessorDAO;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author talmo
 */
public class Professor {
    private long ID;
    private String fname, lname, matter;
    private ArrayList<Classe> classes;
    
    public Professor(Long id, String fn,String ln,String m)
    {
        this.ID = id;
        this.fname = fn;
        this.lname = ln;
        this.matter = m;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getMatter() {
        return matter;
    }

    public void setMatter(String matter) {
        this.matter = matter;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<Classe> classes) {
        this.classes = classes;
    }
    
    public void updateName(String fn, String ln) throws SQLException
    {
        this.fname=fn;
        this.lname=ln;
        ProfessorDAO pDAO = new ProfessorDAO(); 
        pDAO.updateNomBDD(this, fn, ln);
    }
    
}
