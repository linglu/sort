package com.linky;

public class QuickSort {

    public static void sort(SortItem[] items, int low, int high) {
    	
    }

    public static void partition(SortItem[] items, int low, int high) {

    	assert items != null;
    	
    	int i = low + 1;
    	int j = high;
    	SortItem item = items[low];
    	while (i != j) {
	    	while (items[i].lessThan(item) && i < j) {
	    		i++;
	    	}
	    	while (item.lessThan(items[j]) && j > i) {
	    		j--;
	    	}
	    	if (i != j) {
	    		exchange(items, i, j);
	    	}
    	}
    	
    	if (i == high) {
    		exchange(items, low, i);
    	} else {
    		exchange(items, low, i - 1);
    	}
    } 

    private static void exchange(SortItem[] items, int i, int j) {
        int sorter = items[i].sorter;
        items[i].sorter= items[j].sorter;
        items[j].sorter = sorter;
    }
}
