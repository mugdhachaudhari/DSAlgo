import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZumaGame {

	public int findMinStep(String board, String hand) {
        List<Character> boardList = new ArrayList<Character>();
		Map<Character, Integer> handMap = new HashMap<Character, Integer>();
		for (char c : "RYBGW".toCharArray()) {
			handMap.put(c, 0);
		}
		
		for (char c : board.toCharArray()) {
        	boardList.add(c);
        	if (handMap.containsKey(c)) {
        		handMap.put(c, handMap.get(c) + 1);
        	}
        }
		
		
		find(boardList, handMap);
		
    }
	
	private int find(List<Character> boardList, Map<Character, Integer> handMap) {
		cleanBoard(boardList);
		int count = 0;
		int resCount = Integer.MAX_VALUE;
		for (int i = 0; i < boardList.size(); i++) {
			count++;
			char c = boardList.get(i);
			if ((i == boardList.size() - 1) || (c != boardList.get(i + 1))) {
				int missing = 3- count;
				if (handMap.getOrDefault(c, 0) >= missing) {					
						handMap.put(c, handMap.get(c) - missing);
						List<Character> shortBoard = new ArrayList<Character>(boardList);
						for (int j = 0; j < count; j++) {
							
						
						
					}
				}
				
				
				
				count = 0;
				i = 0;
			}
			i++;
		}
	}
	
	private void cleanBoard(List<Character> boardList) {
		int count = 0;
		boolean isCleaned = false;
		
		
		for (int i = 0; i < boardList.size(); i++) {
			count++;
			char c = boardList.get(i);
			if ((i == boardList.size() - 1) || (c != boardList.get(i + 1))) {
				if (count >= 3) {
					for (int j = 0; j < count; j++) {
						boardList.remove(i - j);
					}
					isCleaned = true;
				}
				count = 0;
			}
		}
		
		if (isCleaned) {
			cleanBoard(boardList);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
