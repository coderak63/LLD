package DesignPatterns.Behavioral.StrategyDesignPattern;

public class SortingContext {
    private SortingStrategy sortingStrategy;

    SortingContext(SortingStrategy sortingStrategy){
        this.sortingStrategy=sortingStrategy;
    }

    public void setStrategy(SortingStrategy sortingStrategy){
        this.sortingStrategy=sortingStrategy;
    }

    public void sort(){
        sortingStrategy.doSorting();
    }
}
