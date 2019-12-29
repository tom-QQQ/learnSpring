package demo.model.observer.java;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public interface Observer {

    /**
     * 更新数据
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    void update(float temp, float humidity, float pressure);

    /**
     * 温度通知最小变化值
     * @return 值
     */
    float getNotifyTempMinChange();

    /**
     * 上次通知的温度
     * @return 温度
     */
    Float lastNotifyValue();

    /**
     * 获取名称
     * @return 名称
     */
    String getName();

    /**
     * 设置id
     * @param id id
     */
    void setId(Long id);
}
