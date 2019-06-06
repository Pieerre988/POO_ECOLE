/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;
import Model.*;
import Model.Classe;
import Model.Professor;
import Model.Report;
import Model.ReportDetail;
import Model.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author talmo
 */
public class ReportDetailDAO extends DAO<ReportDetail>{
        public ReportDetailDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(ReportDetail rd)
        {
            return false;
        }
        
        public void init(Classe c, Student s, Report r) throws SQLException
        {
            Professor Bubulle = new Professor("Jean","Bubulle","Maths");
            rset = stmt.executeQuery("SELECT db.* FROM detailbulletin db, bulletin b WHERE b.ID = "+r.getID()+" AND db.ID_bulletin = b.ID ");
            while(rset.next())
            {
                //public ReportDetail(long id, Professor p, String c)
                ReportDetail rd = new ReportDetail(rset.getLong(1), Bubulle, rset.getString(2));
                GradeDAO gDAO = new GradeDAO();
                gDAO.init(c,s,r,rd);
                
                r.getDetails().add(rd);   
            }
        }
        
        
}
