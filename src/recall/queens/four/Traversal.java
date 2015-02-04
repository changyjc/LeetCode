package recall.queens.four;
/**
 * 
 * 1.main
 * 2.8*8 traversal
 * 3.Survival Point traversal
 * 
 *
 */
public class Traversal {
	
	private static final int EIGHT = 8;

	public static void main(String[] args) {
		int i;
		int j;
		StandedQueen standedQueen = new StandedQueen();

		
		for(i=1; i<=EIGHT; i++){
			for(j=1; j<=EIGHT; j++){
				Point point = new Point(i,j);
				standedQueen.add(point);
				SurvivalPoint survivalPoint = new SurvivalPoint();
				
				
				survivalPoint.subtract(point.getForbidenP());
				
				while(!survivalPoint.getSurvivalPoint().isEmpty()){
					//取得集合中第一个元素
					point = (Point) survivalPoint.getSurvivalPoint().toArray()[0];
					standedQueen.add(point);
					survivalPoint.subtract(point.getForbidenP());
				}
				
				

			}
		}
		

	}
	
	public static Point nextPoint(SurvivalPoint survivalPoint){
		return (Point) survivalPoint.getSurvivalPoint().toArray()[0];
	}
	
	
	

}
