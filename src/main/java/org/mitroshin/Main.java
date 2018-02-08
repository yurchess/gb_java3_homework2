package org.mitroshin;

public class Main {
    public static void main(String[] args) {

        DatabaseAPI databaseAPI = new DatabaseAPI();
        databaseAPI.init();
        databaseAPI.read();
    }
}
