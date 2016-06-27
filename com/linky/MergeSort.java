package com.linky;

public class MergeSort {

    // 原地归并操作 
    public static void merge(SortItem[] a, int low, int mid, int high) {
    	int i = low; int j = mid + 1;
    	
    	// 先把待归并的元素放入临时数组中 
    	SortItem[] aux = new SortItem[a.length];
    	for (int k = low; k <= high; k++) {
    		aux[k] = a[k]; 
    	}

    	for (int k = low; k <= high; k++) {
    		if (i > mid) a[k] = aux[j++];
    		else if (j > high) a[k] = aux[i++];
    		else if (aux[i].lessThan(aux[j])) a[k] = aux[i++];
    		else a[k] = aux[j++];
    	}
    }

    // 归并排序算法 
    public static void sort(SortItem[] items, int low, int high) {
    	int mid = low + (high - low) / 2;
    	if (high <= low) {
    		System.out.println(items[low].sorter);
    		return;
    	}
    	sort(items, low, mid);
    	sort(items, mid+1, high);
    	merge(items, low, mid, high);

    	for (int i = low; i <= high; i++) {
    		System.out.print(items[i].sorter + ", ");
        }
        System.out.println('\n');
    }
}
