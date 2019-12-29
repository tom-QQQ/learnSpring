package demo.model.observer.java;


import demo.model.observer.java.impl.CurrentConditionDisplay;
import demo.model.observer.java.impl.WeatherData;

/**
 * @author Ning
 * @date Create in 2019/3/20
 */
public class TestObserver {

    public static void main(String[] args) {

        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay();
        currentConditionDisplay.setNotifyTempMinChange(1.0f);
        // 不应该把被观察者和观察者耦合到一起, 应该单独处理, 最好是使用Spring的Bean, 将被观察者构建为Bean, 在观察者创建时注入被观察者对象, 调用被观察者的相关方法
        weatherData.addObserver(currentConditionDisplay);

        weatherData.setMeasurements(23.2f, 68f, 110f);
        weatherData.setMeasurements(32.5f, 55.6f, 120f);
        weatherData.setMeasurements(32.5f, 55.6f, 120f);
    }

}
