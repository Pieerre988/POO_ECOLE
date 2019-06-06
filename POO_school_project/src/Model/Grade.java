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
    public double score;
    public String comment;
    public Grade(){}
    public Grade(double s, String c)
    {
        this.score=s;
        this.comment=c;
    }
    public void display()
    {
        System.out.println(this.score+" Comment: "+this.comment);
    }
}
