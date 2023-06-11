package tn.iit.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tn.iit.dao.UtilisateurDao;
import tn.iit.model.Utilisateur;

/**
 * Servlet implementation class UtilisateurDao
 */
@WebServlet("/UtilisateurController")
public class UtilisateurController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UtilisateurController() {
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
		// TODO Auto-generated method stub
		System.out.println("here");
		String mail= request.getParameter("user_mail");
		String password= request.getParameter("pswd");
		System.out.println(mail);
		System.out.println(password);
		RequestDispatcher rdLoginView = getServletContext().getRequestDispatcher("/Login.jsp");
		RequestDispatcher rdHelloView = getServletContext().getRequestDispatcher("/List.jsp");
		Utilisateur u=UtilisateurDao.findByLoginPwd(mail, password);
		if(u != null) {
			HttpSession session = request.getSession();
			session.setAttribute("connect", "connect");
			rdHelloView.forward(request, response);
		}else {
			request.setAttribute("erreur", "Verifier vos donnée");
			rdLoginView.forward(request, response);
		}
	}

}
