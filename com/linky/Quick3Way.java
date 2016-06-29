package com.linky;

public class Quick3Way {

	/**
	 * 用于排列含有大量重复元素的数组 
	 */
	public static void sort(SortItem[] items, int low, int high) {

		if (low >= high) return;
		
		int lt = low;
		int i = low + 1;
		int gt = high;

		SortItem item = items[low].clone();
		for (;i <= gt;) {
			if (items[i].lessThan(item)) {
				exchange(items, lt, i);
				lt++;
				i++;
			} else if (item.lessThan(items[i])) {
				exchange(items, gt, i);
				gt--;
			} else if (item.sorter == items[i].sorter) {
				i++;
			}
		}
		sort(items, low, lt - 1);
		sort(items, gt + 1, high);
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
