/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Controler.ProfessorDAO;
import Controler.StudentDAO;
import Model.Report;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author talmo
 */
public class Student {
    private long ID;
    private String fname, lname;
    private ArrayList<Report> reports; //map<int,Report>
    
    public Student(){}
    
    public Student(long ID, String ln, String fn)
    {
        this.ID=ID;
        this.fname=fn;
        this.lname=ln;
        reports=new ArrayList<>();
    }
    
    public double getAverageYear(){
        double avg=0;
        int count=0;
        for(Report r : this.getReports()){
            avg+=r.getMedium();
            count++;
        }
        avg/=count;
        return avg;
    }
    
    public void add(Report r)
    {
        this.reports.add(r);
    }
    public void display()
    {
        int i=1;
        System.out.println("First name: "+this.fname+"\nLast name: "+this.lname+"\n\n");
        for(Report temp:reports)
        {
            System.out.println("Trim. "+i+"\n- - - - - -");
            temp.display();
            i++;
        }
            
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

    public ArrayList<Report> getReports() {
        return reports;
    }

    public void setReports(ArrayList<Report> reports) {
        this.reports = reports;
    }
    
     public void updateName(String fn, String ln) throws SQLException
    {
        this.fname=fn;
        this.lname=ln;
        StudentDAO pDAO = new StudentDAO(); 
        pDAO.updateNomBDD(this, fn, ln);
    }
    
}
