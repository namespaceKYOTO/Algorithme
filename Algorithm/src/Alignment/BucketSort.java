package Alignment;

import Common.AlgorithmBase;
import java.util.Vector;

public class BucketSort {

	public static void sort(Vector<AlgorithmBase> dst, AlgorithmBase.Order order, int maxHashValue)
	{
		Vector<Vector<AlgorithmBase>> bucket = new Vector<Vector<AlgorithmBase>>(maxHashValue);
		for (AlgorithmBase sb : dst) {
			int hash = ((order == AlgorithmBase.Order.Ascending_Order) ? sb.orderHash() : maxHashValue - sb.orderHash());
			if(bucket.get(hash) == null) {
				bucket.set(hash, new Vector<AlgorithmBase>());
			}
			
			bucket.get(hash).add(sb);
		}
		
		extract(dst, bucket, order);
	}
	
	private static void extract(Vector<AlgorithmBase> dst, Vector<Vector<AlgorithmBase>> bucket, AlgorithmBase.Order order)
	{
		int i = 0;
		for (Vector<AlgorithmBase> vector : bucket) {
			if(vector != null) {
				InsertionSort.sort(vector, order);
				for (AlgorithmBase sortBase : vector) {
					dst.set(i, sortBase);
					++i;
				}
			}
		}
	}
}
