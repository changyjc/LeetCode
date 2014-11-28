package queen.tree2;

import java.util.ArrayList;
import java.util.Iterator;

import recall.queens.four.Point;

public class Test {

	/**
	 * @param args
	 */
	public static final int SIZE = 4;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		
		for(int i=1; i<=SIZE; i++){
			for(int j=1; j<=SIZE; j++){
				int point;
				point = i*10 + j;
//				System.out.print(point);
				root.addChildNode(new TreeNode(point));
			}
//			System.out.println();
		}
		System.out.println(root.getChildList().get(15).getNodeName());
		TreeNode No15 = root.getChildList().get(15);
		Iterator<Integer> iterator = No15.getParentSurvial().iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}
	
	public static ArrayList<Integer> clear(Integer id, ArrayList<Integer> survivalPoint){
		ArrayList<Integer> clearSuival = new ArrayList<Integer>();
		//横向禁入点
		for(int i=1; i<=SIZE; i++){
			int c = id/10;
			if(survivalPoint.contains(c*10+i)){
				survivalPoint.remove(c*10+i);
			}
		}
		return clearSuival;
	}

}
