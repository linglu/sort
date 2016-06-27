package com.linky;

public class ShellSort {

	private static final int GROUP_COUNT = 3;
	private SortItem[] items;

    public ShellSort(SortItem[] items) {
        this.items = items;
    } 
 
    public void sort() {

    	/**
    	 * 使用 分组大小递减，从 N/3 至 1 
    	 * 1. 获得子组元素；
    	 * 2. 对子组元素进行排序；
    	 */
    	int N = items.length;
    	int groupCount = GROUP_COUNT;

    	for (int p = groupCount; p > 0; p--) {
	    	int subGroupSize = N / p + 1;
	    	SortItem[] temps = new SortItem[subGroupSize];

	    	// 对每组进行插入排序
	    	for (int k = 0; k < p; k++) {
	    		
	    		// 获取分组 
	    		int j = 0;
	    		for (int i = k; i < N;) {
	        		temps[j] = items[i];
	        		j++;
	        		i = i + p;
	        	}
	    		
	    		// 去除数组中的空值 
	        	SortItem[] temps1 = new SortItem[j];
	        	for (int i = 0; i < j; i++) {
	        		temps1[i] = temps[i];
	        	}
	
	    		// 对分组进行排序
	    		InsertionSort insertionSort = new InsertionSort(temps1);
	        	insertionSort.sort(); 
	
	        	// 输出排序结果
	        	System.out.print("temps : ");
	        	for (SortItem item : temps1) {
	        		if (item != null)
	        			System.out.print(item.sorter + ", ");
	    		}
	        	System.out.println('\n');
	    	}
    	}
    }
    
    public void display() {
        for (SortItem item : items) {
            System.out.print(item.sorter + ", ");
        }
        System.out.println('\n');
    }
    
}
