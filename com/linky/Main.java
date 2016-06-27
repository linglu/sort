package com.linky;

public class Main {

	public static void main(String[] args) {
		MergeSort.sort(SortItem.generateSortItems(), 0, 4, 9);
    }
	
	public static void shell() {
		ShellSort shellSort = new ShellSort(SortItem.generateSortItems());
		shellSort.sort();
		shellSort.display();
	}
	
	public static void insertion() {
		InsertionSort insertion = new InsertionSort(SortItem.generateSortItems());
		insertion.display();

		insertion.sort();
		insertion.display();
	}
	
	public static void selection() {
		SelectionSort selection = new SelectionSort(SortItem.generateSortItems());
        selection.display();

        selection.sort();
        selection.display();
	}
}
