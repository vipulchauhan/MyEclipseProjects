package com.dvdrental.dao;

import java.util.List;

import com.dvdrental.dto.Actor;

public interface ActorDao {

	public List<Actor> listActor();
	public Actor getActor(int id);
	public int addActor(Actor actor);
	public int deleteActor(int id);
	public int editActor(Actor actor);
}
