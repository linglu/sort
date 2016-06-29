package com.linky;

public class Main {

	public static void main(String[] args) {
		quickSort();
    } 

	public static void quickSort() {
		SortItem[] items = RandomGenerator.generateRandoms();
		display(items);
		QuickSort.sort(items, 0, items.length - 1);
		display(items);
	}

	public static void partition() {
		// SortItem[] items = SortItem.generateSortItems();
		SortItem[] items = RandomGenerator.generateRandoms();
		display(items);
		QuickSort.partition(items, 0, 9);
		display(items);
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
	
	public static void display(SortItem items[]) {
		assert items != null;
		int N = items.length;
		for (int i = 0; i < N; i++) {
			System.out.print(items[i].sorter + ", ");
		}
		System.out.println("\n");
	}
}
