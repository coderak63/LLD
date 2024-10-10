package DesignPatterns.Behavioral.StrategyDesignPattern;

public class Test {
    public static void main(String[] args) {
        SortingContext bubbleSortingContext = new SortingContext(new BubbleSortingStrategy());
        SortingContext mergeSortingContext = new SortingContext(new MergeSortingStrategy());

        bubbleSortingContext.sort();
        mergeSortingContext.sort();
    }
}
