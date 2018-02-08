package org.mitroshin;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        DatabaseAPI databaseAPI = new DatabaseAPI();
        try {
            databaseAPI.connect();

            Scanner scanner = new Scanner(System.in);

            boolean working = true;
            while (working) {
                String command = scanner.nextLine();
                String[] arguments = command.split(" ");

                switch (arguments[0]) {
                    case "init":
                        databaseAPI.init();
                        break;
                    case "getPrice":
                        databaseAPI.getPrice(arguments[1]);
                        break;
                    case "setPrice":
                        databaseAPI.changePrice(arguments[1], Integer.parseInt(arguments[2]));
                        break;
                    case "list":
                        databaseAPI.getProductsWithinPriceRange(Integer.parseInt(arguments[1]), Integer.parseInt(arguments[2]));
                        break;
                    case "exit":
                        working = false;
                        break;
                    default:
                        System.out.println("Wrong command");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
