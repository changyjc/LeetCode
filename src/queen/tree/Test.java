package queen.tree;

import java.util.Collection;
import java.util.Iterator;

import recall.queens.four.Point;

public class Test {

	/**
	 * @param args
	 */
	public static final int SIZE = 4;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BTree<Integer> tree = new BTree<Integer>();
		
		for(int i=1; i<=SIZE; i++){
			for(int j=1; j<=SIZE; j++){
				int point;
				point = i*10 + j;
//				System.out.print(point);
				tree.add(point);
			}
//			System.out.println();
		}
		BTree.Node<Integer>.
		Collection<Integer> col = tree.toCollection();
		Iterator<Integer> iterator = col.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}

	}

}
