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
public class Ecole {
    private TreeMap<Integer,Report> tmreport;
    private TreeMap<Integer,ReportDetail> tmreportdetail;
    private TreeMap<Integer,Grade> tmgrade;
    private TreeMap<Integer,Professor> tmprofessor;
    private TreeMap<Integer,Report> tmstudent;

    public Ecole(TreeMap<Integer, Report> tmreport, TreeMap<Integer, ReportDetail> tmreportdetail, TreeMap<Integer, Grade> tmgrade, TreeMap<Integer, Professor> tmprofessor, TreeMap<Integer, Report> tmstudent) {
        this.tmreport = tmreport;
        this.tmreportdetail = tmreportdetail;
        this.tmgrade = tmgrade;
        this.tmprofessor = tmprofessor;
        this.tmstudent = tmstudent;
    }

    public TreeMap<Integer, Report> getTmreport() {
        return tmreport;
    }

    public void setTmreport(TreeMap<Integer, Report> tmreport) {
        this.tmreport = tmreport;
    }

    public TreeMap<Integer, ReportDetail> getTmreportdetail() {
        return tmreportdetail;
    }

    public void setTmreportdetail(TreeMap<Integer, ReportDetail> tmreportdetail) {
        this.tmreportdetail = tmreportdetail;
    }

    public TreeMap<Integer, Grade> getTmgrade() {
        return tmgrade;
    }

    public void setTmgrade(TreeMap<Integer, Grade> tmgrade) {
        this.tmgrade = tmgrade;
    }

    public TreeMap<Integer, Professor> getTmprofessor() {
        return tmprofessor;
    }

    public void setTmprofessor(TreeMap<Integer, Professor> tmprofessor) {
        this.tmprofessor = tmprofessor;
    }

    public TreeMap<Integer, Report> getTmstudent() {
        return tmstudent;
    }

    public void setTmstudent(TreeMap<Integer, Report> tmstudent) {
        this.tmstudent = tmstudent;
    }
    
}
