package com.cooksys.ftd.assignments.jdbc.predef;

import java.sql.Connection;

public abstract class JdbcCrudDao<E extends Entity<I>, I> implements CrudDao<E, I> {
	protected ConnectionManager manager;
	
	public JdbcCrudDao(ConnectionManager manager) {
		this.manager = manager;
	}
	
}
