package recall.queens.four;

import java.util.Set;

public class SurvivalPoint {
	
	private static final int EIGHT = 8;
	private Set<Point> survivalPoint = null;

	public SurvivalPoint(){
		for(int i=1; i<=EIGHT; i++){
			for(int j=1; j<=EIGHT; j++){
				survivalPoint.add(new Point(i,j));
			}
		}
	}
	
	public void subtract(Set<Point> subSet){
		survivalPoint.removeAll(subSet);
	}
	
	public Set<Point> getSurvivalPoint(){
		return survivalPoint;
	}
	
}
