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
                System.out.print("Enter command: ");
                String command = scanner.nextLine();
                String[] arguments = command.split(" ");

                try {
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
                        case "help":
                            System.out.println("init                                - initialize DB");
                            System.out.println("getPrice [ProductTitle]             - get [ProductTitle] price");
                            System.out.println("setPrice [ProductTitle] [NewPrice]  - set new price");
                            System.out.println("list [LowPrice] [HighPrice]         - get all products with price between [LowPrice] and [HighPrice]");
                            System.out.println("exit                                - exit the program");
                            break;
                        default:
                            System.out.println("Wrong command (type 'help' to see command list)");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
