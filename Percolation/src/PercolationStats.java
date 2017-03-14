
public class PercolationStats {
	
	private int T;
	private double a[] ;
	
	public PercolationStats(int N, int T)
	{
//		 this.T=T;
		 double pb = 0;
		 a = new double[T];
		 for(int i =0; i< T; i++)
		 {
			 a[i]=0;
		 }

		
	
	}
	
	public double mean()
	{
		return StdStats.mean(a);
	}
	
	public double stddev()
	{
		return StdStats.stddev(a);
	}
	
	public double confidenceLo()
	{
		return ( StdStats.mean(a) - 1.96*StdStats.stddev(a)/Math.sqrt(2));
	}
	
	public double confidenceHi()
	{
		return ( StdStats.mean(a) + 1.96*StdStats.stddev(a)/Math.sqrt(2));
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		int N = Integer.parseInt(args[0]);
		int T = Integer.parseInt(args[1]);
		double pb = 0;
		if(N<=0 || T<=0)
			throw new java.lang.IllegalArgumentException("Size of grid and Number of experiments should be positive");
		
		 PercolationStats s = new PercolationStats(N,T);
			for(int k=0; k<T; k++)
			{
				double count =0;
				Percolation p = new Percolation(N);
				
				while(!p.percolates())
				{
					int i = StdRandom.uniform(N) + 1;
					int j = StdRandom.uniform(N) + 1;
					
					
//					System.out.println("Random Numbers" + i + " " + j + ",");
					
					if(!p.isOpen(i, j))
						{
							p.open(i,j);
							count++;
						}
				}	
				
				int sqN = N*N;
				pb=(double)(count)/(sqN);
				s.a[k]=pb;

			}
			
			
			
//			System.out.println(" N " + N + " T " + T);
			System.out.println("mean " + s.mean());
			System.out.println("stddev " + s.stddev());
			System.out.println("95% confidence Interval " + s.confidenceLo() + " , " + s.confidenceHi());

		 
	}

}
