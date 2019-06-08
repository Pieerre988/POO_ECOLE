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
    private long ID;
    private ArrayList<Grade> grades;
    private String comment;
    private Professor professor;
    
    public ReportDetail(long id, Professor p, String c)
    {
        this.ID=id;
        this.comment=c;
        this.professor=p;
        this.grades = new ArrayList<>();
    }   
    public ReportDetail(){}
    public double getMedium()
    {
        double m=0;
        for(Grade temp: grades)
            m+=temp.getScore();
        return m/grades.size();
    }
    public void add(Grade g)
    {
        this.grades.add(g);
    }
    public void display()
    {
        System.out.println("----------------\nProfessor: "+this.professor.getLname()+" ("+this.getProfessor().getMatter()+")");
        for(Grade temp: grades)
            temp.display();
        System.out.println("Moyenne: "+this.getMedium()+"\nOverall comment: "+this.comment);
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public ArrayList<Grade> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Grade> grades) {
        this.grades = grades;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
}
