package com.linky;

/**
 * Created by Linky on 16-6-25.
 * 最小比较单元
 */
public class SortItem implements Cloneable {

    public int sorter;

    @Override
    public SortItem clone() {
        try {
            return (SortItem) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    public boolean lessThan(SortItem item) {
    	return sorter < item.sorter; 
    }

    public static SortItem[] generateSortItems() {
        SortItem[] sortItems = new SortItem[11];
        int j = 0;
        for (int i = 9; i >= 0; i--) {
            SortItem item = new SortItem();
            item.sorter = i;
            sortItems[j++] = item;
        }
        sortItems[j] = new SortItem();
        return sortItems;
    }
}
