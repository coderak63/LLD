package DesignPatterns.Behavioral.ObserverDesignPattern;

public class Test {
    public static void main(String[] args) {
        Subject weatherStationSubject = new WeatherStationSubject();
        Observer phoneObserver = new PhoneObserver();
        Observer tVObserver = new TVObserver();

        weatherStationSubject.addObserver(phoneObserver);
        weatherStationSubject.addObserver(tVObserver);
        weatherStationSubject.setWeather("Raining...");

        weatherStationSubject.removeObserver(tVObserver);
        weatherStationSubject.setWeather("Cloudy...");
    }
}
