package Alignment;
import Common.AlgorithmBase;

import java.util.Vector;


public class InsertionSort {
	
	public static void sort(Vector<AlgorithmBase> dst, AlgorithmBase.Order order)
	{
		for(int now = 1; now < dst.size(); ++now)
		{
			int old = now - 1;
			while(old >= 0)
			{
				if(	order == AlgorithmBase.Order.Ascending_Order && dst.get(now).compare(dst.get(old)) <= 0
				||	order == AlgorithmBase.Order.Descending_Order && dst.get(now).compare(dst.get(old)) >= 0
				){
					// replacement
					AlgorithmBase oldObj = dst.get(old);
					AlgorithmBase nowObj = dst.get(now);
					dst.set(old, nowObj);
					dst.set(now, oldObj);
				}
				else {
					break;
				}
				
				--old;
			}
		}
	}
}
