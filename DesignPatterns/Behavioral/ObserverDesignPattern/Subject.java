package DesignPatterns.Behavioral.ObserverDesignPattern;

public interface Subject {
    public void addObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();
    public void setWeather(String weather);

}
