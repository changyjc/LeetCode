package bitmap;

import java.util.BitSet;

public class BitmapDemo1 {

	/**
	 * 使用Bitmap保存元素是否存在的状态
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A =  {1,1,20,2,3,4,4,5,5,5};
        BitSet bitSet = new BitSet();
        for(int i:A){
        	Boolean flag = bitSet.get(i)^true; //异或，如有重复，标志位置0
            bitSet.set(i, flag);
        }
        
        System.out.println(bitSet.length());
        
        for(int i=1;i<=bitSet.length();i++){
        	if(bitSet.get(i)){
        		System.out.println(i);
        	}
        }

	}

}
