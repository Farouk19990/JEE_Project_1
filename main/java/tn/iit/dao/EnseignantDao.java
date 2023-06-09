package tn.iit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import tn.iit.model.Enseignant;
import tn.iit.utils.HibernateUtil;

public class EnseignantDao {

	public static void save(Enseignant u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.persist(u);
		trx.commit();
	}

	public static void update(Enseignant u) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.update(u);
		trx.commit();
	}

	public static void delete(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction trx = session.beginTransaction();
		session.delete(session.get(Enseignant.class, id));
		trx.commit();
	}

	public static Enseignant findById(int id) {
		String queryStr = "From Enseignant e where e.id=?0";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr);
		query.setParameter(1, id);
		List<Enseignant> l = query.getResultList();
		if (l.isEmpty()) {
			return null;
		} else {
			return l.get(0);
		}
	}

	public static List<Enseignant> getAll() {
		String queryStr = "From Enseignant u";
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery(queryStr);
		return query.getResultList();
	}
}
