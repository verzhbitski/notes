package org.verzhbitski.data;

import javafx.beans.property.SimpleStringProperty;

public class Note {
    private final SimpleStringProperty date;
    private final SimpleStringProperty time;
    private final SimpleStringProperty text;

    public Note(String date, String time, String text) {
        this.date = new SimpleStringProperty(date);
        this.time = new SimpleStringProperty(time);
        this.text = new SimpleStringProperty(text);
    }

    public String getDate() {
        return date.get();
    }

    public String getTime() {
        return time.get();
    }

    public String getText() {
        return text.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public void setTime(String time) {
        this.time.set(time);
    }

    public void setText(String text) {
        this.text.set(text);
    }
}
