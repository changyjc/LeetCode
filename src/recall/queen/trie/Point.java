package recall.queen.trie;

import java.util.HashSet;
import java.util.Set;

public class Point {
	private int c;
	private int r;
	private final int EIGHT = 8;
	Set<Point> ForbidenP = new HashSet<Point>();
	
	//一个两位整数的构造函数
	public Point(int p) {
		this.c = p/10;
		this.r = p%10;
	}
	
	//两个数的构造函数
	public Point(int c, int r){
		this.c = c;
		this.r = r;
	}
	


	public boolean equals(Point p){
		if(this.c == p.c && this.r == p.r){
			return true;
		}else{
			return false;
		}
	}
	public int getC(){
		return c;
	}
	
	public int getR(){
		return r;
	}
}