
public interface SortBase {
	enum Order {
		Ascending_Order,
		Descending_Order,
	}
	
	/**
	 * @return Comparison result. 0 equals, Plus Larger, Minus Small
	 * Use : Insertion Sort
	 *       Median Sort
	 */
	public int compare(SortBase src);
	
	/**
	 * @return Evaluation value
	 * Please return a small value as the one that comes first in ascending order when aligning.
	 */
	public int evaluationValue();

}
