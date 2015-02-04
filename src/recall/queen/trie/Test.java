package recall.queen.trie;


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
		root.print();	
		
	}
	

}
