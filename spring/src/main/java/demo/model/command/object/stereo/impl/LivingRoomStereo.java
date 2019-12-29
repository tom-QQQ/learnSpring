package demo.model.command.object.stereo.impl;


import demo.model.command.object.stereo.Stereo;

/**
 * @author Ning
 * @date Create in 2019/3/30
 */
public class LivingRoomStereo implements Stereo {

    LivingRoomStereo() {}

    @Override
    public void onWithCD() {
        System.out.println("使用卧室的音响播放CD");
    }

    @Override
    public void off() {
        System.out.println("关闭卧室的音响");
    }
}
