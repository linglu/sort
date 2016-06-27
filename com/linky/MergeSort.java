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
    	for (int n = 0; n < N; n++) {
    		System.out.print(items[n].sorter + ", ");
        }
        System.out.println('\n');
    	
    	int outer = (int) Math.ceil(log(N, 2));
    	for (int i = 0; i < outer; i++) {
    		int factor = (int) Math.pow(2, i+1);	// 1, 2, 4, 8, 16, ...... 
    		int j = 0;
 
    		if (factor > N) {
    			factor = factor / 2;
    			System.out.println("1. low : " + 0 + ", mid : " + (factor - 1) + ", high : " + (N - 1));
    			merge(items, 0, factor - 1, N - 1);
    			return;
    		}
 
    		for (; N - j >= factor; j += factor) {
    			int low = j;
    			int mid = (int) (j + (Math.pow(2, i) - 1));
    			int high = (int) (j + (Math.pow(2, i+1) - 1));
    			
    			System.out.println("2. low : " + low + ", mid : " + mid + ", high : " + high);
    			merge(items, low, mid, high);
    		}
    		
    		if (j > 0 && N - j != factor) {
    			if (j + factor - 1 >= N) {
    				System.out.println("3. low : " + j + ", mid : " + j  + ", high : " + (N - 1));
    				merge(items, j, j, N-1);	
    			} else {
    				System.out.println("3. low : " + j + ", mid : " + (j + factor - 1) + ", high : " + (N - 1));
    				merge(items, j, j + (factor - 1), N-1);
    			}
    		}
    		
    		System.out.print("factor : " + factor + " ---> ");
        	for (int n = 0; n < N; n++) {
        		System.out.print(items[n].sorter + ", ");
            }
            System.out.println('\n');
            System.out.println('\n');
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
