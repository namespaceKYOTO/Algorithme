package Alignment;
import Common.AlgorithmBase;

import java.util.Vector;


public class HeapSort {

	public static void sort(Vector<AlgorithmBase> dst, AlgorithmBase.Order order)
	{
		build(dst, order);
		for(int i = dst.size() - 1; i > 0; --i) {
			AlgorithmBase zeroObj = dst.get(0);
			AlgorithmBase iObj = dst.get(i);
			dst.set(i, zeroObj);
			dst.set(0, iObj);

			heapify(dst, order, i, dst.size());
		}
	}
	
	private static void build(Vector<AlgorithmBase> dst, AlgorithmBase.Order order)
	{
		for(int i = dst.size() / 2 - 1; i >= 0; --i) {
			heapify(dst, order, i, dst.size());
		}
	}
	
	private static void heapify(Vector<AlgorithmBase> dst, AlgorithmBase.Order order, int idx, int max)
	{
		int left = idx * 2 + 1;	// index number of left children 
		int right = idx * 2 + 2;// index number of right children
		
		// pick the smallest or the largest
		int select = idx;
		if(left < max) {
			if(order == AlgorithmBase.Order.Ascending_Order && dst.get(left).compare(dst.get(idx)) < 0 
			|| order == AlgorithmBase.Order.Descending_Order && dst.get(left).compare(dst.get(idx)) > 0
			){
				select = left;
			}
		}
		else {
			select = idx;
		}
		if(right < max) {
			if(order == AlgorithmBase.Order.Ascending_Order && dst.get(right).compare(dst.get(select)) < 0 
			|| order == AlgorithmBase.Order.Descending_Order && dst.get(right).compare(dst.get(select)) > 0
			){
				select = right;
			}
		}
		
		if(select != idx) {
			// swap
			AlgorithmBase selectObj = dst.get(select);
			AlgorithmBase idxObj = dst.get(idx);
			dst.set(select, idxObj);
			dst.set(idx, selectObj);
			
			// correct the order of the child
			heapify(dst, order, select, max);
		}
	}
}
