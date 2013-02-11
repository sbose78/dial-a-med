package in.health.dao;

import in.health.cao.SMSUtil;
import in.health.model.Feedback;
import in.health.model.HealthIssue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FeedbackDAO {

	/**
	 * @param args
	 */
	

	public String insertFeedback(Feedback feedback){
		
String updateQuery="";
int feedback_issue_id=0;
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

//          	public HealthIssue(	int health_issue_id,String recording_url,String mobile,String solution,int solved){                
                
                String queryString = "insert into health.feedback(doctor_id,question,health_issue_id,patient_mobile_number,answer) values(?,?,?,?,?)";
             //   String queryString = "insert into user(mobile,gender,dob,location,language) values('a','b','c','d','e')";
                
         //       pstatement = conn.prepareStatement(queryString); 
                pstatement = conn.prepareStatement(queryString, pstatement.RETURN_GENERATED_KEYS);


                pstatement.setString(1, feedback.getDoctor_id());
                pstatement.setString(2, feedback.getQuestion());
                pstatement.setInt(3, feedback.getHealth_issue_id());
                pstatement.setString(4, feedback.getPatient_mobile_number());
                pstatement.setString(5, "NO_ANSWER");
                
                System.out.println(pstatement);
                            
                 updateQuery = pstatement.executeUpdate()+"";
                
                 ResultSet my_keys = pstatement.getGeneratedKeys();
                 while(my_keys.next())
                 {
                 	
                	 feedback_issue_id= my_keys.getInt(1);
                	 
                 	
                 }
                 
                 SMSUtil.sendSMS("+918884314202", "Feedback ID "+feedback_issue_id+"One of our doctors asked you "+feedback.getQuestion());
                 
                 
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	System.out.println(e.getMessage());
        	return -1+"";
        	
        }
		
		return feedback_issue_id+"";
		
		
	}
	
	
	// insert answer URL
	public static String updateFeedback(int feedback_id , String answer){
		
		String updateQuery="0";
//		int row_key=0;
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

                
                
                String queryString = "UPDATE feedback SET answer = ? where feedback_id = ? ";
                pstatement = conn.prepareStatement(queryString);//, pstatement.RETURN_GENERATED_KEYS);

        //        pstatement = conn.prepareStatement(queryString); 
                
                   
                pstatement.setString(1, answer);
                //pstatement.setString(2,value);
                pstatement.setInt(2,feedback_id);
                
                System.out.println(pstatement);
                
                 updateQuery = pstatement.executeUpdate()+"";
                
                 SMSUtil.sendSMS("+918884314202", "Thank you for your inputs on FEEDBACK ID: "+feedback_id);
                 
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return(e.getMessage());
        	
        	
           // return e.toString();
        }
		
		return updateQuery;		
	}
	
	public static ArrayList<Feedback> getAllFeedbacks(){
		

        ArrayList<Feedback> lhr = new ArrayList<Feedback>();
        
        Connection con;//=DbCon.getDbConnection();
     
        try{
            
                con=DbCon.getDbConnection();

                ResultSet rst=null;
                Statement stmt=null;

                stmt=con.createStatement();
                rst=stmt.executeQuery("select * from feedback");
                while(rst.next()){

                	Feedback feedback= new Feedback(rst.getInt("health_issue_id"),rst.getString("question"),rst.getString("answer"),rst.getInt("feedback_id"),rst.getString("patient_mobile_number"),rst.getString("doctor_id"));
                	
                	

                   lhr.add(feedback);
                }
                DbCon.closeConnection(con);
        }
        
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
	
	return lhr;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		FeedbackDAO dao = new FeedbackDAO();
//int health_issue_id, String question, String answer,int feedback_id, String patient_mobile_number, String doctor_id		
		Feedback feedback= new Feedback(8,"What is you bp","" ,0,"+918884314202", "sbose78@gmail.com");
		String feedback_id= dao.insertFeedback(feedback);
		
		
		FeedbackDAO.updateFeedback(Integer.parseInt(feedback_id),"+918884314202");
		*/

	}

}
