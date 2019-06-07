/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import Model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author talmo
 */
public class GradeDAO extends DAO<Grade>{
        public GradeDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(Grade g)
        {
            return false;
        }
        
        public void init(Classe c, Student s, Report r, ReportDetail rd) throws SQLException
        {
            rset = stmt.executeQuery("SELECT * FROM evaluation WHERE ID_detailbulletin = "+ rd.getID());
            while(rset.next())
            {
                //private Grade(double s, String c)
                Grade g = new Grade(rset.getDouble(2),rset.getString(3));
                rd.getGrades().add(g);
            }
        }
        
        
}
