package org.mitroshin.commands;

import org.mitroshin.DatabaseAPI;

public class CommandSetPriceByName extends DBCommand {
    private String name;
    private int newPrice;

    public CommandSetPriceByName(String[] arguments) {
        super(arguments);
        name = arguments[1];
        newPrice = Integer.parseInt(arguments[2]);
    }

    @Override
    public void execute() {
        DatabaseAPI.getInstance().changePrice(name, newPrice);
    }
}
