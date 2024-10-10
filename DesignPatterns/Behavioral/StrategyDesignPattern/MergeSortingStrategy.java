package DesignPatterns.Behavioral.StrategyDesignPattern;

public class MergeSortingStrategy implements SortingStrategy{

    @Override
    public void doSorting() {
        System.out.println("Sorting using merge sort");
    }

}
