import java.awt.Color;

public class SeamCarver {

	private Picture pic;
	private int[][] picArray;
	// Color[][] clorArray;
	private int w, h;
	private boolean isHrznt = false;

	public SeamCarver(Picture picture) // create a seam carver object based on
										// the given picture
	{
		pic = picture;
		w = pic.width(); // Columns
		h = pic.height(); // Rows
		picArray = new int[h][w];
		// clorArray = new Color[h][w];

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				picArray[i][j] = pic.get(j, i).getRGB();

			}

	}

	public Picture picture() // current picture
	{
		if (isHrznt) {
			picArray = transpose(picArray);
			swap(h, w);
			isHrznt = false;
		}

		Picture curPic = new Picture(w, h);
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				curPic.set(j, i, new Color(picArray[i][j]));
			}

		return curPic;

	}

	public int width() // width of current picture
	{
		if (!isHrznt)
			return w;
		else
			return h;

	}

	public int height() // height of current picture
	{
		if (!isHrznt)
			return h;
		else
			return w;
	}

	public double energy(int x, int y) // energy of pixel at column x and row y
	{
		if (!isHrznt)
			return energy_int(x, y);
		else
			return energy_int(y, x);

	}

	private double energy_int(int x, int y) {

		if (x > w - 1 || x < 0 || y > h - 1 || y < 0)
			throw new IndexOutOfBoundsException("Pass valid index for energy.");
		
		
		if ((y == 0 || x == 0 || y == h - 1 || x == w - 1))
			return 195075;

		else {
			double Rx, Gx, Bx, Ry, Gy, By;
			// Color Cxp = pic.get(j + 1, i);
			// Color Cxm = pic.get(j - 1, i);
			// Color Cyp = pic.get(j, i + 1);
			// Color Cym = pic.get(j, i - 1);

			Color Cxp = new Color(picArray[y][x + 1]);
			Color Cxm = new Color(picArray[y][x - 1]);
			Color Cyp = new Color(picArray[y + 1][x]);
			Color Cym = new Color(picArray[y - 1][x]);

			Rx = (Cxp.getRed() - Cxm.getRed());
			Gx = (Cxp.getGreen() - Cxm.getGreen());
			Bx = (Cxp.getBlue() - Cxm.getBlue());
			Ry = (Cyp.getRed() - Cym.getRed());
			Gy = (Cyp.getGreen() - Cym.getGreen());
			By = (Cyp.getBlue() - Cym.getBlue());

			return (Rx * Rx + Gx * Gx + Bx * Bx + Ry * Ry + Gy * Gy + By * By);
		}
	}

	private int[][] transpose(int[][] org) {
		int[][] transpose = new int[org[0].length][org.length];

		for (int i = 0; i < transpose.length; i++)
			for (int j = 0; j < transpose[0].length; j++) {
				transpose[i][j] = org[j][i];
			}

		return transpose;
	}

	private void swap(int h, int w) {

		this.h = w;
		this.w = h;
	}

	private int[] findSeam() {
		int[] vs = new int[h];
		double[][] distTo = new double[h][w];
		int[][] edgeTo = new int[h][w];

		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				if (i == 0)
					distTo[i][j] = 0;
				else
					distTo[i][j] = Double.POSITIVE_INFINITY;
				edgeTo[i][j] = -1;
			}

		for (int i = 0; i < h - 1; i++) {
			for (int j = 0; j < w; j++) {
				relax(distTo, edgeTo, i, j);
			}
		}

		double minHt = Double.POSITIVE_INFINITY;

		for (int k = 0; k < w; k++) {
			if (distTo[h - 1][k] < minHt) {
				minHt = distTo[h - 1][k];
				vs[h - 1] = k;
			}
		}

		for (int p = h - 1; p > 0; p--) {
			vs[p - 1] = edgeTo[p][vs[p]];
		}

		return vs;
	}

	public int[] findHorizontalSeam() // sequence of indices for horizontal seam
	{
		if (isHrznt)
			return findSeam();
		else {
			isHrznt = true;
			swap(h, w);
			picArray = transpose(picArray);
			return findSeam();
			// swap(h, w);
			// picArray = transpose(TPicArray);
			// isHrznt = false;
		}

	}

	public int[] findVerticalSeam() // sequence of indices for vertical seam
	{
		if (isHrznt) {
			isHrznt = false;
			picArray = transpose(picArray);
			swap(h, w);
			return findSeam();
		}

		else {
			return findSeam();
		}

	}

	private void relax(double[][] distTo, int[][] edgeTo, int i, int j) {
		if (!isHrznt) {
			if (j != 0
					&& (distTo[i + 1][j - 1] > distTo[i][j]
							+ energy(j - 1, i + 1))) {
				distTo[i + 1][j - 1] = distTo[i][j] + energy(j - 1, i + 1);
				edgeTo[i + 1][j - 1] = j;
			}

			if (distTo[i + 1][j] > distTo[i][j] + energy(j, i + 1)) {
				distTo[i + 1][j] = distTo[i][j] + energy(j, i + 1);
				edgeTo[i + 1][j] = j;
			}

			if (j != (w - 1)
					&& (distTo[i + 1][j + 1] > distTo[i][j]
							+ energy(j + 1, i + 1))) {
				distTo[i + 1][j + 1] = distTo[i][j] + energy(j + 1, i + 1);
				edgeTo[i + 1][j + 1] = j;
			}
		}

		else

		{
			if (j != 0
					&& (distTo[i + 1][j - 1] > distTo[i][j]
							+ energy(i + 1, j - 1))) {
				distTo[i + 1][j - 1] = distTo[i][j] + energy(i + 1, j - 1);
				edgeTo[i + 1][j - 1] = j;
			}

			if (distTo[i + 1][j] > distTo[i][j] + energy(i + 1, j)) {
				distTo[i + 1][j] = distTo[i][j] + energy(i + 1, j);
				edgeTo[i + 1][j] = j;
			}

			if (j != (w - 1)
					&& (distTo[i + 1][j + 1] > distTo[i][j]
							+ energy(i + 1, j + 1))) {
				distTo[i + 1][j + 1] = distTo[i][j] + energy(i + 1, j + 1);
				edgeTo[i + 1][j + 1] = j;
			}
		}

	}

	public void removeHorizontalSeam(int[] seam) // remove horizontal seam from
													// current picture
	{
		
		if (seam == null)
			throw new NullPointerException("Pass seam");
		
		if (height() <= 1)
			throw new IllegalArgumentException("Height is less than or equal to 1");
		
		
		if (!isHrznt) {
			isHrznt = true;
			picArray = transpose(picArray);
			swap(h, w);
		}

		removeSeam(seam);
	}

	public void removeVerticalSeam(int[] seam) // remove vertical seam from
												// current picture
	{
		if (seam == null)
			throw new NullPointerException("Pass seam");
		
		if (width() <= 1)
			throw new IllegalArgumentException("Width is less than or equal to 1");
		
		if (isHrznt) {
			isHrznt = false;
			picArray = transpose(picArray);
			swap(h, w);
		}

		removeSeam(seam);
	}

	private void removeSeam(int[] seam) {
		
		if (seam.length != h)
			throw new IllegalArgumentException("Pass seam of valid length");
		
		for (int k = 0; k < h; k++)
		{
			if (seam[k] < 0 || seam[k] > w - 1)
				throw new IllegalArgumentException("Seam contains invalid entry");
			if (k != h - 1)
				if(Math.abs(seam[k + 1] - seam[k]) > 1)
					throw new IllegalArgumentException("Not a valid seam");
		}
		
		int[][] tempArray = new int[picArray.length][picArray[0].length - 1];
		for (int i = 0; i < h; i++) {
			System.arraycopy(picArray[i], 0, tempArray[i], 0, seam[i]);
			System.arraycopy(picArray[i], seam[i] + 1, tempArray[i], seam[i],
					picArray[i].length - seam[i] - 1);
		}

		picArray = tempArray;
		h = picArray.length;
		w = picArray[0].length;
	}

	public static void main(String[] args) {

		Picture p = new Picture(args[0]);
		SeamCarver sc = new SeamCarver(p);
		// sc.picture().show();
		System.out.println("Width " + sc.width());
		System.out.println("Height " + sc.height());
		System.out.println();
		for (int i = 0; i < sc.picArray.length; i++) {
			for (int j = 0; j < sc.picArray[0].length; j++)
				System.out.print(sc.picArray[i][j] + " ");
			System.out.println();
		}

		sc.removeVerticalSeam(sc.findVerticalSeam());
		sc.removeHorizontalSeam(sc.findHorizontalSeam());
		sc.removeVerticalSeam(sc.findVerticalSeam());

		System.out.println();
		System.out.println();
		System.out.println("New Width " + sc.width());
		System.out.println("New Height " + sc.height());
		System.out.println();
		// System.out.println(sc.picArray.toString());

		for (int i = 0; i < sc.picArray.length; i++) {
			for (int j = 0; j < sc.picArray[0].length; j++)
				System.out.print(sc.picArray[i][j] + " ");
			System.out.println();
		}

	}

}