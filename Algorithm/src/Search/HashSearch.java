package Search;

import java.util.Vector;
import Common.AlgorithmBase;


public class HashSearch {
	
	/**
	 * @param dst : hash Group
	 * @param target
	 */
	public static boolean search(Vector<Vector<AlgorithmBase>> dst, AlgorithmBase target)
	{	
		int hashCode = target.hashCode();
		if(dst.get(hashCode) == null) {
			return false;
		}
		if(dst.get(hashCode).indexOf(target) >= 0) {
			return true;
		}
		return false;
	}
	
	public static Vector<Vector<AlgorithmBase>> createHashGroup(AlgorithmBase[] dst, int hashCodeMax)
	{
		Vector<Vector<AlgorithmBase>> ret = new Vector<Vector<AlgorithmBase>>();
		for (AlgorithmBase algorithmBase : dst) {
			int hashCode = algorithmBase.hashCode();
			if(ret.get(hashCode) == null) {
				ret.set(hashCode, new Vector<AlgorithmBase>());
			}
			ret.get(hashCode).add(algorithmBase);
		}
		return ret;
	}
}
