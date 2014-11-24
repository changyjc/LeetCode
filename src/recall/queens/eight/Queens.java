package recall.queens.eight;

public class Queens{
	public static int noofsol=0; 
	public static void main(String args[])
	{	
		int i,j,k,l,m,n,o,p;
		int[][] x = new int[8][8];
		initialize(x);
		for(i=0;i<8;i++)
			{
			initialize(x);
			x[0][i]=1;
				for(j=0;j<8;j++)
				{	irow(1,x);
					if(check(1,j,x))
					{	
						x[1][j]=1;
						for(k=0;k<8;k++)
						{	irow(2,x);
							if(check(2,k,x))
							{	
								x[2][k]=1;
								for(l=0;l<8;l++)
								{	irow(3,x);
									if(check(3,l,x))
									{	
										x[3][l]=1;
										for(m=0;m<8;m++)
										{	irow(4,x);
											if(check(4,m,x))
											{	
												x[4][m]=1;
												for(n=0;n<8;n++)
												{	irow(5,x);
													if(check(5,n,x))
													{	
														x[5][n]=1;
														for(o=0;o<8;o++)
														{	irow(6,x);
															if(check(6,o,x))
															{	
																x[6][o]=1;
																for(p=0;p<8;p++)
																{	irow(7,x);	
																	if(check(7,p,x))
																		{
																		x[7][p]=1;
																		noofsol++;
																		printboard(x,noofsol);
																		}
			}}}}}}}}}}}}}}
	System.out.println("");
	System.out.println("Total No of solutions is:"+noofsol);
	}
	public static void irow(int i,int[][] arr)
	{
		int m=0;
		for(m=0;m<8;m++)
			arr[i][m]=0;
	}
	public static void initialize(int[][] arr)
	{
		int a=0,b=0;
		for(a=0;a<8;a++)
			for(b=0;b<8;b++)
				arr[a][b]=0;
	}
	public static void printboard(int[][] arr,int i)
	{	int a=0,b=0;
		System.out.println("");
		System.out.println("Solution No" + i);
		for(a=0;a<8;a++)
			{
			System.out.println(" ");
			for(b=0;b<8;b++)
				System.out.print( " " + arr[a][b]);
			}
		
	}
	public static boolean check(int row,int col,int[][] arr)
	{	
		int a=0,b=0,flag=0;
		for(a=0;a<row;a++)
			{
			for(b=0;b<8;b++)
				{
					if(arr[a][b]==1)
					{
						if(!checkforit(a,b,row,col))
						return false; 
						else {flag=1; break;}
					}
				}
			}
		if(flag==1)
		return true;
		else return false;
	}
	public static boolean checkforit(int q,int w,int x,int y)
		{	
		if(q==x) return false;
		else if(w==y) return false;
		else if(q-x == w-y) return false;
		else if(q-x == y-w) return false;
		else return true;
		}
}