package com.cooksys.ftd.assignments.jdbc.dao;

import com.cooksys.ftd.assignments.jdbc.model.Group;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManager;
import com.cooksys.ftd.assignments.jdbc.predef.CrudDao;
import com.cooksys.ftd.assignments.jdbc.predef.JdbcCrudDao;

public class GroupDao extends JdbcCrudDao<Group, Integer> {

	public GroupDao(ConnectionManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
    // TODO
}
