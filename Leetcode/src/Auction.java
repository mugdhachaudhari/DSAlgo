import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Auction {
	 // Store required auction info
    Map<Integer, ArrayList<Integer>> sm = new TreeMap<Integer, ArrayList<Integer>>();
    Map<Integer, Arrays> sm1 = new TreeMap<Integer, Arrays>();
    
    int ttlBuyer = 0;
    int ttlSeller = 0;
    // Implement this function to add buyer
    void addBuyer(int price) {

        if (! sm.containsKey(price)) {
            ArrayList<Integer> l1 = new ArrayList<Integer>();
            l1.add(1);
            l1.add(0);
            sm.put(price, l1);
        } else {
            int nrBuy = sm.get(price).get(0);
            sm.get(price).set(0, nrBuy + 1);
        }
        ttlBuyer++;
    	System.out.println("Buy");
    	System.out.println(sm.toString());
    }
    
    // Implement this function to add seller
    void addSeller(int price) {

        if (! sm.containsKey(price)) {
            ArrayList<Integer> l1 = new ArrayList<Integer>();
            l1.add(0);
            l1.add(1);
            sm.put(price, l1);
        } else {
            int nrSell = sm.get(price).get(1);
            sm.get(price).set(1, nrSell + 1);
        }
    	System.out.println("Sell");
    	System.out.println(sm.toString());

    }
    
    /*
    * This is responsible for deallocating AuctionInfo
    * Implement this function to process auction data and print <MATCHED_QTY> <AUCTION_PRICE>
    */
    void process() throws Exception {
        
        int bestMatchedQty = 0;
        int bestAuctionPrice = 0;
        int max = Integer.MIN_VALUE;
        int auctionP = 0; 
        int diff = 0;
        System.out.println(sm.toString());
        for (Map.Entry<Integer, ArrayList<Integer>> en : sm.entrySet()) {
            Integer price = en.getKey();
            ArrayList<Integer> val = en.getValue();
            int curBuyers = val.get(0);
            val.add(ttlBuyer);
            ttlBuyer = ttlBuyer - curBuyers;
            ttlSeller = ttlSeller + val.get(1);
            val.add(ttlSeller);
            val.add(Math.min(val.get(2), val.get(3)));
            
            if (val.get(4) > max) {
                max = val.get(4);
                auctionP = price;
                diff = Math.abs(val.get(2) - val.get(3));
                               
            } else if (val.get(4) == max) {
                if (diff == Math.abs(val.get(2) - val.get(3))) {
                    if (auctionP < price) {
                        auctionP = price;                        
                    }
                } else if (diff > Math.abs(val.get(2) - val.get(3))) {
                    auctionP = price;
                } 
            }
            
            
        }
        
        if (max == 0) {
            bestAuctionPrice = 0;
            bestMatchedQty = 0;
            
        } else {
            bestAuctionPrice = auctionP;
            bestMatchedQty = max;
        }
        System.out.println(" bestAuctionPrice " + bestAuctionPrice + " bestMatchedQty " + bestMatchedQty);
        // Modify the output to return <MATCHED_QTY> <AUCTION_PRICE>
//        final String fileName = System.getenv("OUTPUT_PATH");
//        BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
//        bw.write(String.valueOf(bestMatchedQty) + " " + bestAuctionPrice);
//        bw.close();
    }

    public static void main(String args[] ) throws Exception {
        String strSide;
        int price;

        Auction auction = new Auction();

//        Scanner sc = new Scanner(System.in);
//        // INPUT FORMAT:
//        // <SIDE> <PRICE>
//        while (sc.hasNextLine())
//        {   
//            String line = sc.nextLine();
//            strSide = line.substring(0, line.indexOf(" "));
//            price = Integer.parseInt(line.substring(strSide.length() + 1).trim());
//
//            if (strSide.equals("BUY"))
//            {   
//                auction.addBuyer(price);
//            }
//            else
//            {   
//                auction.addSeller(price);
//            }
//        }
      auction.addBuyer(90);
        auction.addBuyer(90);
        auction.addBuyer(94);
        auction.addBuyer(94);
        auction.addBuyer(95);
        auction.addSeller(80);
        auction.addSeller(90);
        auction.addSeller(90);
        auction.addSeller(92);
        auction.addSeller(100);
        
        auction.process();
    }
}