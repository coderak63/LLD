package DesignPatterns.Behavioral.ObserverDesignPattern;

public class PhoneObserver implements Observer{

    private String weather;

    @Override
    public void update(String weather) {
        this.weather=weather;
        System.out.println("Updated weather on Phone: "+ this.weather);
    }

}
