package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.AutorisationDao;
import tn.iit.dao.EnseignantDao;
import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class UpdateAutorisationController
 */
@WebServlet("/UpdateAutorisationController")
public class UpdateAutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAutorisationController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rdListUserView = getServletContext().getRequestDispatcher("/ListAutorisation.jsp");
	    String index= request.getParameter("pos");
	    String date = request.getParameter("date");
		String nbheure = request.getParameter("nbheure");
		String idE = request.getParameter("IdE");
	    int id=Integer.parseInt(index);
		Autorisation a=AutorisationDao.findBytId(id);
	    a.setDate(date);
	    a.setNbheure(Integer.parseInt(nbheure));  
	    System.out.println("autorisation after update ::: "+a.toString());
	    AutorisationDao.update(a);
		HttpSession session = request.getSession();
		session.setAttribute("idE", idE);
	    rdListUserView.forward(request, response);
	}

}
