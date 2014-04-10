package Search;

import Common.AlgorithmBase;


public class BinarySearch {
	
	/**
	 * @param dst
	 */
	/**
	 * @param dst
	 * @return number of index. -1 is not found target
	 * must have been sorted in ascending order dst
	 */
	public int search(AlgorithmBase[] dst, AlgorithmBase target)
	{
		int left = 0;
		int right = dst.length;
		
		while(left <= right) {
			int middle = (left + right) / 2;
			
			int rc = dst[middle].compare(target); 
			if(rc == 0) {
				return middle;
			}
			else if(rc < 0){
				right = middle - 1;
			}
			else {
				left = middle + 1;
			}
		}
		
		return -1;
	}
}
