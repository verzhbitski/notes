package org.verzhbitski.database;

import org.verzhbitski.data.Note;

import java.sql.*;

public class DBConnector {
    private Connection connection;
    private static DBConnector instance = new DBConnector();

    private static final String CREATE_TABLE_STATEMENT =
            "CREATE TABLE IF NOT EXISTS notes (\n"
            + "date VARCHAR(10), \n"
            + "time VARCHAR(8), \n"
            + "text VARCHAR(100) \n"
            + ");";

    private DBConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:notes.db");
            Statement statement = connection.createStatement();
            statement.execute(CREATE_TABLE_STATEMENT);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addData(Note note) {
        try {
            Statement statement = connection.createStatement();
            String sql =
                    "INSERT INTO notes \n" +
                    "VALUES ('" + note.getDate() + "', '" + note.getTime() + "', '" + note.getText() + "')";
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet getData() {
        try {
            Statement statement = connection.createStatement();
            String sql = "SELECT * FROM notes;";
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static DBConnector getInstance() {
        if (instance == null) {
            instance = new DBConnector();
        }
        return instance;
    }
}
