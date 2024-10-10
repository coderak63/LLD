package DesignPatterns.Behavioral.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class WeatherStationSubject implements Subject{

    private List<Observer> observers = new ArrayList<>();
    private String weather;

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(Observer obs:observers){
            obs.update(weather);
        }
    }

    @Override
    public void setWeather(String weather){
        this.weather=weather;
        notifyObservers();
    }

}
