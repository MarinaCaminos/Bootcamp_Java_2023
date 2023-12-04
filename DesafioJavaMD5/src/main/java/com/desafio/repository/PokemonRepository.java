package main.java.com.desafio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.desafio.entity.PokemonEntity;

public class PokemonRepository {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pokemon";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
	
	public PokemonEntity buscarPokemonPorId(int pokemonId) {
		PokemonEntity entity = null;

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "SELECT * FROM pokemon WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, pokemonId);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            entity.setId(resultSet.getLong(0));
            entity.setName(resultSet.getString(1));
            entity.setHeight(resultSet.getLong(2));
            entity.setOrder(resultSet.getLong(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }
	
	public void guardarPokemon(PokemonEntity entity) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "INSERT INTO pokemon (name, height, order) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setLong(2, entity.getHeight());
            preparedStatement.setLong(2, entity.getOrder());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
