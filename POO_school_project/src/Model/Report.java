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
    private ArrayList<ReportDetail> details;
    private Report(){}
    private Report(String c)
    {
        this.comment=c;
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
}
