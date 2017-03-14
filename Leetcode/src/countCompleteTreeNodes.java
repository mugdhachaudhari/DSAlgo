class TreeNode {
	 int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}


public class countCompleteTreeNodes {

    public int countNodes(TreeNode root) {
    	if (root  == null) {
    		return 0;
    	}
        int lh = getHeight(root.left);
        int rh = getHeight(root.right);
        if (lh == rh) {
//        	Go to right subtree to find last node
        	return 1 + ((1 << (lh) ) - 1) + countNodes(root.right);
        } else {
//        	Go to left subtree to find last node
        	return 1 + ((1 << (rh)) - 1) + countNodes(root.left);
        }
    }
	
    
    public int getHeight(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int cnt = 0;
    	while(root != null) {
    		root = root.left;
    		cnt++;
    	}
    	return cnt;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countCompleteTreeNodes cn = new countCompleteTreeNodes();
		TreeNode tn = new TreeNode(2);
		tn.left = new TreeNode(4);
		tn.right = null;
		System.out.println(cn.countNodes(tn));
	}

}
