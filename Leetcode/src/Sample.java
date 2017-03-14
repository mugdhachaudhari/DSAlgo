abstract class A {
	public abstract int getMethod() ;
	public void nonAbstractGetMethod() {
		System.out.println("Non Abstract method in A");
	}
}


public class Sample extends A {
	public int getMethod() {
		System.out.println("B metod called");
		return 0;
	}
	
	public void nonAbstractGetMethod() {
		System.out.println("Non Abstract method in B");
	}
	
	public void checkB() {
		System.out.println("Method defined only in B");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new Sample();
		a.getMethod();
		a.nonAbstractGetMethod();
//		a.checkB();
	}

}
