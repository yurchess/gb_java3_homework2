package org.mitroshin.commands;

public abstract class DBCommand {

    DBCommand(String[] arguments) {

    };

    public abstract void execute();
}
