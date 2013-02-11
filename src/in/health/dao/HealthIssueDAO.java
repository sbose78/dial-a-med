package in.health.dao;

import in.health.cao.SMSUtil;
import in.health.model.HealthIssue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class HealthIssueDAO {
	
	public static String insertHealthIssue(String mobile, String rec_url){
		String updateQuery="";
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

//          	public HealthIssue(	int health_issue_id,String recording_url,String mobile,String solution,int solved){                
                
                String queryString = "insert into health.health_issue(recording_url,mobile,solution) values(?,?,'NOT_SOLVED')";
             //   String queryString = "insert into user(mobile,gender,dob,location,language) values('a','b','c','d','e')";
                
         //       pstatement = conn.prepareStatement(queryString); 
                pstatement = conn.prepareStatement(queryString, pstatement.RETURN_GENERATED_KEYS);


                pstatement.setString(1, rec_url);
                pstatement.setString(2, mobile);
                
                System.out.println(pstatement);
                            
                 updateQuery = pstatement.executeUpdate()+"";
                
                 ResultSet my_keys = pstatement.getGeneratedKeys();
                 int health_issue_id=0;
                 while(my_keys.next())
                 {
                 	
                 	health_issue_id= my_keys.getInt(1);
                 	
                 }
                 
                 SMSUtil.sendSMS("+918884314202", "Your health issue ID is HI-"+health_issue_id);
                 
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return e.getMessage();
        	
        }
		return updateQuery;
		
	}
	
	
	public static ArrayList<HealthIssue> getAllRecords(){
		
		 System.out.println("testing");
    	 
	    	
	        ArrayList<HealthIssue> lhr = new ArrayList<HealthIssue>();
	        
	        Connection con;//=DbCon.getDbConnection();
	     
	        try{
	            
	                con=DbCon.getDbConnection();

	                ResultSet rst=null;
	                Statement stmt=null;

	                stmt=con.createStatement();
	                rst=stmt.executeQuery("select * from health_issue");
	                while(rst.next()){

//	int health_issue_id,String recording_url,String mobile,String solution,int solved){
	                    
	                    HealthIssue hi=new HealthIssue(rst.getInt("health_issue_id"),rst.getString("recording_url"), rst.getString("mobile"),rst.getString("solution"),rst.getInt("solved"));
	                    lhr.add(hi);
	                }
	                DbCon.closeConnection(con);
	        }
	        
	        catch(Exception e)
	        {
	            System.out.println(e.toString());
	        }
		
		return lhr;
	}
	
	public static String updateSolution(String solution, int health_issue_id){
		String updateQuery="0";
//		int row_key=0;
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

                
                
                String queryString = "UPDATE health_issue SET solved = 1 , solution = ? where health_issue_id = ? ";
                pstatement = conn.prepareStatement(queryString);//, pstatement.RETURN_GENERATED_KEYS);

        //        pstatement = conn.prepareStatement(queryString); 
                
                   
                pstatement.setString(1,solution);
                //pstatement.setString(2,value);
                pstatement.setInt(2,health_issue_id);
                
                System.out.println(pstatement);
                
                 updateQuery = pstatement.executeUpdate()+"";
                
                 SMSUtil.sendSMS("+918884314202", "For health issue HI-"+health_issue_id+" Our doctors have decided the following remedy for your health issue :"+solution);
                 
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return(e.getMessage());
        	
        	
           // return e.toString();
        }
		
		return updateQuery;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		//System.out.println(insertHealthIssue("+918884314202", "some_url"));
		
		/*
		ArrayList<HealthIssue> ahi = getAllRecords();
		for ( HealthIssue h : ahi  ){
			
			System.out.println(h);
		}*/

	}

}
