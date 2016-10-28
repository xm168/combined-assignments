package com.cooksys.ftd.assignments.jdbc.dao;

import com.cooksys.ftd.assignments.jdbc.model.Interest;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManager;
import com.cooksys.ftd.assignments.jdbc.predef.CrudDao;
import com.cooksys.ftd.assignments.jdbc.predef.JdbcCrudDao;

public class InterestDao extends JdbcCrudDao<Interest, Integer> {

	public InterestDao(ConnectionManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
    // TODO
}
