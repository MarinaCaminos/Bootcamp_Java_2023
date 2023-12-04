package main.java.com.desafio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.desafio.entity.CovidEntity;

public class CovidRepository {

	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/covid";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
	
	public CovidEntity buscarCovidPorId(int covidId) {
		CovidEntity entity = null;

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "SELECT * FROM covid WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, covidId);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            entity.setId(resultSet.getLong(0));
            entity.setStates(resultSet.getLong(1));
            entity.setPositive(resultSet.getLong(2));
            entity.setNegative(resultSet.getLong(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }
	
	public void guardarPokemon(CovidEntity entity) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "INSERT INTO pokemon (name, height, order) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getStates());
            preparedStatement.setLong(2, entity.getPositive());
            preparedStatement.setLong(2, entity.getNegative());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
