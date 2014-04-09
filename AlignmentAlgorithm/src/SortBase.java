
public interface SortBase {
	enum Order {
		Ascending_Order,
		Descending_Order,
	}
	
	/**
	 * @return Comparison result. 0 this == src, Plus  this > src, Minus  this < src
	 * Use : Insertion Sort
	 *       Median Sort
	 *       Quick Sort
	 *       Selection Sort
	 *       Heap Sort
	 */
	public int compare(SortBase src);
	
	/**
	 * @return Evaluation value
	 * Please return a small value as the one that comes first in ascending order when aligning.
	 * Use : Counting Sort
	 */
	public int evaluationValue();

}
