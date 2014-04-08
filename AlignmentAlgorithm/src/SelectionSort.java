import java.util.Vector;


public class SelectionSort {
	
	public static void sort(Vector<SortBase> dst, SortBase.Order order)
	{
		for(int i = dst.size() - 1; i >= 1; --i)
		{
			int select = select(dst, 0, i, order);
			if(select != i) {
				// swap
				SortBase iObj = dst.get(i);
				SortBase selectObj = dst.get(select);
				dst.set(i, selectObj);
				dst.set(select, iObj);
			}
		}
	}
	
	private static int select(Vector<SortBase> dst, int left, int right, SortBase.Order order)
	{
		int select = left;
		for(int i = left; i < right; ++i) {
			if( order == SortBase.Order.Ascending_Order && dst.get(select).compare(dst.get(i)) > 0
			||	order == SortBase.Order.Descending_Order && dst.get(select).compare(dst.get(i)) < 0
			){
				select = i;
			}
		}
		
		return select;
	}
}
