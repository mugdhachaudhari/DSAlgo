import java.util.Arrays;
import java.util.HashSet;

public class BoggleSolver
{
	private TrieSET26 tst;
	private boolean[][] marked;
	private TrieSET26.Node x;
	private int M, N;
	private Stack<TrieSET26.Node> xs;
	
	
	
	
    // Initializes the data structure using the given array of strings as the dictionary.
    // (You can assume each word in the dictionary contains only the uppercase letters A through Z.)
    public BoggleSolver(String[] dictionary)
    {
    	
    	tst = new TrieSET26();
    	
    	
    	for (int i = 0; i < dictionary.length; i++)
    	{
//    		System.out.println(dictionary[i]);
    		tst.add(dictionary[i]);
    	}
    	
//    	System.out.println(Arrays.toString(dictionary));
    		
    		
    }

    public Iterable<String> getAllWords()
    {
    	
    	HashSet<String> st = new HashSet<String>();
    	
    	for (String s : tst)
    	{
    		if (s.length() == 3)
    		{
    			if (s.startsWith("Y") || s.startsWith("L") || s.startsWith("V") || s.startsWith("E")
    					|| s.startsWith("T") || s.startsWith("J") || s.startsWith("S") || s.startsWith("N")
    					|| s.startsWith("F") || s.startsWith("X") || s.startsWith("P") || s.startsWith("M")
    					|| s.startsWith("D"))
    			{
    				st.add(s);
    			}
    			
    		}
    	}
    	System.out.println(tst.size());
    	System.out.println(tst.isEmpty());
    	

    	return st;
    	
    }
    
    // Returns the set of all valid words in the given Boggle board, as an Iterable.
    public Iterable<String> getAllValidWords(BoggleBoard board)
    {
    	M  = board.rows();
    	N = board.cols();
    	HashSet<String> st = new HashSet<String>();
    	    	
    	for (int i = 0; i < M; i++)
    	{
    		for(int j = 0; j < N; j++)
    		{
    			marked = new boolean[M][N];
    			x = null;
    			xs = new Stack<TrieSET26.Node>();
    			xs.push(x);
    			System.out.println("Main Values i= " + i + " j= " + j + " prefix= " + board.getLetter(i, j));
    			char ch = board.getLetter(i, j);
//    			System.out.println("Char " + ch);
    			StringBuilder s = new StringBuilder();
    			if (ch == 'Q')
    			{
    				s.append(ch);
    				s.append('U');
    			}
    			
    			else 
    				s.append(ch);
    			
//    			System.out.println("String " + s);
    			dfs(board, i, j, s, st);
    		}
    	}
    			
    	return st;
    }
    
    private void dfs(BoggleBoard board, int i, int j, StringBuilder prefix, HashSet<String> st)
    {
    	marked[i][j] = true;
    	
    	if (board.getLetter(i, j) == 'Q')
    		x = tst.prefixPresent(prefix.toString(), x, prefix.length() - 2);
    	else    	
    		x = tst.prefixPresent(prefix.toString(), x, prefix.length() - 1);
    	xs.push(x);
//    	System.out.println("Prefix " + prefix);
    	
    	if (x != null)
    	{
    		if (prefix.length() > 2 && tst.contains(prefix.toString()))
    		{
				if (!st.contains(prefix.toString()))
					st.add(prefix.toString());
    		}
    		
    		for (int p : adj(i, j))
    		{
    			int k = p/N;
    			int l = p%N;
    			if(!marked[k][l])
    			{
    				prefix.append(board.getLetter(k, l));
    				if (board.getLetter(k, l) == 'Q')
    					prefix.append('U');
//    				System.out.println("Values i= " + k + " j= " + l + " prefix= " + prefix);
    				dfs(board, k, l, prefix, st);
    			}   			
    		}
    		
    		marked[i][j] = false;
    		xs.pop();
    		x = xs.peek();
//    		System.out.println("Deleting sub loop Values i= " + i + " j= " + j + " Prefix= " + prefix);
    		if (board.getLetter(i, j) == 'Q')
    		{
    			prefix.delete(prefix.length() - 2, prefix.length());
    		}
    		else
    			prefix.deleteCharAt(prefix.length() - 1);
       	}
    	
    	else
    	{
    		marked[i][j] = false;
    		xs.pop();
    		x = xs.peek();
//    		System.out.println("Deleting main loop Values i= " + i + " j= " + j + " Prefix= " + prefix);
     		if (board.getLetter(i, j) == 'Q')
    		{
    			prefix.delete(prefix.length() - 2, prefix.length());
    		}
    		else
    			prefix.deleteCharAt(prefix.length() - 1);
    		
    	}
    	
    }
    
    private boolean marked(int i, int j)
    {
    	return marked[i][j];
    }
    
    private Iterable<Integer> adj(int i, int j)
    {
    	Stack<Integer> adj = new Stack<Integer>();
    	
    	if (i == 0)
    	{
    		if (j == 0)
    		{
    			adj.push((i + 1)*N + j);
    			adj.push((i*N + j + 1));
    			adj.push((i + 1)*N + j + 1);
    		}
    		
    		else if (j == N - 1)
    		{
    			adj.push((i + 1)*N + j);
    			adj.push((i*N + j - 1));
    			adj.push((i + 1)*N + j - 1);
    		}
    		
    		else
    		{
    			adj.push((i + 1)*N + j);
    			adj.push((i*N + j + 1));
    			adj.push((i + 1)*N + j + 1);
    			adj.push((i*N + j - 1));
    			adj.push((i + 1)*N + j - 1);
    		}
       	}
    	
    	else if (i == M - 1)
    	{
       		if (j == 0)
    		{
    			adj.push((i - 1)*N + j);
    			adj.push((i*N + j + 1));
    			adj.push((i - 1)*N + j + 1);
    		}
    		
    		else if (j == N - 1)
    		{
    			adj.push((i - 1)*N + j);
    			adj.push((i*N + j - 1));
    			adj.push((i - 1)*N + j - 1);
    		}
    		
    		else
    		{
    			adj.push((i - 1)*N + j);
    			adj.push((i*N + j + 1));
    			adj.push((i - 1)*N + j + 1);
    			adj.push((i*N + j - 1));
    			adj.push((i - 1)*N + j - 1);
    		}
    	}
    	
    	else if (j == 0)
    	{
   			adj.push((i + 1)*N + j);
			adj.push((i*N + j + 1));
			adj.push((i + 1)*N + j + 1);
			adj.push((i - 1)*N + j);
			adj.push((i - 1)*N + j + 1);
    	}
    	
    	else if ( j == N - 1)
    	{
			adj.push((i - 1)*N + j);
			adj.push((i*N + j - 1));
			adj.push((i + 1)*N + j);
			adj.push((i + 1)*N + j - 1);
			adj.push((i - 1)*N + j - 1);
    	}
    	
    	else
    	{
    		adj.push((i + 1)*N + j);
			adj.push((i*N + j + 1));
			adj.push((i + 1)*N + j + 1);
			adj.push((i - 1)*N + j);
			adj.push((i - 1)*N + j + 1);
			adj.push((i*N + j - 1));
			adj.push((i + 1)*N + j - 1);
			adj.push((i - 1)*N + j - 1);
    				
    	}
    	
    	return adj;
    		
    }

    // Returns the score of the given word if it is in the dictionary, zero otherwise.
    // (You can assume the word contains only the uppercase letters A through Z.)
    public int scoreOf(String word)
    {
    	if (word.length() <= 2)
    		return 0;
    	else if (word.length() <= 4)
    		return 1;
    	else if (word.length() == 5)
    		return 2;
    	else if (word.length() == 6)
    		return 3;
    	else if (word.length() == 7)
    		return 5;
    	else if (word.length() >= 8)
    		return 11;
    	else return 0;
    				
    	
    }

    public static void main(String[] args)
    {
        In in = new In(args[0]);
        String[] dictionary = in.readAllStrings();
        BoggleSolver solver = new BoggleSolver(dictionary);
        BoggleBoard board = new BoggleBoard(args[1]);
        int score = 0;
        for (String word : solver.getAllValidWords(board))
        {
            StdOut.println(word);
            score += solver.scoreOf(word);
        }
        
        System.out.println(solver.getAllWords());
        StdOut.println("Score = " + score);
//    	
//      In in = new In(args[0]);
//      String[] dictionary = in.readAllStrings();
//      BoggleSolver solver = new BoggleSolver(dictionary);
//      System.out.println(solver.getAllWords());
//      BoggleBoard board = new BoggleBoard(args[1]);
//      System.out.println(solver.getAllValidWords(board));
    	
//    	StringBuilder s = new StringBuilder("A");
//    	s.append("A");
//    	System.out.println(s);

    }



}
