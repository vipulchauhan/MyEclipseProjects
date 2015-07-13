package com.dvdrental.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.dvdrental.dao.ActorDao;
import com.dvdrental.dto.Actor;

public class ActorServiceImpl implements ActorService {
	@Autowired
	private ActorDao actorDao;

	private static Logger logger = Logger.getLogger(ActorServiceImpl.class);

	public ActorServiceImpl(ActorDao actorDao) {
		super();
		logger.info("ActorServiceImpl contructor setting actorDao :" + actorDao);
		this.actorDao = actorDao;
	}

	public ActorServiceImpl() {
		super();
		logger.info("ActorServiceImpl default contructor");
	}

	public ActorDao getActorDao() {
		logger.info("getActorDao");
		return actorDao;
	}

	public void setActorDao(ActorDao actorDao) {
		logger.info("setActorDao");
		this.actorDao = actorDao;
	}

	@Override
	public List<Actor> listActor() {

		return actorDao.listActor();
	}

	@Override
	public Actor getActor(int id) {

		return actorDao.getActor(id);
	}

	@Override
	public boolean addActor(Actor actor) {

		return actorDao.addActor(actor);
	}

	@Override
	public boolean deleteActor(int id) {

		return actorDao.deleteActor(id);
	}

	@Override
	public boolean editActor(Actor actor) {

		return actorDao.editActor(actor);
	}

}
