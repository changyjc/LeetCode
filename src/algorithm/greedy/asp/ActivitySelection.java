package algorithm.greedy.asp;
/*****************************************************************
 * 问题描述
 * 活动选择问题是《算法导论》里面关于贪心算法的第一个问题。这个问题是这样的：
 * 有一组活动，每个活动都有一个开始时间Si和结束时间Fi。如下图:
 * i	1	2	3	4	5	6	7	8	9	10	11
 * si	1	3	0	5	3	5	6	8	8	2	12
 * fi	4	5	6	7	9	9	10	11	12	14	16
 * 每个活动都共享同一个公共的资源（比如教室等），所以同一时间只能有一个活动。
 * 问题就是要在指定的时间内让举办的活动数量做大
 ******************************************************************
 * 伪代码
 *  RECURSIVE-ACTIVITY-SELECTOR(s,f,k,n)
 *  1 m = k + 1
 *  2 while m <= n and s[m] < f[k]	// find the first activity in Sk to finish
 *  3		m = m+1
 *  4 if m <= n
 *  5 	return {am} and RECURSIVE-ACTIVITY-SELECTOR(s,f,k,n)
 *  6 else return 0;
 *  /////////////////////////////////
 *  GREEDY-ACTIVITY-SELECTOR(s,f) 
 *  1 n = s.length
 *  2 A = {a1}
 *  3 k = 1
 *  4 for m = 2 to n
 *  5 	if s(m) >= (k)
 *  6 		A = A and {am}
 *  7		k = m
 *  8 return A
 */


public class ActivitySelection {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
