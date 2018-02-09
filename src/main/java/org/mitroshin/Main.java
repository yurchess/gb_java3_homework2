/**
 * Java3. Homework2
 *
 * @author Yury Mitroshin
 * @version dated Feb 9, 2018
 * @link https://github.com/yurchess/gb_java3_homework2
 */

package org.mitroshin;

import org.mitroshin.commands.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean working = true;
        while (working) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            String[] arguments = command.split(" ");

            switch (arguments[0]) {
                case "exit":
                    working = false;
                    break;
                default:
                    try {
                        DBCommand dbCommand = CommandBuilder.BuildCommand(arguments);
                        dbCommand.execute();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
        System.exit(0);
    }
}
