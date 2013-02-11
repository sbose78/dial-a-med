package in.health.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import in.health.model.User;

public class UserDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user= new User("+918884314202","","","","","");
		UserDAO dao = new UserDAO();
		System.out.println(dao.insertPatient(user));
		
		System.out.println(dao.updatePatient(user.getMobile(), "location", "kolkata"));
	

	}
	public static boolean isRegistered(String number){
		 Connection con = null;

        try{
            
                con=DbCon.getDbConnection();

                ResultSet rst=null;
                Statement stmt=null;

                stmt=con.createStatement();
                rst=stmt.executeQuery("select * from health.user where mobile = "+number);
                while(rst.next()){
                	return true;
                }
                DbCon.closeConnection(con);
        }
        
        
        
        catch(Exception e)
        {
            System.out.println(e.toString());
        }
        
        
		
		return false;
		
	}
	
	/*
	 * 
	 * 	String mobile;
	String gender;
	String dob;
	String location;
	String language;
	String userID;

	 * 
	 * 
	 */
	public String updatePatient(String mobile, String column, String value){
		
		String updateQuery="0";
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

                
                
                String queryString = "UPDATE user SET "+column+" = ? where mobile = ? ";  
                pstatement = conn.prepareStatement(queryString); 
                
                   
                pstatement.setString(1,value);
                //pstatement.setString(2,value);
                pstatement.setString(2,mobile);
                
                System.out.println(pstatement);
                
                 updateQuery = pstatement.executeUpdate()+"";
                
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return(e.getMessage());
        	
        	
           // return e.toString();
        }
		
		return updateQuery;
		
	}
	
public String insertPatient(User user){
		
		String updateQuery="";
		
		try            
        {
              
                Connection conn= DbCon.getDbConnection();
                PreparedStatement pstatement = null;

                
                
                String queryString = "insert into health.user(mobile,gender,dob,location,language) values(?,?,?,?,?)";
             //   String queryString = "insert into user(mobile,gender,dob,location,language) values('a','b','c','d','e')";
                
                pstatement = conn.prepareStatement(queryString); 
                
                   
                pstatement.setString(1,user.getMobile()); 
                pstatement.setString(2,user.getGender());
                pstatement.setString(3,user.getDob());
                pstatement.setString(4,user.getLocation());
                pstatement.setString(5,user.getLanguage());




                
                 updateQuery = pstatement.executeUpdate()+"";
                
                DbCon.closeConnection(conn, pstatement);
            
        }
        catch(Exception e)
        {
        	return e.getMessage();
        	
        	
           // return e.toString();
        }
		
		return updateQuery;
		
	}
	
	public User getUserMobile(String mobile )
	{
		 Connection con = null;
		 User user= null;

	        try{
	            
	                con=DbCon.getDbConnection();

	                ResultSet rst=null;
	                Statement stmt=null;

	                stmt=con.createStatement();
	                rst=stmt.executeQuery("select * from health.user where mobile = "+mobile);
	                
	                while(rst.next()){
	                	
//String mobile,String gender,String dob,	String location,String language,String userID	                	
	                	 user = new User(rst.getString("mobile"),rst.getString("gender"),rst.getString("dob"),rst.getString("location"),"",rst.getInt("user_id")+"");
	                	 break;
	                }
	                DbCon.closeConnection(con);
	              
	        }
	        
	        
	        
	        catch(Exception e)
	        {
	            System.out.println(e.toString());
	        }
	        
	        
			
			return user;
	
	}
	
	
	

}
