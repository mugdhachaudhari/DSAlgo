// you can also use imports, for example:
import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class DirLength {
    public int solution(String S) {
        // write your code in Java SE 8
        int i = 0;
        int cntSpace = 0;
        int lenSubString = 0;
        Stack<Integer> st = new Stack<Integer>();
        int maxLen = 0;
        int curLen = 0;
        while (i <= S.length()) {
            if (i != S.length() && S.charAt(i) == '\t') {
                cntSpace++;
            } else if (i == S.length() || S.charAt(i) == '\n') {
                //Add String in Stack
                for (int k = cntSpace; k < st.size(); k++) {
                    curLen -= st.peek();
                    st.pop();
                }
                st.push(lenSubString);
                curLen += lenSubString;
                
                System.out.println("i is " + i + " len Sub " + lenSubString);
//                System.out.println(i - lenSubString);
//                System.out.println(lenSubString);

                String sub = S.substring(i - lenSubString, i);
                System.out.println(sub);
                if (sub.contains(".")) {
                    if (sub.contains(".jpeg") || sub.contains(".png") || sub.contains(".gif") ) {
                        System.out.println("CurLen "+ curLen);
                    	if (curLen > maxLen) {
                        	
                            maxLen = curLen;
                        }
                    }
                }
                cntSpace = 0;
                lenSubString = 0;
            } else {
                
                lenSubString++;
            }
            
            i++;
        }
        return maxLen;       
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirLength b = new DirLength();
		
		String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.jpeg";
		System.out.println("Length" + s.length());
		System.out.println(s);
		System.out.println(b.solution(s));
		
	}
}