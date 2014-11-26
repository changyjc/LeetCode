package recall.queens.four;

import java.util.HashSet;
import java.util.Set;

public class StandedQueen {
	private Set<Point> standedQueen = new HashSet<Point>();
	
	public void add(Point p){
		standedQueen.add(p);
	}
	
	public Set<Point> getStandedQueen(){
		return standedQueen;
	}

}
