import java.util.Vector;


public class MedianSort {
	
	public static void sort(Vector<SortBase> dst, SortBase.Order order)
	{
		partition(dst, 0, dst.size(), order);
	}
	
	/**
	 * @param dst
	 * @param left
	 * @param right
	 */
	private static void partition(Vector<SortBase> dst, int left, int right, SortBase.Order order)
	{
		if(right <= left) { return; }
		
		SortBase mid = dst.get(right);
		int store = left;
		for(int i = left; i < right; ++i) {
			if(order == SortBase.Order.Ascending_Order && mid.compare(dst.get(i)) <= 0
			|| order == SortBase.Order.Descending_Order && mid.compare(dst.get(i)) >= 0
			){
				// swap
				SortBase iObj = dst.get(i);
				SortBase storeObj = dst.get(store);
				dst.set(i, storeObj);
				dst.set(store, iObj);
				++store;
			}
		}
		
		partition(dst, left, store - 1, order);
		partition(dst, store + 1, right, order);
	}
}
