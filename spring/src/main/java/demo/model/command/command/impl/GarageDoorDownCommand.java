package demo.model.command.command.impl;


import demo.model.command.command.Command;
import demo.model.command.object.door.GarageDoor;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class GarageDoorDownCommand implements Command {

    private GarageDoor garageDoor;

    public GarageDoorDownCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.down();
    }

    @Override
    public void undo() {
        garageDoor.up();
    }
}
