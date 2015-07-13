package com.dvdrental.dao;

import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.dvdrental.dto.Actor;
import com.dvdrental.mapper.ActorMapper;
import com.dvdrental.sqls.MySQLs;

public class ActorDaoImpl implements ActorDao {

	static Logger logger = Logger.getLogger(ActorDaoImpl.class);

	@Autowired
	private DataSource dataSource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public ActorDaoImpl() {
		super();
		logger.info("ActorDaoImpl default contructor");

	}

	public ActorDaoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		super();
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;

		logger.info("Datasource and jdbcTemplate set");
		logger.info(dataSource);
		logger.info(jdbcTemplate);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public DataSource getDataSource() {
		logger.info("getDataSource");
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		logger.info("setDataSource");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	@Override
	public List<Actor> listActor() {
		String SQL = MySQLs.LIST_ACTOR;
		logger.info("listActor:-" + SQL);
		List<Actor> actorList = jdbcTemplate.query(SQL, new ActorMapper());
		if (logger.isDebugEnabled())
			logger.debug("listActor:-" + actorList);
		return actorList;
	}

	@Override
	public Actor getActor(int id) {
		String SQL = MySQLs.GET_ACTOR;
		logger.info("Get Actor:-" + SQL);
		Actor actor = jdbcTemplate.queryForObject(SQL, new Object[] { id },
				new ActorMapper());
		logger.info("Get Actor:-" + actor);
		return actor;
	}

	@Override
	public boolean addActor(Actor actor) {
		String SQL = MySQLs.ADD_ACTOR;
		logger.info("Add Actor:-" + SQL);
		logger.info("Add Actor:-" + actor);
		jdbcTemplate.update(SQL, actor.getFirstName(), actor.getLastName());
		logger.info("Added Actor:-" + actor);
		return true;
	}

	@Override
	public boolean deleteActor(int id) {
		String SQL = MySQLs.DELETE_ACTOR;
		logger.info("delete Actor:-" + SQL);
		logger.info("delete Actor:-" + id);

		jdbcTemplate.update(SQL, id);
		logger.info("Deleted Record with ID = " + id);

		return true;
	}

	@Override
	public boolean editActor(Actor actor) {
		String SQL = MySQLs.EDIT_ACTOR;
		logger.info("edit Actor:-" + SQL);
		logger.info("edit Actor:-" + actor);

		jdbcTemplate.update(SQL, actor.getFirstName(), actor.getLastName(),
				actor.getId());
		logger.info("Deleted Record with ID = " + actor.getId());
		return true;
	}

}
