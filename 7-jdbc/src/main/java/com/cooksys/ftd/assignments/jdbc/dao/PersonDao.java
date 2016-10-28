package com.cooksys.ftd.assignments.jdbc.dao;

import com.cooksys.ftd.assignments.jdbc.model.Person;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManager;
import com.cooksys.ftd.assignments.jdbc.predef.CrudDao;
import com.cooksys.ftd.assignments.jdbc.predef.JdbcCrudDao;

public class PersonDao extends JdbcCrudDao<Person, Integer>  {

	public PersonDao(ConnectionManager manager) {
		super(manager);
		// TODO Auto-generated constructor stub
	}
    // TODO
}
