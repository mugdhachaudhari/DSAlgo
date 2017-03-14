import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Practice {
throw new Ille


    public static void main(String[] args) throws IOException {
	String s = "";

        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
                 Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++) {
        	int n = Integer.parseInt(sc.nextLine());
        	String s = String.valueOf(n);
        	Double d = Double.parseDouble(s);
            int[][] matrix = new int[2*n][2*n];
                String[] row = sc.nextLine().split(" "); 
        PriorityQueue<String> pq=new PriorityQueue<String>();  
        List<Integer> q = new LinkedList<Integer>();        
        ArrayList<Integer> al2=new ArrayList<Integer>();
        LinkedList<Integer> l = new LinkedList<Integer>();
        
        Stack<Integer> st = new Stack<Integer>();        
        Queue<Integer> qe = new LinkedList<Integer>();        
        Map<Integer, String> m = new HashMap<Integer, String>();
        
        HashMap<Integer, Integer> m1 = new HashMap<Integer, Integer>();
        for (Entry<Integer, Integer> e : m1.entrySet()) {
        	e.getKey();
        }        
        for (Integer sk : m1.keySet()) {        	
        }        
        Set<Integer> ss = new HashSet<Integer>();
        Set<Integer> sts = new TreeSet<Integer>();
        Set<Integer> sl = new LinkedHashSet<Integer>();        
        Map<Integer, String> tm = new TreeMap<Integer, String>();
        ArrayList<Integer> al = new ArrayList<Integer>(al2);
        
        StringBuilder st = new StringBuilder();
        class IntervalComparator implements Comparator<Interval> {
        	public int compare(Interval i1, Interval i2) {
        		return i1.start - i2.start;
        	}       }
        Map m = Collections.synchronizedMap(hashMap);

			
			
		
			
			
        

            
//            for (int x = 0; x < 2*n; x++) {
//            	for (int y = 0; y < 2*n; y++) {
//            		System.out.print(matrix[x][y] + " ");
//            	}
//            	System.out.println("");
//            }
//            
            int fSum = 0; int sSum = 0;
            int fttlSum = 0;
            int sttlSum = 0;
            int ttlSum = 0;
            for (int p = n; p < 2*n; p++) {
                fSum = 0; sSum = 0;
                for (int q = 0; q < n; q++) {
                    fSum += matrix[p][q];
                    sSum += matrix[p][q + n];
                }
                if (fSum > sSum) {
                    for (int q = 0; q < n; q++) {
                        int temp = matrix[p][q];
                        matrix[p][q] = matrix[p][2*n - 1 - q];
                        matrix[p][2*n - 1 - q] = temp;
                    }

                } 
            }
//            
//            System.out.println("First");
//            for (int x = 0; x < 2*n; x++) {
//            	for (int y = 0; y < 2*n; y++) {
//            		System.out.print(matrix[x][y] + " ");
//            	}
//            	System.out.println("");
//            }
//            
            fSum = 0; sSum = 0;
            for (int p = n; p < 2*n; p++) {
                fSum = 0; sSum = 0;
                for (int q = n; q < 2*n; q++) {
                    fSum += matrix[q][p];
                    sSum += matrix[q - n][p];
                }
                if (fSum > sSum) {
                    for (int q = n; q < 2*n; q++) {
                        int temp = matrix[q][p];
                        matrix[q][p] = matrix[2*n - 1 -q][p];
                        matrix[2*n - 1 - q][p] = temp;
                    }
                }
            }
            
//            System.out.println("Second");
//            for (int x = 0; x < 2*n; x++) {
//            	for (int y = 0; y < 2*n; y++) {
//            		System.out.print(matrix[x][y] + " ");
//            	}
//            	System.out.println("");
//            }

            fSum = 0; sSum = 0;
            fttlSum = 0;
            sttlSum = 0;
            ttlSum  = 0;
            for (int p = 0; p < n; p++) {
                fSum = 0; sSum = 0;
                for (int q = 0; q < n; q++) {
                    fSum += matrix[p][q + n];
                    sSum += matrix[p][q];
                }
                if (fSum > sSum) {
                    ttlSum += fSum;                    
                } else {
                    ttlSum += sSum;
                }
            }
        System.out.println(ttlSum);
            
        }
    }
}