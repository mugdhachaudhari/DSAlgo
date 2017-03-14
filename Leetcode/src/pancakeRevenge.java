import java.util.HashSet;
import java.util.Scanner;


public class pancakeRevenge {

	private int happy(String s)
	{
		char[] ch = s.toCharArray();
		int n = s.length();
		int ln = n;
		boolean minusFound = false;
		int prevMinus = -1;
		int count = 0;
		HashSet<Integer> ind = new HashSet<Integer>();
//		boolean 
		while(true)
		{
			for (int i = 0; i < ln; i++)
			{
				if(!minusFound)
				{
					if(ch[i] == '+')
					{
						ind.add(i);
//						ch[i] = '-';
					}
					else
						minusFound = true;
						prevMinus = i;
				}
				else
				{
					if(ch[i] == '-' && i > prevMinus)
					{
						prevMinus = i;
					}
				}
			}
			
			if (prevMinus == -1)
			{
				System.out.println(String.valueOf(ch));
				return count;
			}
			else
			{
				count++;
				for(int i : ind)
				{
					ch[i] = '-';
				}
				ind = new HashSet<Integer>();
				for (int j = 0; j <= prevMinus/2; j++)
				{
					swap(ch, j, prevMinus - j);
				}
				prevMinus = -1;
				minusFound = false;
			}
		}
	}
	
	private void swap(char[] ch, int j, int k)
	{
		char temp = ch[j];
		if( ch[k] == '+' )
			ch[j] = '-';
		else 
			ch[j] = '+';
		if (temp == '+')
		{
			ch[k] = '-';
		}
		else
			ch[k] = '+';
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		pancakeRevenge pr = new pancakeRevenge();
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++)
		{
			
			System.out.println("Case #" + (i + 1) + ": " + pr.happy(sc.next()));
		}
		

	}

}
