package demo.model.command.controller;


import demo.model.command.command.Command;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class SimpleRemoteController {

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void buttonWasPressed() {
        command.execute();
    }
}
