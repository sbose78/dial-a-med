package in.health.controllers;

import in.health.dao.OpinionDAO;
import in.health.model.Opinion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostOpinion
 */
public class PostOpinion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostOpinion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String opinion = request.getParameter("opinion");
		String health_issue_id=request.getParameter("health_issue_id");
		String doctor_id=request.getParameter("doctor_id");
		
		Opinion opinion_obj = new Opinion(0, Integer.parseInt(health_issue_id), opinion, doctor_id);
		OpinionDAO dao = new OpinionDAO();
		System.out.println(dao.insertOpinion(opinion_obj));
		
	}

}
