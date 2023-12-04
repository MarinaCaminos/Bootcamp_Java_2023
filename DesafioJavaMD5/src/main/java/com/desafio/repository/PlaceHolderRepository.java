package main.java.com.desafio.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import main.java.com.desafio.entity.PlaceHolderEntity;

public class PlaceHolderRepository {
	
	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/placeHolder";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
	
	public PlaceHolderEntity buscarPlaceHolderPorId(int placeHolderId) {
		PlaceHolderEntity entity = null;

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "SELECT * FROM place holder WHERE id = ?";
            
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, placeHolderId);

            ResultSet resultSet = preparedStatement.executeQuery();
            
            entity.setUserId(resultSet.getLong(0));
            entity.setId(resultSet.getLong(1));
            entity.setTitle(resultSet.getString(2));
            entity.setCompleted(resultSet.getBoolean(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return entity;
    }
	
	public void guardarPlaceHolder(PlaceHolderEntity entity) {
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            String sql = "INSERT INTO place holder (id, title, completed) VALUES (?, ?, ?)";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, entity.getId());
            preparedStatement.setString(2, entity.getTitle());
            preparedStatement.setBoolean(2, entity.isCompleted());

            preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
