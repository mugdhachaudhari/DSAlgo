
public class BbMyList<T>  {
	T head;
	BbMyList<T> tail;
	
	public void insert(T elem) {
		if (head == null) {
			head = elem;
		} else if (tail == null) {
			tail = new BbMyList<T>();
			tail.insert(head);
			head = elem;
		} else {
			tail.insert(head);
			head = elem;
		}
	}
	
	public String toString(int i){
		System.out.println(i + " Head is " + head);
		if (tail != null) {
			tail.toString(i + 1);
		}
		return "Done";
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BbMyList<Integer> x = new BbMyList<Integer>();
		x.toString(0);
		x.insert(4);
		System.out.println("Inserted ");
		x.toString(0);
		x.insert(3);
		System.out.println("Inserted ");
		x.toString(0);
		x.insert(2);
		System.out.println("Inserted ");
		x.toString(0);
		x.insert(1);
		System.out.println("Inserted ");
		x.toString(0);
		

	}

}
