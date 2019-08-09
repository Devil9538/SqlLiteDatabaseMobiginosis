package com.pryce_visitor.sqllitedatabasemobiginosis.note;

public class Note {
    String data;
    int id;
    String timestamp;

    public static final String Table_Name="notes";
    public static final String Column_Id= "id";
    public static final String COLUMN_NOTE = "note";
    public static final String COLUMN_TIMESTAMP = "timestamp";

        public static final String CREATE_TABLE =
                "Create Table " + Table_Name + "("
                        + Column_Id + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COLUMN_NOTE + " TEXT,"
                        +COLUMN_TIMESTAMP + " DATETIME DEFAULT CURRENT_TIMESTAMP"
                        + ")";



    public Note(String data, int id, String timestamp) {
        this.data = data;
        this.id = id;
        this.timestamp = timestamp;
    }

    public Note() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
