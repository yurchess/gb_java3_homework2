package org.mitroshin;

public class Main {
    public static void main(String[] args) {

        DatabaseAPI databaseAPI = new DatabaseAPI();
        try {
            databaseAPI.connect();

            databaseAPI.init();
            databaseAPI.read();
            databaseAPI.getPrice("Product1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
