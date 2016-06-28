package com.linky;

public class MergeSort {

    // 原地归并操作 
    public static void merge(SortItem[] a, int low, int mid, int high) {
    	
    	// 判断是否已经有序
//    	if (a[mid].lessThan(a[mid+1])) return;
    	
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

    // 自底向上归并排序算法 
    public static void BuSort(SortItem[] items) {
    	int N = items.length;
    	for (int subSize = 1; subSize < N; subSize *= 2) {
    		for (int low = 0; low < N - subSize; low += 2*subSize) {
    			merge(items, low, low + subSize - 1, Math.min(low + 2*subSize-1,  N - 1));
    		}
    	}
    } 

    public static double log(double value, double base) {
    	return Math.log(value) / Math.log(base);
    }

    // 自顶向下归并排序算法 
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
