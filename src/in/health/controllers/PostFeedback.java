package in.health.controllers;

import in.health.dao.FeedbackDAO;
import in.health.model.Feedback;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostFeedback
 */
public class PostFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String health_issue_id= request.getParameter("health_issue_id");
		String doctor_id= request.getParameter("doctor_id");
		String question= request.getParameter("question");
		
		
		FeedbackDAO dao = new FeedbackDAO();
		Feedback feedback= new Feedback(Integer.parseInt(health_issue_id),question,"",0,"+918884314202",doctor_id);
		
		dao.insertFeedback(feedback);
		//	Feedback feedback= new Feedback(8,"What is you bp","" ,0,"+918884314202", "sbose78@gmail.com");

		
	}

}
