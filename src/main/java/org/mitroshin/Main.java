package org.mitroshin;

public class Main {
    public static void main(String[] args) {

        DatabaseAPI databaseAPI = new DatabaseAPI();
        try {
            databaseAPI.connect();

            databaseAPI.init();
            databaseAPI.read();
            databaseAPI.getPrice("Product1");
            databaseAPI.changePrice("Product1", 55);
            databaseAPI.getPrice("Product1");

            databaseAPI.getProductsWithinPriceRange(20, 56);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
