package demo.model.observer.java.impl;



import demo.model.observer.java.Observable;
import demo.model.observer.java.Observer;

import java.util.ArrayList;

/**
 * 气象站类, 数据由此获取
 * @author Ning
 * @date Create in 2019/3/20
 */
public class WeatherData implements Observable {

    private ArrayList<Observer> observers;
    private float temperature;
    private float humidity;
    private float pressure;
    private Long id = 0L;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public synchronized void addObserver(Observer observer) {
        observer.setId(id);
        id++;
        observers.add(observer);
    }

    @Override
    public void deleteObserver(Observer observer) {
        System.out.println("删除" + observer.getName());
        int index = observers.indexOf(observer);

        if (index != -1) {
            observers.remove(index);
        }
    }

    @Override
    public void notifyObservers() {


        // 根据条件判断是否需要通知

        System.out.println("温度发生变化, 进行通知");
        for (Observer observer : observers) {

            // 除第一次之外如果当前温度和之前通知温度的差值大于通知最小差值变化值, 才通知
            if (observer.lastNotifyValue() == null || Math.abs(temperature - observer.lastNotifyValue()) > observer.getNotifyTempMinChange()) {
                observer.update(temperature, humidity, pressure);
            } else {
                System.out.println("不满足" + observer.getName() + "的温度变化需求, 不通知");
            }
        }
    }

    /**
     * 数据更新时会调用的方法
     */
    public void measurementsChanged() {

        notifyObservers();
    }

    /**
     * 用于测试数据读取的方法, 模拟数据更新
     * @param temp 温度
     * @param humidity 湿度
     * @param pressure 气压
     */
    public void setMeasurements(float temp, float humidity, float pressure) {

        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
