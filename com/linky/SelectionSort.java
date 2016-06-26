package com.linky;

/**
 * Created by Linky on 16-6-25.
 */
public class SelectionSort {

    private SortItem[] items;

    public SelectionSort(SortItem[] items) {
        this.items = items;
    }

    /**
     * 选择排序算法
     */
    public void sort() {
        // 找到数组中最小的那个，然后和数组中的第一个元素交换位置；
        // 在剩下的元素中找到最小的，然后和数组中的第二个元素交换位置；

        assert items.length > 0;
        for (int j = 0; j < items.length; j++) {
            int smallestIndex = j;
            for (int i = smallestIndex + 1; i < items.length; i++) {
                if (items[i].sorter < items[smallestIndex].sorter) {
                    smallestIndex = i;
                }
            }
            exchange(items[smallestIndex], items[j]);
        }
    }

    private void exchange(SortItem item, SortItem item1) {
        int sorter = item.sorter;
        item.sorter = item1.sorter;
        item1.sorter = sorter;
    }

    public void display() {
        for (SortItem item : items) {
            System.out.print(item.sorter + ", ");
        }

        System.out.println('\n');
    }
}
