package com.linky;

import java.util.ArrayList;

/**
 * 随机数生成器
 * @author Linky
 */
public class RandomGenerator {

	// 随机数个数
	public static final int RANDOM_COUNT = 10;

	public static void main(String[] args) {
	}
	
	public static SortItem[] generateRandoms() {
		int[] randoms = new int[RANDOM_COUNT];
		
//		getRandomWithoutRepeat(randoms);
		getRandomWithRepeat(randoms);
		
		ArrayList<SortItem> items = new ArrayList<>();
		for (int i = 0; i < RANDOM_COUNT; i++) {
			SortItem item = new SortItem();
			item.sorter = randoms[i];
			items.add(item);
		}
		return items.toArray(new SortItem[0]);
	}

	private static void getRandomWithRepeat(int[] randoms) {
		int j = 0;
		while (j < RANDOM_COUNT) {
			randoms[j++] = nextInt(RANDOM_COUNT/2);
		}
	}
	
	private static void getRandomWithoutRepeat(int[] randoms) {
		int j = 0;
		while (j < RANDOM_COUNT) {
			int nextInt = nextInt(RANDOM_COUNT);
			if (noExistIn(randoms, nextInt)) {
				randoms[j++] = nextInt;
			}
		}
	}

	public static boolean noExistIn(int[] randoms, int nextInt) {
		for (int i = 0; i < randoms.length; i++) {
			if (randoms[i] == nextInt) {
				return false;
			}
		}
		return true;
	}
	
	public static int nextInt(int range) {
		java.util.Random random=new java.util.Random();	// 定义随机类
		int result=random.nextInt(range);				// 返回[0,RANDOM_COUNT)集合中的整数，注意不包括 RANDOM_COUNT
		return result+1;              					// +1后，[0,10)集合变为[1,11)集合，满足要求
	}
}
