package org.verzhbitski.database;

import org.verzhbitski.data.Note;

public class DataAdder extends Thread {
    private Note note;

    public DataAdder(Note note) {
        this.note = note;
    }

    @Override
    public void run() {
        DBConnector db = DBConnector.getInstance();
        db.addData(note);
    }
}
