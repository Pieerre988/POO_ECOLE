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
public class Report {
    private String comment;
    private long ID,trimester;
    private ArrayList<ReportDetail> details;
    private Report(){}
    
    public Report(long id, String c, long t)
    {
        this.ID=id;
        this.comment=c;
        this.trimester=t;
        this.details=new ArrayList<>();
    }
    
    public void add(ReportDetail rd)
    {
        this.details.add(rd);
    }
    public double getMedium()
    {
        double m=0;
        for(ReportDetail temp: details)
            m+=temp.getMedium();
        return m/details.size();
    }
    public void display()
    {
        for(ReportDetail temp: details)
            temp.display();
        System.out.println("\nTrim. medium: "+this.getMedium()+"\nTrim. comment: "+this.comment);
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getTrimester() {
        return trimester;
    }

    public void setTrimester(long trimester) {
        this.trimester = trimester;
    }

    public ArrayList<ReportDetail> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<ReportDetail> details) {
        this.details = details;
    }
    
}
