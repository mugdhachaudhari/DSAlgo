
public class KdTree
{
	private Node root, current;
	private int N, cmp;
	private boolean lvl_switch, drawn;
	
	private static class Node
	{
		private Point2D p;
		private RectHV rect;
		private Node lb;
		private Node rt;
//		private int count;
		
		public Node(Point2D p)
		{
			this.p = p;
		}
	}
		
	public KdTree()
	{
		lvl_switch = false;
		drawn = false;
	}
	
	public boolean isEmpty()
	{
		return N == 0;
	}
	
	public int size()
	{
		return N;
	}
	

	
	public void insert(Point2D p)
	{
		if (p == null)
			throw new NullPointerException("Pass Point parameter");
		
		root = insert(p, root);
	}
	
	private Node insert(Point2D p, Node n)
	{

		double xmin, xmax, ymin, ymax;
		drawn = false;
		
		while (n != null)
		{
			lvl_switch = !lvl_switch;
			
			if (lvl_switch == true)
			{
				if (p.x() < n.p.x())
				{
					n.lb = insert(p, n.lb);
					
					if(drawn == false)
					{
						xmin = n.rect.xmin();
						ymin = n.rect.ymin();
						xmax = n.p.x();
						ymax = n.rect.ymax();
						n.lb.rect = new RectHV(xmin, ymin, xmax, ymax);
						current = n.lb;
						draw();
						drawn = true;
					}
				}
				else 
				{
					n.rt = insert(p, n.rt);
					if(drawn == false)
					{
						xmin = n.p.x();
						ymin = n.rect.ymin();
						xmax = n.rect.xmax();
						ymax = n.rect.ymax();
						n.rt.rect = new RectHV(xmin, ymin, xmax, ymax);
						current = n.rt;
						
						draw();
						drawn = true;
					}
				}
			}
			
			else				
			{
				if (p.y() < n.p.y())
				{
					n.lb = insert(p, n.lb);
					if(drawn == false)
					{
						xmin = n.rect.xmin();
						ymin = n.rect.ymin();
						xmax = n.rect.xmax();
						ymax = n.p.y();
						n.lb.rect = new RectHV(xmin, ymin, xmax, ymax);
						current = n.lb;
						draw();
						drawn = true;
					}
				}
				else
				{
					n.rt = insert(p, n.rt);
					if(drawn == false)
					{
						xmin = n.rect.xmin();
						ymin = n.p.y();
						xmax = n.rect.xmax();
						ymax = n.rect.ymax();
						n.rt.rect = new RectHV(xmin, ymin, xmax, ymax);
						current = n.rt;
						draw();
						drawn = true;
					}
				}
			}
		}
			
			
		if (n == null)
		{
			N++;
			return new Node(p);
		}		
			
			
		
					
	}
	
	public boolean contains(Point2D p)
	{
		if (p == null)
			throw new NullPointerException("Pass Point paramerter");
		
		
	}
	
	public void draw()
	{
		 StdDraw.setPenRadius(0.01); 
		 
		
		 
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
