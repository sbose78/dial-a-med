package in.health.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import in.health.model.*;

public class OpinionDAO {
	
	public String insertOpinion(Opinion opinion){
		String updateQuery="";
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

//          	public HealthIssue(	int health_issue_id,String recording_url,String mobile,String solution,int solved){                
                
                String queryString = "insert into opinion(opinion,doctor_id,health_issue_id) values(?,?,?)";
             //   String queryString = "insert into user(mobile,gender,dob,location,language) values('a','b','c','d','e')";
                
                pstatement = conn.prepareStatement(queryString); 

                pstatement.setString(1, opinion.getOpinion());
                pstatement.setString(2, opinion.getDoctor_id());
                pstatement.setInt(3, opinion.getHealth_issue_id());
                
                
                System.out.println(pstatement);
                            
                 updateQuery = pstatement.executeUpdate()+"";
                
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return e.getMessage();
        	
        }
		return updateQuery;
		
	}
	
	public static ArrayList<Opinion> getAllRecords(int health_issue_id){
		
		 System.out.println("testing");
   	 
	    	
	        ArrayList<Opinion> lhr = new ArrayList<Opinion>();
	        
	        Connection con;//=DbCon.getDbConnection();
	     
	        try{
	            
	                con=DbCon.getDbConnection();

	                ResultSet rst=null;
	                Statement stmt=null;

	                stmt=con.createStatement();
	                rst=stmt.executeQuery("select * from opinion where health_issue_id = "+health_issue_id);
	                while(rst.next()){

//	int health_issue_id,String recording_url,String mobile,String solution,int solved){
	                	int opinion_id = rst.getInt("opinion_id");
	                	
	                	String opinion = rst.getString("opinion");
	                	String doctor_id = rst.getString("doctor_id");
	                	Opinion my_opinion=new Opinion(opinion_id, health_issue_id, opinion, doctor_id);
	                	lhr.add(my_opinion);
	                }
	                DbCon.closeConnection(con);
	        }
	        
	        catch(Exception e)
	        {
	            System.out.println(e.toString());
	        }
		
		return lhr;
	}
	
	public static void main(String args[]){
		/*
		Opinion opinion=new Opinion(0, 2, "He will get better", "sbose78@gmail.com");
		OpinionDAO dao = new OpinionDAO();
		System.out.println(dao.insertOpinion(opinion));
		*/
		
		ArrayList<Opinion> opinions = getAllRecords(2);
		for(Opinion opinion : opinions){
			System.out.println(opinion.getOpinion_id()+","+opinion.getDoctor_id()+","+opinion.getHealth_issue_id());
		}
	}

}
