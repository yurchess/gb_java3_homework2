package org.mitroshin.commands;

public class CommandBuilder {

    public static DBCommand BuildCommand(String[] arguments) throws Exception {
        switch (arguments[0]) {
            case Constants.INIT:
                return new CommandInit(arguments);
            case Constants.GET_PRICE:
                return new CommandGetPriceByName(arguments);
            case Constants.SET_PRICE:
                return new CommandSetPriceByName(arguments);
            case Constants.LIST:
                return new CommandSelectByPriceRange(arguments);
            case Constants.HELP:
                return new CommandHelp(arguments);
            default:
                return new CommandUnknown(arguments);
        }
    }
}
