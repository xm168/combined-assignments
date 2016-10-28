package com.cooksys.ftd.assignments.jdbc.dao;

import com.cooksys.ftd.assignments.jdbc.model.City;
import com.cooksys.ftd.assignments.jdbc.model.State;

import java.sql.*;
import java.util.Optional;

public class CityDao {

    PreparedStatement createStmt;

    public Integer create(City city) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgres.Driver");

        Connection connection =
                DriverManager
                        .getConnection(
                                "jdbc:postgresql://localhost:5432/postgres?currentSchema=cutlleferns",
                                "postgres",
                                "bondstone"
                        );

        PreparedStatement stmt =
                connection
                        .prepareStatement(
                                "INSERT INTO cities (name, state_id) VALUES (?, ?)",
                                Statement.RETURN_GENERATED_KEYS
                        );

        stmt.setString(1, city.getName());
        stmt.setInt(2, city.getState().getId());

        int rowsChanged = stmt.executeUpdate();
        int id = 0;
        if (rowsChanged == 1) {
            ResultSet rs = stmt.getGeneratedKeys();
            while(rs.next()) {
                id = rs.getInt(1);
            }
        }

        if (id > 0) {
            return id;
        } else {
            throw new RuntimeException("Did not successfully insert record");
        }
    }

    public Optional<City> read(Integer id) throws SQLException, ClassNotFoundException {

        return Optional.ofNullable(id)
                .flatMap(possibleId -> {
                    try {
                        Class.forName("org.postgres.Driver");
                        Connection connection =
                                DriverManager
                                        .getConnection(
                                                "jdbc:postgresql://localhost:5432/postgres?currentSchema=cutlleferns",
                                                "postgres",
                                                "bondstone"
                                        );

                        PreparedStatement stmt =
                                connection
                                        .prepareStatement(
                                                "select * from cities where id = ?"
                                        );

                        stmt.setInt(1, possibleId);
                        ResultSet rs = stmt.executeQuery();
                        City result = null;
                        while(rs.next()) {
                            result = new City();
                            result.setId(rs.getInt("id"));
                            result.setName(rs.getString("name"));
                            int stateId = rs.getInt("state_id");
                            State state = new State();
                            state.setId(stateId);
                            result.setState(state);
                        }
                        return Optional.ofNullable(result);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                    return Optional.empty();
                });
    }

}
