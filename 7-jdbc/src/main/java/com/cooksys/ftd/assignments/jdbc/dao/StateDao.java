package com.cooksys.ftd.assignments.jdbc.dao;

import com.cooksys.ftd.assignments.jdbc.model.State;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManager;
import com.cooksys.ftd.assignments.jdbc.predef.CrudDao;
import com.cooksys.ftd.assignments.jdbc.predef.JdbcCrudDao;

public class StateDao extends JdbcCrudDao<State, Integer> {

	public StateDao(ConnectionManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
    // TODO
}
