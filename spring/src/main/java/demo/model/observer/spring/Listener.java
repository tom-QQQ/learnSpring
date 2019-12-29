package demo.model.observer.spring;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 监听器方法只需要添加@EventListener注解即可, 使用注解参数指明需要监听的类事件
 * @author Ning
 * @date Create in 2019/1/4
 */
@Component
public class Listener {

    /**
     * 监听事件
     * "@EventListener" 监听注解, value指明需要监听的一个或多个事件类,
     * @param event
     */
    @EventListener(value = {UserRegisterEvent.class, })
    public void onMailEvent(UserRegisterEvent event) {
        System.out.println("邮件服务接到通知, 给" + event.getSource() + "发送邮件");
    }

    /**
     * 异步任务, 需要进行配置 参见{@link demo.config.AsyncConfig}
     * @param event 监听事件类
     */
    @EventListener
    @Async
    public void onBonusEvent(UserRegisterEvent event) {

        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("积分服务接到通知, 给" + event.getSource() + "增加积分");
    }
}
