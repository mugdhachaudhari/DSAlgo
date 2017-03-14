import java.util.HashMap;


public class WordPattern {
    public  static boolean wordPattern(String pattern, String str) {
        int i = 0;
        HashMap<String, Character> p = new HashMap<String, Character>();
        HashMap<Character, String> s = new HashMap<Character, String>();
        for (String st : pattern.split(" "))
        {
            if ( i >= str.length())
                return false;
            if (p.containsKey(st))
            {
                Character ch = p.get(st);
                if(s.containsKey(ch))
                    if(! s.get(ch).equals(st))
                        return false;
                    else
                        if(str.charAt(i) != ch)
                            return false;
                else if (! s.containsKey(ch))
                    return false;
                    
            }
            
            else
            {
                if(s.containsKey(str.charAt(i)))
                {
                    return false;
                }
                else
                {
                    p.put(st, str.charAt(i));
                    s.put(str.charAt(i), st);
                }
            }
            
            i++;
        }
        
        if ( i < str.length() )
            return false;
        return true;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pattern  = "dog dog dog dog cat";
		String str = "aaaab";
		System.out.println("Matches : " + wordPattern(pattern, str));
	}

}
