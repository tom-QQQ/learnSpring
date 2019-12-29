package demo.model.command.command.impl;


import demo.model.command.command.Command;
import demo.model.command.object.light.Light;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class LightOnCommand implements Command {
    
    private Light light;

    public LightOnCommand(Light light) {

        this.light = light;
    }

    @Override
    public void execute() {
        this.light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
