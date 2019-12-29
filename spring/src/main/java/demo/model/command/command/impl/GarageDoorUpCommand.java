package demo.model.command.command.impl;


import demo.model.command.command.Command;
import demo.model.command.object.door.GarageDoor;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class GarageDoorUpCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorUpCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.up();
    }

    @Override
    public void undo() {
        garageDoor.down();
    }
}
