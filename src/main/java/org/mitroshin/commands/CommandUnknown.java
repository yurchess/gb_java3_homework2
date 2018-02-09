package org.mitroshin.commands;

public class CommandUnknown extends DBCommand{
    private String commandName;

    public CommandUnknown(String[] arguments) {
        super(arguments);
        commandName = arguments[0];
    }

    @Override
    public void execute() {
        System.out.println("Unknown command: '" + commandName + "'. Type '" + Constants.HELP + "' to see commands list");
    }
}
