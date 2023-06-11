package tn.iit.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

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
		RequestDispatcher rdListAutView = getServletContext().getRequestDispatcher("/ListAutorisation.jsp");
		RequestDispatcher rdAddAutView = getServletContext().getRequestDispatcher("/AddAutorisation.jsp");
		String date = request.getParameter("date");
		String nbheure = request.getParameter("nbheure");
		String idEnsignant = request.getParameter("idEnsignant");
		System.out.println("IDDD " + idEnsignant);
		Enseignant e = EnseignantDao.findById(Integer.parseInt(idEnsignant));
		List<Autorisation> l=AutorisationDao.findByEnseignantId(Integer.parseInt(idEnsignant));
		int nbh_e=Integer.parseInt(nbheure);
		int total=0;
		for(Autorisation a:l) {
			total+=a.getNbheure();
		}
		nbh_e+=total;
		System.out.println("nb heure deja effectue "+nbh_e);
		if(nbh_e<e.getNbheure()) {
			System.out.println("date " + date + " NBH " + nbheure + " Ensei " + e);
			Autorisation autorisation = new Autorisation(date, Integer.parseInt(nbheure), e);
			AutorisationDao.save(autorisation);
			HttpSession session = request.getSession();
			session.setAttribute("idE", idEnsignant);
			rdListAutView.forward(request, response);
		}else {
			int nh_remain=e.getNbheure()-total;
			String remain_msg=e.getName()+" a encore juste "+nh_remain+" heures.";
			request.setAttribute("remain", remain_msg);
			rdAddAutView.forward(request, response);
		}
		
	}

}
