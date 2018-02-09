package org.mitroshin.commands;

import org.mitroshin.DatabaseAPI;

public class CommandSelectByPriceRange extends DBCommand {
    private int low;
    private int high;

    public CommandSelectByPriceRange(String[] arguments) {
        super(arguments);
        low = Integer.parseInt(arguments[1]);
        high = Integer.parseInt(arguments[2]);
    }

    @Override
    public void execute() {
        DatabaseAPI.getInstance().getProductsWithinPriceRange(low, high);
    }
}
