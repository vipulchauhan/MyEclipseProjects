package com.dvdrental.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dvdrental.dto.Actor;

public class DataProvider {
	private static List<Actor> actorList = new ArrayList<Actor>();

	static {
		for (int i = 0; i < 100; i++) {
			actorList
					.add(new Actor(i, "A" + i, "Z" + i, new Date().toString()));
		}
	}

	public static List<Actor> getActorList() {
		return actorList;
	}

	public static void setActorList(List<Actor> actorList) {
		DataProvider.actorList = actorList;

	}

}
