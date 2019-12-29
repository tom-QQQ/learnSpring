package demo.model.observer.spring;

import org.springframework.context.ApplicationEvent;

/**
 * 事件类: 用来描述事件本身一些属性
 * @author Ning
 * @date Create in 2019/1/3
 */
 class UserRegisterEvent extends ApplicationEvent {

     UserRegisterEvent(Object o) {
        super(o);
    }
}
