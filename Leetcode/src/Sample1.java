class B{
   public void getValueB(){}
}

class C{
   public void getValueC(){}
}


interface cInterface{
   public void getValueC();
}

class cChild extends C implements cInterface{
    public void getValueC(){
    	System.out.println("cChild Class");
      // implementation goes here, call the super class's getValueC();

    }
}


// Below code is **like** class A extends B, C 
public class Sample1 extends B implements cInterface{
   

	   public void getValueC(){
		   	System.out.println("Sample1 Class");
		     // implementation goes here, call the super class's getValueC();

		   }
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cInterface child =  new cChild();
		cInterface child2 =  new Sample1();
		cChild sc = new Sample1();
		child.getValueC();
		child2.getValueC();
	}
}

