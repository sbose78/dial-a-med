package in.health.dao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class SessionUtil {

	public static void setSessionData( HttpServletRequest request, String mobile)
	{
		request.getSession(true).setAttribute("mobile", mobile );
		System.out.println(request.getParameter("From"));
	}
	
	public static String getSessionData( HttpServletRequest request, String param)
	{
		HttpSession mySession = request.getSession(false);
		if( mySession!=null){
			if( mySession.getAttribute(param)!=null)
			{
				return mySession.getAttribute(param).toString(); 
			}
			else return "GUEST";

		}
		return "GUEST";
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
