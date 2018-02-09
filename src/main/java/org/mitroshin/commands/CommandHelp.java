package org.mitroshin.commands;

public class CommandHelp extends DBCommand {
    public CommandHelp(String[] arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        System.out.println(Constants.INIT + " - initialize DB");
        System.out.println(Constants.GET_PRICE + " [ProductTitle] - get [ProductTitle] price");
        System.out.println(Constants.SET_PRICE + " [ProductTitle] [NewPrice] - set new price");
        System.out.println(Constants.LIST + " [LowPrice] [HighPrice] - get all products with price between [LowPrice] and [HighPrice]");
        System.out.println("exit - exit the program");
    }
}
