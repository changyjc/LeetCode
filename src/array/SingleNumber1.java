package array;

public class SingleNumber1 {
	
	private int[] A;
	
	public SingleNumber1(int[] A){
		this.A = A;
	}
	
	public int getSingleNumber() {
		if(A == null || A.length == 0){
			return 0;
			}
		int sn = A[0]; 
		for(int i = 1; i < A.length; i++){
			sn = sn ^ A[i];
			}
		return sn;
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A =  {1,1,2,2,3,4,4,5,5};
		SingleNumber1 sn = new SingleNumber1(A);
		System.out.println(sn.getSingleNumber());
	}

}
