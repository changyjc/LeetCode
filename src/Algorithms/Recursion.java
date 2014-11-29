package Algorithms;

public class Recursion {

	/**
	 * 最简单的递归
	 * 自己调用自己
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		print();	
//		plus(2);	
//		yin(3);
		System.out.println(f(4));
	}
	
	public static void print(){
		System.out.println("zombie");
		print();
	}
	
	public static int plus(int x){
		System.out.println(x);
		return plus(++x);
	}
	
	public static int yin(int f){
		
		System.out.println("It's yin" + f);
		return yang(++f);
	}
	
	public static int yang(int m){
		System.out.println("It's yang" + m);
		return yin(++m);
	}
	
	public static float f(float n){
		float x;
		if (n>2){
			System.out.println(n);
			n = (float) (n*0.9999);
			x = 1/n + 1/n*(f(n));
			System.out.println(x);
			return x;


		}else{
			return 1;
		}

	}

}
