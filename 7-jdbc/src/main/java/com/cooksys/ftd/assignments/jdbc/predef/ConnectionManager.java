package com.cooksys.ftd.assignments.jdbc.predef;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionManager {
	
	Connection getConnection() throws SQLException, ClassNotFoundException;

}
