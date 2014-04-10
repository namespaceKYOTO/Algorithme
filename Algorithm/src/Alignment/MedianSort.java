package Alignment;
import Common.AlgorithmBase;

import java.util.Vector;


public class MedianSort {
	
	public static void sort(Vector<AlgorithmBase> dst, AlgorithmBase.Order order)
	{
		partition(dst, 0, dst.size() - 1, order);
	}
	
	/**
	 * @param dst
	 * @param left
	 * @param right
	 */
	private static void partition(Vector<AlgorithmBase> dst, int left, int right, AlgorithmBase.Order order)
	{
		if(right <= left) { return; }
		
		AlgorithmBase mid = dst.get(right);
		int store = left;
		for(int i = left; i < right; ++i) {
			if(order == AlgorithmBase.Order.Ascending_Order && mid.compare(dst.get(i)) <= 0
			|| order == AlgorithmBase.Order.Descending_Order && mid.compare(dst.get(i)) >= 0
			){
				// swap
				AlgorithmBase iObj = dst.get(i);
				AlgorithmBase storeObj = dst.get(store);
				dst.set(i, storeObj);
				dst.set(store, iObj);
				++store;
			}
		}
		
		partition(dst, left, store - 1, order);
		partition(dst, store + 1, right, order);
	}
}
