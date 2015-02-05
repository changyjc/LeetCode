package recall.queen.trie;

import java.util.Iterator;


public class Test {

	/**
	 * @param args
	 */
	public static final int SIZE = 8;
	public static void main(String[] args) {

		TreeNode root = new TreeNode(0,0);
		
		for(int i=1; i<=SIZE; i++){
			for(int j=1; j<=SIZE; j++){
				int point;
				point = i*10 + j;
//				System.out.print(point);
				root.add(new TreeNode(point));
			}
		}
//		root.print();
//		for(int i = 1; i<= 9; i++){
			int i = 1;
			root.solve(i);
			System.out.println("第" + i + "层解的个数：" + root.no7);
//		}

	}

}
