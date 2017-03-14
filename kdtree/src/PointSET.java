
public class PointSET 
{
	private SET<Point2D> st;
		
	public PointSET()
	{
		st = new SET<Point2D>();
	}
	
	public boolean isEmpty()
	{
		return st.isEmpty();
	}
	
	public int size()
	{
		return st.size();
	}
	
	public void insert(Point2D p)
	{
		if (p == null)
			throw new NullPointerException("Pass Point parameter");
		
		st.add(p);
	}
	
	public boolean contains(Point2D p)
	{
		if (p == null)
			throw new NullPointerException("Pass Point paramerter");
		
		return st.contains(p);
	}
	
	public void draw()
	{
		 StdDraw.setPenRadius(0.01); 
		 
		 for (Point2D p : st)
			 p.draw();
		 
		 StdDraw.show();		 
		 StdDraw.setPenRadius();
	}
	
	public Iterable<Point2D> range (RectHV rect)
	{
		SET<Point2D> rg = new SET<Point2D>();
		
		for (Point2D p : st)
		{
			if (p.x() >= rect.xmin() && p.x() <= rect.xmax() && p.y() >= rect.ymin() && p.y() <= rect.ymax())
				rg.add(p);
		}
		
		return rg;
		
		
	}
	
	public Point2D nearest(Point2D p)
	{
		double ds = 1.0;
		Point2D np = new Point2D(0.0, 0.0);
		
		for (Point2D sp : st)
		{
			double pds = (Math.pow((sp.x() - p.x()), 2) + Math.pow((sp.y() - p.y()), 2));
			
			if(pds <= ds)
			{
				ds = pds;
				np = sp;
			}
		}
		
		return np;
	}
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		PointSET ps = new PointSET();
		
		System.out.println(ps.isEmpty());
		System.out.println(ps.size());
		ps.insert(new Point2D(0.5, 0.4));
		ps.insert(new Point2D(0.6, 0.2));
		System.out.println(ps.contains(new Point2D(0.5, 0.4)));
		for(Point2D p : ps.range(new RectHV(0.55, 0.1, 0.68, 0.5)))
			System.out.println(p);
		System.out.println(ps.nearest(new Point2D(0.5, 0.5)));
		
		

	}

}
