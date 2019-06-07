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
        
        public void init(Ecole e, Classe c, Student s, Report r) throws SQLException
        {
            Professor Bubulle = new Professor(1L,"Jean","Bubulle","Maths");
            rset = stmt.executeQuery("SELECT db.id, p.id, db.appreciation FROM personne p, enseignement e, bulletin b, detailbulletin db WHERE b.ID = "+r.getID()+" AND db.ID_bulletin = b.ID AND db.ID_enseignement = e.ID AND e.ID_prof = p.ID ");
            while(rset.next())
            {
                Professor prof = new Professor(1000L,"Dummy","Test","Janitor");
                for(Professor temp:e.getProfesseurs())
                {
                    if(temp.getID()==rset.getLong(2))
                        prof = temp;
                }
                //public ReportDetail(long id, Professor p, String c)
                ReportDetail rd = new ReportDetail(rset.getLong(1), prof, rset.getString(3));
                GradeDAO gDAO = new GradeDAO();
                System.out.println("BULLETIN DETAIL");
                gDAO.init(e,c,s,r,rd);
                
                r.getDetails().add(rd);   
            }
        }
        
        
}
