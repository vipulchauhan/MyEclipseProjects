package com.dvdrental.sqls;

public class MySQLs {
	
	public static final String ADD_ACTOR = "insert into Actor (actor_id, first_name,last_name,last_update) values ((select max(actor_id)+1 from actor),?,?,current_date)";
			
	public static final String LIST_ACTOR = "select * from ACTOR";
	public static final String GET_ACTOR = "select * from Actor where actor_id = ?";
	public static final String DELETE_ACTOR = "delete from Actor where actor_id = ?";
	public static final String EDIT_ACTOR = "update actor set first_name = ? , last_name = ? , last_update = current_date where actor_id = ?";

}
