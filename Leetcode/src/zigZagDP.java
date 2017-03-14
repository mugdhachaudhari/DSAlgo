
public class zigZagDP {

	private int lenZig(int[] nums)
	{
		int[] signs = new int[nums.length];
		int[] lenZ = new int[nums.length];
		return lenZigRec(nums, signs, lenZ);
	}
	
	
	private int lenZigRec(int[] nums, int[] signs, int[] lenZ)
	{
		
		int maxLength = 1;
		if (nums.length > 0)
			{
				signs[0] = 2;
				lenZ[0] = 1;
			}
		else return 0;
		
		if (nums.length > 1)
		{
			signs[1] = findSign(nums[0], nums[1]);
			if (signs[1] == 0)
				return 1;
			lenZ[1] = 2;
			maxLength = 2;
			
		}
		
		
		for (int i = 2; i < nums.length; i++)
		{
			int max = lenZ[i];
			int maxSign = signs[i];
			
			signs[i] = findSign(nums[0], nums[i]);
			if (lenZ[0] + 1 > max)
			{
				max = lenZ[0] + 1;
				maxSign = signs[i];
			}
			
			for (int j = i - 1; j > 0; j-- )
			{
								
				signs[i] = findSign(nums[j], nums[i]);
				if (Math.abs(signs[i] - signs[j]) == 2)
				{
					if (lenZ[j] + 1 > max)
					{
						max = lenZ[j] + 1;
						maxSign = signs[i];
						
					}
				}
				
			}
			
			signs[i] = maxSign;
			lenZ[i] = max;
			if (max > maxLength)
				maxLength = max;
		}
		return maxLength;
	}
	
	private int findSign(int a, int b)
	{
		if (b - a < 0)
			return -1;
		else if (b - a > 0)
			return 1;
		else return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		zigZagDP zd = new zigZagDP();
		int[] nums  = {1, 2, 1, 4, 5, 6, 2, 7, 4, 2};
		System.out.println(zd.lenZig(nums));
	}

}
