package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
 * Servlet implementation class AddAutorisationController
 */
@WebServlet("/AddAutorisationController")
public class AddAutorisationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddAutorisationController() {
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
		String date = request.getParameter("date");
		String nbheure = request.getParameter("nbheure");
		String idEnsignant = request.getParameter("idEnsignant");
		System.out.println("IDDD " + idEnsignant);
		Enseignant e = EnseignantDao.findById(Integer.parseInt(idEnsignant));
		System.out.println("date " + date + " NBH " + nbheure + " Ensei " + e);
		Autorisation autorisation = new Autorisation(date, Integer.parseInt(nbheure), e);
		AutorisationDao.save(autorisation);
		HttpSession session = request.getSession();
		session.setAttribute("idE", idEnsignant);
		RequestDispatcher rdHelloView = getServletContext().getRequestDispatcher("/ListAutorisation.jsp");
		rdHelloView.forward(request, response);
	}

}
