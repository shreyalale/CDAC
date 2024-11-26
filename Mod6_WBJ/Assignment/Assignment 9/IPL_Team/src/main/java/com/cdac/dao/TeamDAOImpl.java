package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cdac.pojos.Team;
import com.cdac.utils.HibernateUtils;

import java.util.List;

public class TeamDAOImpl implements TeamDAO {
	public void addTeam(Team team) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.save(team);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) transaction.rollback();
			e.printStackTrace();
		}
	}

	public Team getTeamById(Long id) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			return session.get(Team.class, id);
		}

	}

	public List<Team> getAllTeams() {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			return session.createQuery("from Team", Team.class).list();

		}
	}
}
