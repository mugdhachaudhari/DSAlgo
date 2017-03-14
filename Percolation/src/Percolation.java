
public class Percolation {

	private int twod[][];
	private int N;
	private WeightedQuickUnionUF q = null;
//	public int count;
	
	public Percolation(int N)
	{
		twod=new int[N+1][N+1];
		this.N = N;
		
		q = new WeightedQuickUnionUF(N*N+2);
		
		int sqN = N*N;
		int i=0;
		int j=0;
				
		for(i=1; i<=N; i++)
			for(j=1; j<=N; j++)
			{
				twod[i][j]=1;
				
				int k = twodto1d(i,j);
				
				if(i==1)  //Connect all top row sites with top virtual site
					q.union(sqN,k);
					
				if(i==N)
					q.union(sqN+1,k); //Connect all top row sites with top virtual site
				
								
			}
//		System.out.println("Count " + count);
//		while(!percolates())
//		{
//			i = rnd(N);
//			j = rnd(N);
////			System.out.println("Random Numbers" + i + " " + j + ",");
//			
//			if(!isOpen(i, j))
//				{
//					open(i,j);
//					count++;
//				}
//		}	

					
	}
	
	private int twodto1d(int i, int j)
	{
		return (i-1)*N + (j-1);
	}
	
	private int rnd(int N)
	{
		return StdRandom.uniform(N) + 1;
	}
	
	private void chckIndices(int i) throws IndexOutOfBoundsException
	{
		if (i <= 0 || i > N)
			throw new IndexOutOfBoundsException("row index out of bounds");		
	}

	
	public void open(int i, int j)
	{
		chckIndices(i);
		chckIndices(j);
				
		if(! isOpen(i,j))
		{
			twod[i][j]=0;
			
			if(i!=1)
				if(isOpen(i-1, j))
				{
					q.union(twodto1d(i, j),twodto1d(i-1, j));
				}
			
			if (j!=1) 
				if(isOpen(i, j-1))
				{
					q.union(twodto1d(i, j),twodto1d(i, j-1));
				}
					
			if (i!=N)
				if(isOpen(i+1, j))
				{
					q.union(twodto1d(i, j),twodto1d(i+1, j));
				}
			
			if (j!=N)
				if(isOpen(i, j+1))
				{
					q.union(twodto1d(i, j),twodto1d(i, j+1));
				}
		}	
		
		
	}
	
	public boolean isOpen(int i, int j)
	{
		return twod[i][j] == 0;
	}
	
	public boolean isFull(int i, int j)
	{
		return twod[i][j] == 1;
	}
	
	public boolean percolates()
	{	
		return q.connected(N*N, N*N+1);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int N = Integer.parseInt(args[0]);
		
		if(N<=0)
			throw new java.lang.IllegalArgumentException("Size of grid should be positive");
		
		Percolation p = new Percolation(N);
		
		while(!p.percolates())
		{
			int i = p.rnd(N);
			int j = p.rnd(N);
//			System.out.println("Random Numbers" + i + " " + j + ",");
			
			if(!p.isOpen(i, j))
				{
					p.open(i,j);
//					count++;
				}
		}	
		System.out.println("Percolates");

		

	}

}
