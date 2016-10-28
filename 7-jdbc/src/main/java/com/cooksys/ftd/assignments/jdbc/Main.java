package com.cooksys.ftd.assignments.jdbc;

import java.util.HashSet;

import com.cooksys.ftd.assignments.jdbc.dao.CityDao;
import com.cooksys.ftd.assignments.jdbc.dao.GroupDao;
import com.cooksys.ftd.assignments.jdbc.dao.InterestDao;
import com.cooksys.ftd.assignments.jdbc.dao.PersonDao;
import com.cooksys.ftd.assignments.jdbc.dao.StateDao;
import com.cooksys.ftd.assignments.jdbc.model.City;
import com.cooksys.ftd.assignments.jdbc.model.Group;
import com.cooksys.ftd.assignments.jdbc.model.Interest;
import com.cooksys.ftd.assignments.jdbc.model.Person;
import com.cooksys.ftd.assignments.jdbc.model.State;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManager;
import com.cooksys.ftd.assignments.jdbc.predef.ConnectionManagerImpl;
import com.cooksys.ftd.assignments.jdbc.predef.CrudDao;

public class Main {
	static ConnectionManager manager;
	static CrudDao<City, Integer> cities;
	static CrudDao<Group, Integer> groups;
	static CrudDao<Interest, Integer> interests;
	static CrudDao<Person, Integer> people;
	static CrudDao<State, Integer> states;

	public static void initialize() {
		manager = new ConnectionManagerImpl("org.postgresql.Driver",
				"jdbc:postgresql://localhost:5432/postgres?currentSchema=cuttleferns", "postgres", "bondstone");
		cities = new CityDao(manager);
		groups = new GroupDao(manager);
		interests = new InterestDao(manager);
		people = new PersonDao(manager);
		states = new StateDao(manager);
	}

	public static void main(String[] args) {
		initialize();
		
		Interest ferns = new Interest();
		ferns.setName("ferns");
		ferns.setId(interests.create(ferns));

		State tn = new State();
		tn.setName("Tennessee");
		tn.setId(states.create(tn));

		City memphis = new City();
		memphis.setName("Memphis");
		memphis.setState(tn);
		memphis.setId(cities.create(memphis));

		Person pete = new Person();
		pete.setFirstName("Peter");
		pete.setLastName("Zastoupil");
		pete.setCity(memphis);
		pete.setInterests(new HashSet<>());
		pete.getInterests().add(ferns);
		pete.setId(people.create(pete));

		Group fas = new Group();
		fas.setName("Fern Appreciation Society");
		fas.setInterest(ferns);
		fas.setCity(memphis);
		fas.setMembers(new HashSet<>());
		fas.getMembers().add(pete);
		fas.setId(groups.create(fas));
	}

}
