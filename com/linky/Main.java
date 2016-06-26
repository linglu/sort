package com.linky;

public class Main {

	public static void main(String[] args) {
        SelectionSort selection = new SelectionSort(SortItem.generateSortItems());
        selection.display();

        selection.sort();
        selection.display();
    }
}
