package com.linky;

/**
 * Created by Linky on 16-6-25.
 */
public class InsertionSort {

    private SortItem[] items;

    public InsertionSort(SortItem[] items) {
        this.items = items;
    }

    public void sort() {
    	/**
    	 * 当前索引左边的所有元素都是有序的；
    	 * 当索引到达数组右端时，数组排序就完成了；
    	 */
    	int N = items.length;
    	for (int i = 1; i < N; i++) {
    		for (int j = i; j > 0 && items[j].lessThan(items[j-1]); j--) {
    			exchange(j, j-1);
    		}
    	}
    }
    
    private void exchange(int i, int j) {
        int sorter = items[i].sorter;
        items[i].sorter= items[j].sorter;
        items[j].sorter = sorter;
    }
    
    public void display() {
        for (SortItem item : items) {
            System.out.print(item.sorter + ", ");
        }
        System.out.println('\n');
    }

}
