import java.util.ArrayList;
import java.util.List;

public class IpAddressComb {
    public List<String> restoreIpAddresses(String s) {
        
        List<String> res = new ArrayList<String>();
        
        restoreIpHelper(s, 0, "", res, 0);
        
        return res;
    }
    
    private void restoreIpHelper(String s, int idx, String found, List<String> res, int cntField) {
    	System.out.println("Found is " + found);
    	if (cntField > 4) {
            return;
        }  
        if (cntField == 4 && idx >= s.length()) {
                res.add(found);
        }
       
        
        for (int i = 1; i < 4; i++) {
            if (idx + i > s.length()) break;
            String sub = s.substring(idx, idx + i);
            if (Integer.valueOf(sub) >= 256 || (sub.startsWith("0") && sub.length() > 1)) continue;
            restoreIpHelper(s, idx + i, found + sub + (cntField == 3?"" : "."), res, cntField + 1);

            
        }
    }
    
    public static void main(String[] args) {
    	IpAddressComb ip = new IpAddressComb();
    	System.out.println(ip.restoreIpAddresses("010010"));
    }
}