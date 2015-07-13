package com.dvdrental.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.dvdrental.dto.Actor;

public class ActorMapper implements RowMapper<Actor> {

	@Override
	public Actor mapRow(ResultSet rs, int arg1) throws SQLException {
		Actor actor = new Actor();

		actor.setId(rs.getInt("actor_id"));
		actor.setFirstName(rs.getString("first_name"));
		actor.setLastName(rs.getString("last_name"));
		actor.setLastModified(rs.getString("last_update"));
		return actor;

	}

}
