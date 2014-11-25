package recall.queens.four;

import java.util.Set;

public class Board {
	private int i ;
	private int j ;
	private String[][] board = new String[8][8];
	
	public Board(){
		for(i = 0; i < 8; i++){
			for(j = 0; j < 8; j++){
				board[i][j] = " *";
			}
		}
	}
	
	public void setBoard(Point p){
		board[p.getC()-1][p.getR()-1] = " Q";
	}
	
	public void setBoard(Set<Point> set){
		for(Point p:set){
			setBoard(p);
		}
	}
	
	public void print(){
		for(i = 0; i < 8; i++){
			for(j = 0; j < 8; j++){
				System.out.print(board[i][j]);
			}
			System.out.print("\n");
		}
	}
}
