package com.linky;

public class ShellSort {

	private SortItem[] items;

    public ShellSort(SortItem[] items) {
        this.items = items;
    } 
 
    public void sort() {

    	/**
    	 * 遍历数组，比较间隔为 h 的元素，将较小的放在左边
    	 * h 的大小为一个 递减序列
    	 */
    	int N = items.length;
    	int h = 1;
    	while (h < N/3) h = 3*h + 1;	// 1, 4, 13, 40, ...
    	while (h >= 1) {
    		for (int i = h; i < N; i++) {
    			for (int j = i; j >= h && items[j].lessThan(items[j-h]); j -= h) {
    				exchange(j, j-h);
    			}
    		}
    		h = h/3;	// 递减 
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
