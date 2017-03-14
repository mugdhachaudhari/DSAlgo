import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;


public class HashWork {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String whatever = "F:\\MSCSNyuPoly\\Fall2016\\WebSearchEngine\\Assignments\\Assignment3\\QueryTraces\\09.mq.topics.20001-60000\\old.20001-60000";
		try {
//			Process p = Runtime.getRuntime().exec("sort -t -k2 2 -k1 1 " + whatever);
//			Process p = Runtime.getRuntime().exec("sort -n " + whatever);
			
			Process p = Runtime.getRuntime().exec("sort " + whatever);
			
			System.out.println("Exit value " + p.exitValue());
			BufferedInputStream bi = new BufferedInputStream(p.getInputStream());
			int i;
			while ((i = bi.read()) != -1) {
				System.out.println(bi.read());
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
