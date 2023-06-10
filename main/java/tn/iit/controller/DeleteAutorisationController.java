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

/**
 * Servlet implementation class DeleteAutorisationController
 */
@WebServlet("/DeleteAutorisationController")
public class DeleteAutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAutorisationController() {
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
System.out.println("yooooooooo");
		RequestDispatcher rdListUserView = getServletContext().getRequestDispatcher("/ListAutorisation.jsp");
	    String index= request.getParameter("pos");
	    String idE = request.getParameter("IdE");
	    int id=Integer.parseInt(index);
	    AutorisationDao.delete(id);
		HttpSession session = request.getSession();
		session.setAttribute("idE", idE);
	    rdListUserView.forward(request, response);
	    System.out.println("yooooooooo");
	}

}
