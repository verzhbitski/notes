package org.verzhbitski.database;

import org.verzhbitski.data.Data;
import org.verzhbitski.data.Note;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetriever extends Thread {
    @Override
    public void run() {
        DBConnector db = DBConnector.getInstance();
        ResultSet data = db.getData();
        try {
            while (data.next()) {
                Data.data.add(new Note(data.getString("date"), data.getString("time"), data.getString("text")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
