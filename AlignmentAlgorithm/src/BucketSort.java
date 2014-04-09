import java.util.Vector;


public class BucketSort {

	public static void sort(Vector<SortBase> dst, SortBase.Order order, int maxHashValue)
	{
		Vector<Vector<SortBase>> bucket = new Vector<Vector<SortBase>>(maxHashValue);
		for (SortBase sb : dst) {
			int hash = ((order == SortBase.Order.Ascending_Order) ? sb.orderHash() : maxHashValue - sb.orderHash());
			if(bucket.get(hash) == null) {
				bucket.set(hash, new Vector<SortBase>());
			}
			
			bucket.get(hash).add(sb);
		}
		
		extract(dst, bucket, order);
	}
	
	private static void extract(Vector<SortBase> dst, Vector<Vector<SortBase>> bucket, SortBase.Order order)
	{
		int i = 0;
		for (Vector<SortBase> vector : bucket) {
			if(vector != null) {
				InsertionSort.sort(vector, order);
				for (SortBase sortBase : vector) {
					dst.set(i, sortBase);
					++i;
				}
			}
		}
	}
}
