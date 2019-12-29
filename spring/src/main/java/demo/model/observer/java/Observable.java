package demo.model.observer.java;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public interface Observable {

    /**
     * 注册观察者
     * @param observer 观察者
     */
    void addObserver(Observer observer);

    /**
     * 删除观察者
     * @param observer 观察者
     */
    void deleteObserver(Observer observer);

    /**
     * 通知观察者
     */
    void notifyObservers();
}
