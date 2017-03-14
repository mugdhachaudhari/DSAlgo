import java.util.Arrays;


public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        char[] ransomArr = ransomNote.toCharArray();
        Arrays.sort(ransomArr);
        char[] magArr = magazine.toCharArray();
        Arrays.sort(magArr);
        String ransomNew = new String(ransomArr);
        String magNew = new String (magArr);
        
        int i = 0, j = 0;
        System.out.println("RansomNew " + ransomNew + " MagNew " + magNew);
        while (i < ransomNew.length() & j < magNew.length()) { 
        	if (ransomNew.charAt(i) == magNew.charAt(j)) {
        		System.out.println("i is " + i + " j is  " + j);
        		if (i == ransomNew.length() - 1) {
        			return true;
        		}
        		i++;
        	} 
        	j++;
        }
        
        return false;
    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RansomNote rn = new RansomNote();
		System.out.println(rn.canConstruct("aba", "aab"));
	}

}
