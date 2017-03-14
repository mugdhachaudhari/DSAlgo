import java.util.LinkedList;


public class ReorderLL {

	  public class ListNode {
	      int val;
	      ListNode next;
	     ListNode(int x) { val = x; }
	}

	    public ListNode reorderList(ListNode head) {
	        ListNode slow = head;
	        ListNode fast = head;
	        
	        
	        
	        while (fast.next != null && fast.next.next != null)
	        {
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        ListNode p = slow.next;
	        slow.next = null;
	        
	        ListNode prev = null;
	        
	        while (p != null)
	        {
	            ListNode temp = p.next;
	            p.next = prev;
	            prev = p;
	            p =temp;
	        }
	        ListNode p2 = prev;
return p2;
//	        
//	        p = head;
////	        System.out.println(p.val);
//	        
//	        while (p != null && p2 != null)
//	        {
//	            ListNode temp = p.next;
//	            p.next = p2;
//	            p2 = p2.next;
//	            p.next.next = temp;
//	            
//	        }
//	     return p; 
	        
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReorderLL rl = new ReorderLL();
		ListNode l1 = rl.new ListNode(1);
		ListNode l2 = rl.new ListNode(2);
		ListNode l3 = rl.new ListNode(3);
		ListNode l4 = rl.new ListNode(4);
		ListNode l5 = rl.new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		LinkedList<Integer> ll= new LinkedList<Integer>();
//		ll.add(l1.val);
//		ll.add(l2.val);
//		ll.add(l3.val);
//		ll.add(l3.val);
//		ll.add(l4.val);
//		ll.add(l5.val);
		rl.reorderList(l1);
		System.out.println(l1.val);
		System.out.println(l2.val);
		System.out.println(l3.val);
		System.out.println(l4.val);
		System.out.println(l5.val);
		

	}

}
