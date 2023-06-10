package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.model.Autorisation;
import tn.iit.model.Enseignant;
import tn.iit.model.Autorisation;
import tn.iit.utils.HibernateUtil;

public class AutorisationDao {
	public static void save(Autorisation a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(a);
		trx.commit();
	}

	public static void update(Autorisation a) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.update(a);
		trx.commit();
	}


	public static List<Autorisation> findByEnseignantId(int id) {
		String queryStr = "From Autorisation a where a.ensignant.id=?0";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr);
		query.setParameter(0, id);
		List<Autorisation> l = query.getResultList();
		System.out.println(l);
		return l;

	}
	public static Autorisation findBytId(int id) {
		String queryStr = "From Autorisation a where a.id=?0";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr);
		query.setParameter(0, id);
		List<Autorisation> l = query.getResultList();
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}

	}
	public static void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.delete(session.get(Autorisation.class, id));
		trx.commit();
	}
}
