package recall.queens.four;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SurvivalPoint {
	
	private static final int EIGHT = 8;
	private Set<Point> survivalPoint = new HashSet<Point>();

	public SurvivalPoint(){
		for(int i=1; i<=EIGHT; i++){
			for(int j=1; j<=EIGHT; j++){
				survivalPoint.add(new Point(i,j));
			}
		}
	}
	
	public void subtract(Set<Point> subSet){
		Iterator<Point> iterator = subSet.iterator();
		while(iterator.hasNext()){
			subtract(iterator.next());
		}
	}
	

	
	public void subtract(Point p){
		Point delPoint = null;
		Iterator<Point> iterator = survivalPoint.iterator();
		while(iterator.hasNext()){
			Point thisPoint = iterator.next();
			if(thisPoint.equals(p)){
				delPoint = thisPoint;
			}
		}
		survivalPoint.remove(delPoint);
	}
	
	
	public Set<Point> getSurvivalPoint(){
		return survivalPoint;
	}
}
