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
public class ReportDAO extends DAO<Report>{
        public ReportDAO() throws SQLException
        {
            super();
        }
        
        @Override
        public boolean create(Report r)
        {
            return false;
        }
        
        public void init(Ecole e, Classe c, Student s) throws SQLException
        {
            rset = stmt.executeQuery("SELECT b.* FROM bulletin b, inscription i WHERE i.ID_classe = "+c.getID()+" AND b.ID_inscription = i.ID");
            while(rset.next())
            {
                //private Report(String c, long t)
                Report r = new Report(rset.getLong(1), rset.getString(2), rset.getLong(3));
                ReportDetailDAO rdDAO = new ReportDetailDAO();
                System.out.println("BULLETIN");
                rdDAO.init(e,c,s,r);
                s.getReports().add(r);   
            }
        }
        
        
}
