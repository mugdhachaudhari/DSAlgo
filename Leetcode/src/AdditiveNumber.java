public class AdditiveNumber {
    public boolean isAdditiveNumber(String num) {


        for (int i = 0;  i < num.length()/2; i++) {
            String a = num.substring(0, i + 1);
            if (a.charAt(0) == '0' && a.length() > 1) {
                continue;
            }
            for (int j = i + 1; j < num.length(); j++) {
                String b = num.substring(i + 1, j + 1);
                if (b.charAt(0) == '0' && b.length() > 1) {
                    continue;
                }
                
                if(isValid(Long.parseLong(a), Long.parseLong(b), num.substring(j + 1))) {
                	return true;
                }
            }
            
        }
        
        return false;
    }
    
    private boolean isValid(long a, long b, String remaining) {
    	System.out.println("a is " + a + " b is " + b + " Remain is " + remaining);
        long sum = a + b;
        String sumStr = String.valueOf(sum);
        int lenSum = sumStr.length();
        if (remaining.length() < lenSum) {
            return false;
        }
        if (lenSum == remaining.length() && sumStr.equals(remaining)) {
            return true;
        }
        if (remaining.substring(0, lenSum).equals(sumStr)) {
            isValid(b, sum, remaining.substring(lenSum));
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AdditiveNumber an = new AdditiveNumber();
		System.out.println(an.isAdditiveNumber("211738"));
	}
}