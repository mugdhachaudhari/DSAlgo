import java.io.ObjectInputStream.GetField;
import java.util.*;


public class GraphGenetics {
	
	private static int getHammingDistance(String a, String b) {
		int dist = 0;
		for (int i = 0; i < a.length(); i++) {
			if (dist > 1) {
				break;
			}
			if (a.charAt(i) == b.charAt(i)){
				continue;
			} else {
				dist++;
			}
		}
		if (dist == 1) {
			return 1;
		} else {
			return 0;
		}
		
	}
	
	private static int getShortestDistance(int start, int end, ArrayList<HashSet<Integer>> graph) {
		Queue<Integer> queue = new LinkedList<Integer>();
		HashSet<Integer> visited = new HashSet<Integer>();
		queue.add(start);
		int[] dist = new int[graph.size()];
		dist[start] = 0;
		while(queue.size() > 0) {
			int ind = queue.poll();
			visited.add(ind);
//			System.out.println("Graph Set " + graph.get(ind).toString());
			for (int k : graph.get(ind)) {
				if (! visited.contains(k)) {
					dist[k] = dist[ind] + 1;
					queue.add(k);
					if (k == end) {
						return dist[k];
					}
					visited.add(k);
				}
			}
		}
		
		return -1;
	}
	
    static int findMutationDistance(String start, String end, String[] bank) {
	    HashMap<String, Integer> genes  = new HashMap<String, Integer>();
	    ArrayList<HashSet<Integer>> graph = new ArrayList<HashSet<Integer>>();
	    int startIndex = -1;
	    int endIndex = -1;
	    int shortOffset = 0;
		int shortDist = Integer.MAX_VALUE;
	    ArrayList<Integer> firstMut = new ArrayList<Integer>();
	    for (int i = 0; i < bank.length; i++) {
	    	graph.add(new HashSet<Integer>());
	    }
	    for (int i = 0; i < bank.length; i++) {
	    	for (String gene : genes.keySet()) {
	    		int calcDist = getHammingDistance(bank[i], gene);
//	    		System.out.println("Hamming distance betn " + genes.get(gene) + " " + i + " is " + calcDist);
	    		if (calcDist == 1) {
	    			graph.get(i).add(genes.get(gene));
	    			graph.get(genes.get(gene)).add(i);
	    		}
	    	}
	        genes.put(bank[i], i);
	        if (start.equals(bank[i])) {
	        	startIndex = i;
	        }
	        if (end.equals(bank[i])) {
	        	endIndex = i;
	        }
	    }
	    
	    if (startIndex == -1) {
	    	shortOffset = 1;
	    	for (int i = 0; i < bank.length; i++) {
		        if (getHammingDistance(start, bank[i]) == 1) {
		        	firstMut.add(i);
		        }
	    	}
	    } else {
	    	firstMut.add(startIndex);
	    }
//	    System.out.println("Startindex " + startIndex + "EndIndex " + endIndex);
	    if (endIndex == -1) {
	    	return -1;
	    } else if (startIndex  == -1 && firstMut.size() == 0) {
	    	return -1;
	    } else if (startIndex == endIndex) {
	    	return 0;
	    } else {
	    	for (int i : firstMut) {
	    		int bfsRes = getShortestDistance(i, endIndex, graph);
//	    		System.out.println(bfsRes);
	    		if (bfsRes != -1) {
	    			if(bfsRes + shortOffset < shortDist) {
	    				shortDist = bfsRes + shortOffset;
	    			}
	    		}	    		
	    	}
	    	if (shortDist != Integer.MAX_VALUE) {
	    		return shortDist;
	    	}	    	
	    }
	    return -1;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] bank = new String[4];
		bank[0] = "AAAAAAAA";
		bank[1] = "AAAAAAAT";
		bank[2] = "AAAAAATT";
		bank[3] = "AAAAATTT";
		System.out.println(findMutationDistance("AAAAAAAA", "AAAAAATT", bank));
		
//		System.out.println(getHammingDistance("AAAAAAAT", "AAAAAATT"));
	}

}
