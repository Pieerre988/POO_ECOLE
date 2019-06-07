/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author talmo
 */
public class Grade {
    private double score;
    private String comment;
    private Grade(){}
    
    public Grade(double s, String c)
    {
        this.score=s;
        this.comment=c;
    }
    public void display()
    {
        System.out.println(this.score+" Comment: "+this.comment);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
}
