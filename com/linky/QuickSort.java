package com.linky;

public class QuickSort {

    public static void sort(SortItem[] items, int low, int high) {
    	
    }

    public static int partition(SortItem[] items, int low, int high) {
    	assert items != null;
    	int i = low;
    	int j = high + 1;

    	SortItem item = items[low];
    	while (true) {
    		while (items[++i].lessThan(item)) if (i == high) break; 
    		while (item.lessThan(items[--j])) if (j == low) break; 
    		if (i >= j) break; 
    		exchange(items, i, j); 
    	}  
    	exchange(items, low, j);
    	return j;
    } 

    private static void exchange(SortItem[] items, int i, int j) {
        int sorter = items[i].sorter;
        items[i].sorter= items[j].sorter;
        items[j].sorter = sorter;
    }
}
