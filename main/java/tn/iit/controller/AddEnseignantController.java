package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tn.iit.dao.EnseignantDao;
import tn.iit.dao.UtilisateurDao;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class AddEnseignantController
 */
@WebServlet("/AddEnseignantController")
public class AddEnseignantController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddEnseignantController() {
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
		ServletContext servletContext = getServletContext();
		String name = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String nbheure = request.getParameter("nbheure");
		Enseignant enseignant = new Enseignant(name, prenom,mail,Integer.parseInt(nbheure));
		EnseignantDao.save(enseignant);
	    RequestDispatcher rdHelloView = getServletContext().getRequestDispatcher("/List.jsp");	 
	    rdHelloView.forward(request, response);
	}

}
