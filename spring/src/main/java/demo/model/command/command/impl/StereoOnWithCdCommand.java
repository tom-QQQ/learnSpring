package demo.model.command.command.impl;


import demo.model.command.command.Command;
import demo.model.command.object.stereo.Stereo;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class StereoOnWithCdCommand implements Command {

    private Stereo stereo;

    public StereoOnWithCdCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.onWithCD();
    }

    @Override
    public void undo() {
        stereo.off();
    }
}
