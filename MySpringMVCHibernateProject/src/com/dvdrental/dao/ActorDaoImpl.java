package com.dvdrental.dao;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvdrental.dto.Actor;

public class ActorDaoImpl implements ActorDao {

	static Logger logger = Logger.getLogger(ActorDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	public ActorDaoImpl() {
		super();
		logger.info("ActorDaoImpl default contructor");

	}

	@Override
	public List<Actor> listActor() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Actor> actorList = session.createQuery("from Actor order by id").list();
		session.close();
		return actorList;
	}

	@Override
	public Actor getActor(int id) {
		Session session = sessionFactory.openSession();
		Actor actor = (Actor) session.load(Actor.class, id);
		return actor;
	}

	@Override
	@Transactional
	public int addActor(Actor actor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		actor.setLastModified(new Date(Calendar.getInstance().getTimeInMillis()));
		session.saveOrUpdate(actor);
		tx.commit();
		Serializable id = session.getIdentifier(actor);
		session.close();
		return (Integer) id;
	}

	@Override
	public int deleteActor(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Actor actor = (Actor) session.load(Actor.class, id);
		session.delete(actor);
		tx.commit();
		Serializable ids = session.getIdentifier(actor);
		session.close();
		return (Integer) ids;
	}

	@Override
	public int editActor(Actor actor) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		actor.setLastModified(new Date(Calendar.getInstance().getTimeInMillis()));
		session.saveOrUpdate(actor);
		tx.commit();
		Serializable id = session.getIdentifier(actor);
		session.close();
		return (Integer) id;
	}

}
