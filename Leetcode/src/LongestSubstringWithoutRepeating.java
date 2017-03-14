import java.util.HashMap;
import java.util.HashSet;

class position {
	public int start;
	public int end;
	
	public position(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
public class LongestSubstringWithoutRepeating {

	public static String longest(String s) {
		int start = 0;
		int end = 0;
		HashMap<Integer, position> len = new HashMap<Integer, position>();
		HashSet<Character> dup = new HashSet<Character>();
		while ( end < s.length()) {
			if (dup.contains(s.charAt(end))) {
				len.put(end - start, new position(start, end - 1));
				start = end;
				dup = new HashSet<Character>();
			} else {
				dup.add(s.charAt(end));
				end++;
			}
		}
		if (dup.size() > 0) {
			len.put(end - 1 - start, new position(start, end - 1));
		}
		int max = 0;
		position p = new position(0, 0);
		for (int l : len.keySet()) {
			if (l > max) {
				max = l;
				p = len.get(l);
			}
		}
		if (max == 0) {
			return "-1";
		}
		return s.subSequence(p.start, p.end + 1).toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longest("aaaaaaa"));
		System.out.println(longest("abac"));
		System.out.println(longest("abcadbef"));
		
	}

}
