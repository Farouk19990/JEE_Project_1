package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.EnseignantDao;
import tn.iit.dao.UtilisateurDao;
import tn.iit.model.Enseignant;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
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
		RequestDispatcher rdListUserView = getServletContext().getRequestDispatcher("/List.jsp");
	    String index= request.getParameter("pos");
	    String name = request.getParameter("name");
		String prenom = request.getParameter("prenom");
		String mail = request.getParameter("mail");
		String nbheure = request.getParameter("nbheure");
	    System.out.println("index "+index);
	    HttpSession session =request.getSession();
	    int id=Integer.parseInt(index);
		Enseignant u=EnseignantDao.findById(id);
	    u.setName(name);
	    u.setPrenom(prenom);
	    u.setMail(mail);
	    u.setNbheure(Integer.parseInt(nbheure));  
	    System.out.println("user after update ::: "+u.toString());
	    EnseignantDao.update(u);
	    rdListUserView.forward(request, response);
	}

}
