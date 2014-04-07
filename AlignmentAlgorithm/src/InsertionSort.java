import java.util.Vector;


public class InsertionSort {
	
	public void sort(Vector<SortBase> dst, SortBase.Order order)
	{
		for(int now = 1; now < dst.size(); ++now)
		{
			int old = now - 1;
			while(old >= 0)
			{
				if(	order == SortBase.Order.Ascending_Order && dst.get(now).compare(dst.get(old)) <= 0
				||	order == SortBase.Order.Descending_Order && dst.get(now).compare(dst.get(old)) >= 0
				){
					// replacement
					SortBase oldObj = dst.get(old);
					SortBase nowObj = dst.get(now);
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
