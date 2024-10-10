package DesignPatterns.Behavioral.StrategyDesignPattern;

public class BubbleSortingStrategy implements SortingStrategy{

    @Override
    public void doSorting() {
        System.out.println("Sorting using Bubble sort");
    }

}
