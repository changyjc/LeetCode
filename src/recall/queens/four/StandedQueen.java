package recall.queens.four;

import java.util.Set;

public class StandedQueen {
	private Point p = null;
	private Set<Point> standedQueen = null;
	
	public void add(Point p){
		standedQueen.add(p);
	}
	
	public Set<Point> getStandedQueen(){
		return standedQueen;
	}

}
