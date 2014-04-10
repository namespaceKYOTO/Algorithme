package Alignment;

import java.util.Vector;

import Common.AlgorithmBase;


public class CountingSort {
	
	/**
	 * @param dst
	 * @param order
	 * @param evaluationValueMax :
	 */
	public static void srot(Vector<AlgorithmBase> dst, AlgorithmBase.Order order, int evaluationValueMax)
	{
		Vector<Vector<AlgorithmBase>> work = new Vector<Vector<AlgorithmBase>>(evaluationValueMax);
		
		for (AlgorithmBase sb : dst) {
			int idx = ((order == AlgorithmBase.Order.Ascending_Order) ? sb.evaluationValue() : evaluationValueMax - sb.evaluationValue());
			if(work.get(idx) == null) {
				work.set(idx, new Vector<AlgorithmBase>());
			}
			
			work.get(idx).add(sb);
		}
		
		// sort
		int index = 0;
		for (Vector<AlgorithmBase> vector : work) {
			for (AlgorithmBase sortBase : vector) {
				dst.set(index, sortBase);
				++index;
			}
		}
	}
}
