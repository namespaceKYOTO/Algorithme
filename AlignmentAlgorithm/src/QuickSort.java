import java.util.Vector;


public class QuickSort {
	
	public static void sort(Vector<SortBase> dst, SortBase.Order order)
	{
		partition(dst, 0, dst.size() - 1, order);
	}

	private static void partition(Vector<SortBase> dst, int left, int right, SortBase.Order order)
	{
		if(right <= left) { return; }
		
		SortBase pivotObj = null;
		SortBase rightObj = null;
		SortBase storeObj = null;
		SortBase iObj = null;
		
		int pivot = (left + right) / 2;
		pivotObj = dst.get(pivot);
		rightObj = dst.get(right);
		dst.set(pivot, rightObj);
		dst.set(right, pivotObj);
		
		int store = left;
		for(int i = left; i < right; ++i) {
			if(order == SortBase.Order.Ascending_Order && rightObj.compare(dst.get(i)) <= 0
			|| order == SortBase.Order.Descending_Order && rightObj.compare(dst.get(i)) >= 0
			){
				// swap
				iObj = dst.get(i);
				storeObj = dst.get(store);
				dst.set(i, storeObj);
				dst.set(store, iObj);
				++store;
			}
		}

		storeObj = dst.get(store);
		rightObj = dst.get(right);
		dst.set(store, rightObj);
		dst.set(right, storeObj);
		
		
		partition(dst, left, store - 1, order);
		partition(dst, store + 1, right, order);
	}
}
