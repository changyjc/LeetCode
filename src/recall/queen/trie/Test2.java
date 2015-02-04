package recall.queen.trie;

import java.util.ArrayList;
import java.util.Iterator;

public class Test2 {

	/**
	 * @param args
	 */
	public static final int SIZE = 8;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=1; i<=SIZE; i++){
			for(int j=1; j<=SIZE; j++){
				int point;
				point = i*10 + j;
				list.add(point);
			}
		}
		list.remove(Integer.valueOf(24));
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()){
		System.out.println(iterator.next());
		}

		

//		System.out.print(point);

			
	}

}
