package org.mitroshin.commands;

public class CommandHelp extends DBCommand {
    public CommandHelp(String[] arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        System.out.println("init                                - initialize DB");
        System.out.println("getPrice [ProductTitle]             - get [ProductTitle] price");
        System.out.println("setPrice [ProductTitle] [NewPrice]  - set new price");
        System.out.println("list [LowPrice] [HighPrice]         - get all products with price between [LowPrice] and [HighPrice]");
        System.out.println("exit                                - exit the program");
    }
}
