package Alignment;

import java.util.Vector;
import Common.AlgorithmBase;



public class SelectionSort {
	
	public static void sort(Vector<AlgorithmBase> dst, AlgorithmBase.Order order)
	{
		for(int i = dst.size() - 1; i >= 1; --i)
		{
			int select = select(dst, 0, i, order);
			if(select != i) {
				// swap
				AlgorithmBase iObj = dst.get(i);
				AlgorithmBase selectObj = dst.get(select);
				dst.set(i, selectObj);
				dst.set(select, iObj);
			}
		}
	}
	
	private static int select(Vector<AlgorithmBase> dst, int left, int right, AlgorithmBase.Order order)
	{
		int select = left;
		for(int i = left; i < right; ++i) {
			if( order == AlgorithmBase.Order.Ascending_Order && dst.get(select).compare(dst.get(i)) > 0
			||	order == AlgorithmBase.Order.Descending_Order && dst.get(select).compare(dst.get(i)) < 0
			){
				select = i;
			}
		}
		
		return select;
	}
}
