package org.mitroshin.commands;

import org.mitroshin.DatabaseAPI;

public class CommandInit extends DBCommand {

    public CommandInit(String[] arguments) {
        super(arguments);
    }

    @Override
    public void execute() {
        DatabaseAPI.getInstance().init();
    }
}
