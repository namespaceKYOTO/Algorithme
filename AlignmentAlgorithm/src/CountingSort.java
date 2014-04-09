import java.util.Vector;


public class CountingSort {
	
	/**
	 * @param dst
	 * @param order
	 * @param evaluationValueMax :
	 */
	public static void srot(Vector<SortBase> dst, SortBase.Order order, int evaluationValueMax)
	{
		Vector<Vector<SortBase>> work = new Vector<Vector<SortBase>>(evaluationValueMax);
		
		for (SortBase sb : dst) {
			int idx = ((order == SortBase.Order.Ascending_Order) ? sb.evaluationValue() : evaluationValueMax - sb.evaluationValue());
			if(work.get(idx) == null) {
				work.set(idx, new Vector<SortBase>());
			}
			
			work.get(idx).add(sb);
		}
		
		// sort
		int index = 0;
		for (Vector<SortBase> vector : work) {
			for (SortBase sortBase : vector) {
				dst.set(index, sortBase);
				++index;
			}
		}
	}
}
