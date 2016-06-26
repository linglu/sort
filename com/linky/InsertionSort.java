package com.linky;

/**
 * Created by Linky on 16-6-25.
 */
public class InsertionSort {

	private static final int START_INDEX = 1;
    private SortItem[] items;

    public InsertionSort(SortItem[] items) {
        this.items = items;
    }

    public void sort() {
    	/**
    	 * 当前索引左边的所有元素都是有序的；
    	 * 当索引到达数组右端时，数组排序就完成了；
    	 */
    	if (items.length < 2) {
    		return;
    	}
    	
    	for (int k = START_INDEX; k < items.length; k++) {
    		SortItem curItem = items[k];
    		
    		// 如果当前的 item 的值是最小或者最大的；
    		if (curItem.lessThan(items[0])) {
    			moveToRight(0, k);
    		} else if (items[k-1].lessThan(curItem)) {
    			continue;
    		}
    		
    		// 如果当前的 item 值大小介于两者之间；
	    	for(int i = 0; i < k; i++) {
	    		if (items[i].lessThan(curItem) && curItem.lessThan(items[i+1])) {
	    			// 从 i+1 开始到 curIndex-1，所有元素都向右移动一位 
	    			moveToRight(i+1, k);
	    		}
	    	}
    	}
    }
    
    public void moveToRight(int start, int end){
    	SortItem item = items[end];
    	for (int i = end; i > start; i--) {
			items[i] = items[i - 1];
		}
		items[start] =  item;
    }
    
    public void display() {
        for (SortItem item : items) {
            System.out.print(item.sorter + ", ");
        }
        System.out.println('\n');
    }

}
