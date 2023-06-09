package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import tn.iit.model.Utilisateur;
import tn.iit.utils.HibernateUtil;

public class UtilisateurDao {

	public static Utilisateur findByLoginPwd(String login, String password) {
		String queryStr = "From Utilisateur u where u.login=?0 and u.password=?1";
		System.out.println("qqq "+queryStr);
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr);
		query.setParameter(0, login).setParameter(1, password);
		List<Utilisateur> l = query.getResultList();
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

}
