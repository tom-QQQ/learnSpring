package demo.model.command.object.stereo.impl;

import demo.model.command.object.RoomType;
import demo.model.command.object.stereo.Stereo;
import org.springframework.util.Assert;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class StereoFactory {

    public static Stereo createStereo(RoomType type) {

        if (type == RoomType.LivingRoom) {
            return new LivingRoomStereo();

        } else {
            Assert.isTrue(false, "这种类型的音响不存在");
            return null;
        }
    }
}
