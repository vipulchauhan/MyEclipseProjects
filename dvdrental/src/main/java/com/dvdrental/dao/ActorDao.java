package com.dvdrental.dao;

import java.util.List;

import com.dvdrental.dto.Actor;

public interface ActorDao {

	public List<Actor> listActor();
	public Actor getActor(int id);
	public boolean addActor(Actor actor);
	public boolean deleteActor(int id);
	public boolean editActor(Actor actor);
}
