package recall.queens.four;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Board board = new Board();
	//	board.print();
		
		Point p = new Point(3,5);
		board.setBoard(p.getForbidenP());
		board.print();

	}

}
