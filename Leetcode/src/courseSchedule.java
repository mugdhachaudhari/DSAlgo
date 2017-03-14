import java.util.ArrayList;
import java.util.Stack;

public class courseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] in = new ArrayList[numCourses];
        
        if(numCourses == 1)
            return true;
        if(prerequisites.length == 0)
            return true;
//        System.out.println(prerequisites.length);
        for (int k = 0; k < in.length; k++)
        {
        	in[k] = new ArrayList<Integer>();
        }
        for(int i = 0; i < prerequisites.length; i++)
        {
           	
        	in[prerequisites[i][1]].add(prerequisites[i][0]);
            
        }
//        System.out.println("Hi");
        return topologicalSort(in);
        
    }
    
    private boolean topologicalSort(ArrayList<Integer>[] in)
    {
        int[] v = new int[in.length];
        boolean b = false;
        
        Stack<Integer> t = new Stack<Integer>();
        
        for (int i = 0; i < v.length; i++)
        {
            if (v[i] == 0)
            {
                b = topSort(in, v, i, t);
                if (!b)
                	return b;
            }
        }
        // if (b)
        //     System.out.println(t.toString());
        return b;
    }
    
    private boolean topSort(ArrayList<Integer>[] in, int[] v, int i, Stack<Integer> t)
    {
        v[i] = 1;
        boolean f = true;
//        if(in[i].size() >= 0)
//        {
        for(int j = 0; j < in[i].size(); j++)
        {
            if (in[i] != null && v[in[i].get(j)] == 0)
            {
                f = topSort(in, v, in[i].get(j), t);
                if(!f)
                	return f;
            }
            else if (in[i] != null && v[in[i].get(j)] == 1)
            {
            	f = false;
                return f;        
            }
        }
        
        v[i] = 2;
        t.push(i);
        return f;
//        }
//        return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		courseSchedule s = new courseSchedule();
		int[][] a = {{1, 0}, {2, 0}, {0, 1}};
		System.out.println(s.canFinish(3, a));
	}
}