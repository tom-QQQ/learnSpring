package demo.model.observer.java.impl;


import demo.model.observer.java.DisplayElement;
import demo.model.observer.java.Observer;

import java.util.Objects;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public class CurrentConditionDisplay implements Observer, DisplayElement {

    private Float temperature;
    private float humidity;
    private float pressure;
    private float notifyTempMinChange;

    /**
     * 两个对象是否相同的判断条件
     */
    private Long id;


    @Override
    public void update(float temp, float humidity, float pressure) {

        System.out.println(getName() + "收到天气信息更新, 修改看板");

        this.humidity = humidity;
        this.temperature = temp;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {

        try {
            Thread.sleep(500);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getName() + "当前天气状况是: 温度: " + temperature + "°C, 湿度: " + humidity + "%, 气压: " + pressure + "kPa.");
    }

    @Override
    public float getNotifyTempMinChange() {
        return this.notifyTempMinChange;
    }

    public void setNotifyTempMinChange(float notifyTempMinChange) {
        this.notifyTempMinChange = notifyTempMinChange;
    }

    @Override
    public Float lastNotifyValue() {
        return temperature;
    }

    @Override
    public String getName() {
        return "看板1";
    }

    private Long getId() {
        return this.id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {return true;}
        if (!(o instanceof CurrentConditionDisplay)) {return false;}
        CurrentConditionDisplay that = (CurrentConditionDisplay) o;
        return that.getId().equals(this.getId());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId());
    }
}
