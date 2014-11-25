package recall.queens.four;

import java.util.HashSet;
import java.util.Set;

public class Point {
	private int c;
	private int r;
	private final int EIGHT = 8;
	
	public Point(int c, int r){
		this.c = c;
		this.r = r;
	}

	public Set<Point> getForbidenP() {
		Set<Point> ForbidenP = new HashSet<Point>();
		Point p = new Point(c,r);
		//横向禁入点
		for(int i=1; i<=EIGHT; i++){
			Point p_C = new Point(c,i);
			ForbidenP.add(p_C);
		}
		
		//横向禁入点
		for(int j=1; j<=EIGHT; j++){
			Point p_R = new Point(j,r);
			if(!p_R.equals(p)){
				ForbidenP.add(p_R);
			}
		}
		
		//斜向禁入点
		for(int n=1; n<=EIGHT; n++){
			if(c+n <= EIGHT && r+n <= EIGHT){
				ForbidenP.add(new Point(c+n,r+n));
			}
			/*
			if(c-n > 0 && c-n > 0){
				ForbidenP.add(new Point(c-n,r-n));
			}
			
			if(c-n > 0 && c+n <= EIGHT){
				ForbidenP.add(new Point(c-n,r+n));
			}
			
			if(c+n <= EIGHT && c-n > 0){
				ForbidenP.add(new Point(c+n,r-n));
			}
			*/
		}
	
		return ForbidenP;
	}			
	
	public int getC(){
		return c;
	}
	
	public int getR(){
		return r;
	}
}