package demo.model.command.command.impl.ceiling.fan;


import demo.model.command.object.ceiling.fan.CeilingFan;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class CeilingFanHighCommand extends AbstractCeilingFanCommand {

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        super.ceilingFan = ceilingFan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        ceilingFan.adjustHigh();
    }
}
