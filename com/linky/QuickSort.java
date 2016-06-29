package com.linky;

public class QuickSort {

	public static final int M = 10;	// 5 ~ 10 
	
    public static void sort(SortItem[] items, int low, int high) {
    	if (high <= low + M) {
    		// 如果是小数组，5 ～ 15个元素，那么使用插入排序会更快一点；
    		SelectionSort sSort = new SelectionSort(items);	
    		sSort.sort();
    		return;
    	}
    	int j = partition(items, low, high);
    	sort(items, low, j - 1);
    	sort(items, j+1, high);
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
    	display(items);
    	return j;
    } 
    
    public static void display(SortItem items[]) {
		assert items != null;
		int N = items.length;
		for (int i = 0; i < N; i++) {
			System.out.print(items[i].sorter + ", ");
		}
		System.out.println("\n");
	}

    private static void exchange(SortItem[] items, int i, int j) {
        int sorter = items[i].sorter;
        items[i].sorter= items[j].sorter;
        items[j].sorter = sorter;
    }
}
