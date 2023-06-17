package com.example.databselibrary.dao;

import com.example.databselibrary.model.Book;

import java.sql.*;

public class BookDao {

    public void insert(Book book) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "insert into books (title, author, year, isbn) values (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getTitle());
            preparedStatement.setString(2, book.getAuthor());
            preparedStatement.setInt(3, book.getYear());
            preparedStatement.setInt(4, book.getIsbn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("problem with save data");
        }
        closeConnection(connection);
    }

    public Book readData(int isbn) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;

        try {
            String sql = "SELECT * from books where isbn = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, isbn);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int year = resultSet.getInt("year");
                int isbnFromDatabase = resultSet.getInt("isbn");
                Book book = new Book(id, title, author, year, isbnFromDatabase);
                return book;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(connection);
        return null;
    }

    public void updateData(Book book) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;


            String sql = "update books set title = ?, author = ?, year = ?, isbn = ? where id = ?";
            try {
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, book.getTitle());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setInt(3, book.getYear());
                preparedStatement.setInt(4, book.getIsbn());
                preparedStatement.setInt(5, book.getId());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            closeConnection(connection);
        }

    public void delete(int id) {
        Connection connection = connect();
        PreparedStatement preparedStatement = null;

        String sql = "delete from books where id = ?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/library";
        try {
            return DriverManager.getConnection(url, "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
