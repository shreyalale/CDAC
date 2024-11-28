package com.cdac.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cdac.pojos.Team;
import com.cdac.utils.HibernateUtils;

import java.util.List;

public class TeamDAOImpl implements TeamDAO {

    @Override
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

    @Override
    public Team getTeamById(Long id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Team.class, id);
        }
    }

    @Override
    public List<Team> getAllTeams() {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Team", Team.class).list();
        }
    }

    // JPQL Implementation

    @Override
    public List<Team> findTeamsByCriteria(double battingAvg, int maxAge) {
        String jpql = "SELECT t FROM Team t WHERE t.battingAvg > :battingAvg AND t.maxAge < :maxAge";
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(jpql, Team.class)
                          .setParameter("battingAvg", battingAvg)
                          .setParameter("maxAge", maxAge)
                          .getResultList();
        }
    }

    @Override
    public List<Object[]> getAllTeamDetails() {
        String jpql = "SELECT t.abbreviation, t.owner, t.maxAge FROM Team t";
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery(jpql, Object[].class).getResultList();
        }
    }

    @Override
    public int updateMaxAge(String teamName, int newAge) {
        String jpql = "UPDATE Team t SET t.maxAge = :newAge WHERE t.name = :teamName";
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            int result = session.createQuery(jpql)
                                .setParameter("newAge", newAge)
                                .setParameter("teamName", teamName)
                                .executeUpdate();
            tx.commit();
            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public int deleteTeamByAbbreviation(String abbreviation) {
        String jpql = "DELETE FROM Team t WHERE t.abbreviation = :abbr";
        Transaction tx = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            int result = session.createQuery(jpql)
                                .setParameter("abbr", abbreviation)
                                .executeUpdate();
            tx.commit();
            return result;
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }
}
