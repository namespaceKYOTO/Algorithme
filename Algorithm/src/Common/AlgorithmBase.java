package Common;

public interface AlgorithmBase {
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
	 *       Binary Search
	 */
	public int compare(AlgorithmBase src);
	
	/**
	 * @return Evaluation value
	 * Please return a small value as the one that comes first in ascending order when aligning.
	 * unique
	 * Use : Counting Sort
	 */
	public int evaluationValue();
	
	/**
	 * @return 
	 * Please return a small value as the one that comes first in ascending order when aligning.
	 * not unique
	 * Use : Bucket Sort
	 */
	public int orderHash();

}
