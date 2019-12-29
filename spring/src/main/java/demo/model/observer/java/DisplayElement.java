package demo.model.observer.java;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public interface DisplayElement {

    /**
     * 由于不同的看板可能需要不同的数据, 因此需要使用接口
     */
    void display();
}
