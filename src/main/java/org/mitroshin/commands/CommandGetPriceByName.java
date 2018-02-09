package org.mitroshin.commands;

import org.mitroshin.DatabaseAPI;

public class CommandGetPriceByName extends DBCommand {
    private String name;

    public CommandGetPriceByName(String[] arguments) {
        super(arguments);
        name = arguments[1];
    }

    @Override
    public void execute() {
        DatabaseAPI databaseAPI = DatabaseAPI.getInstance();
        databaseAPI.getPrice(name);
    }
}
