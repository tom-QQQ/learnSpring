package demo.model.command.command.impl;


import demo.model.command.command.Command;
import demo.model.command.object.stereo.Stereo;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class StereoOffCommand implements Command {

    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.off();
    }

    @Override
    public void undo() {
        stereo.onWithCD();
    }
}
