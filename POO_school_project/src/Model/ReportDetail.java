/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;
import Model.Professor;
import Model.Grade;
import java.util.*;

/**
 *
 * @author talmo
 */
public class ReportDetail {
    public ArrayList<Grade> grades;
    public String comment;
    public Professor professor;
    public ReportDetail(Professor p, String c)
    {
        this.comment=c;
        this.professor=p;
        this.grades = new ArrayList<>();
    }   
    public ReportDetail(){}
    public double getMedium()
    {
        double m=0;
        for(Grade temp: grades)
            m+=temp.score;
        return m/grades.size();
    }
    public void add(Grade g)
    {
        this.grades.add(g);
    }
    public void display()
    {
        System.out.println("----------------\nProfessor: "+this.professor.lname+" ("+this.professor.matter+")");
        for(Grade temp: grades)
            temp.display();
        System.out.println("Moyenne: "+this.getMedium()+"\nOverall comment: "+this.comment);
    }
}
