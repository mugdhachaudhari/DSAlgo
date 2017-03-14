import java.util.Arrays;

public class SplitString {
    public int countSegments(String s) {
    	s = s.trim();
        if (s == null || s.length() == 0) {
            return 0;
        }
        String[] st = s.split("\\s+");
        System.out.println(Arrays.toString(st));
        return st.length;
    }
    
    public static void main(String[] args) {
    	SplitString ss = new SplitString();
    	System.out.println(ss.countSegments("    foo    bar"));
    	
    }
}