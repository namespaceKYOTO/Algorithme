import java.util.Vector;


public class InsertionSort {
	enum Order {
		Ascending_Order,
		Descending_Order,
	}
	
	public void sort(Vector<Comparison> dst, Order order)
	{
		for(int now = 1; now < dst.size(); ++now)
		{
			int old = now - 1;
			while(old >= 0)
			{
				if(	order == Order.Ascending_Order && dst.get(now).compare(dst.get(old)) <= 0
				||	order == Order.Descending_Order && dst.get(now).compare(dst.get(old)) >= 0
				){
					// replacement
					Comparison oldObj = dst.get(old);
					Comparison nowObj = dst.get(now);
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
