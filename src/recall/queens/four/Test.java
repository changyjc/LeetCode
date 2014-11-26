package recall.queens.four;

import java.util.Iterator;
import java.util.Set;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
	//	board.print();
		
	//	Point p = new Point(2,4);
	//	board.print();
		
		StandedQueen standedQueen = new StandedQueen();
		Point point = new Point(1,1);
		standedQueen.add(point);
		
		SurvivalPoint survivalPoint = new SurvivalPoint();
		survivalPoint.subtract(point.getForbidenP());
		
		
		while(!survivalPoint.getSurvivalPoint().isEmpty()){
			//取得集合中第一个元素
			Iterator<Point> iterator = survivalPoint.getSurvivalPoint().iterator();
			while(iterator.hasNext()){
				Point p = iterator.next();
				standedQueen.add(p);
				survivalPoint.subtract(p.getForbidenP());
			}
			
		}

	//	standedQueen.add(point);

	//	board.setBoard(survivalPoint.getSurvivalPoint());
		board.setBoard(standedQueen.getStandedQueen());
		board.print();
		
//		if(!survivalPoint.getSurvivalPoint().isEmpty()){
			//取得集合中第一个元素
//			point = (Point) survivalPoint.getSurvivalPoint().toArray()[0];
//			standedQueen.add(point);
//		}
		
		
		
	}

}
