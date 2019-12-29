package demo.model.command.object.light.impl;

import demo.model.command.object.RoomType;
import demo.model.command.object.light.Light;
import org.springframework.util.Assert;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class LightFactory {

    /**
     * 创建Light实现类对象时, 只能使用工厂方法创建
     * @param type 类型
     * @return Light实现类对象
     */
    public static Light getLight(RoomType type) {

        if (type == RoomType.Kitchen) {
            return new KitchenLight();

        } else if (type == RoomType.LivingRoom) {
            return new LivingRoomLight();

        } else {
            Assert.isTrue(false, "类型错误");
            return null;
        }
    }
}
