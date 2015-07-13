package com.dvdrental.services;

import java.util.List;

import com.dvdrental.dto.Actor;

public interface ActorService {
	public List<Actor> listActor();
	public Actor getActor(int id);
	public boolean addActor(Actor actor);
	public boolean deleteActor(int id);
	public boolean editActor(Actor actor);
}
