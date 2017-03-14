
import java.util.*;


//  Definition for a binary tree node.
class TreeNode1 {
      int val;
      TreeNode1 left;
      TreeNode1 right;
      TreeNode1(int x) { val = x; }
}
public class ConstructBinaryTree {
    public TreeNode1 buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inMap = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }
    
    private TreeNode1 buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        System.out.println("Pre Start " + preStart + " PreEnd " + preEnd +
        		" inStart " + inStart + " inEnd " + inEnd);
    	if ((preStart > preEnd) || (inStart > inEnd)) {
    		System.out.println("Exit ");
            return null;
        }
        
        TreeNode1 root = new TreeNode1(preorder[preStart]);
        System.out.println(inMap.toString());
        int rootPos = inMap.get(preorder[preStart]);
        int numsLeft = rootPos - inStart;

        System.out.println("Nums Left " + numsLeft + " RootPos " + rootPos);
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + numsLeft, inorder, inStart, rootPos - 1, inMap);
        root.right = buildTreeHelper(preorder, preStart + numsLeft + 1, preEnd, inorder, rootPos + 1, inEnd, inMap);
        
        return root;
        
    }
    
    public static void main(String[] args) {
    	ConstructBinaryTree cb = new ConstructBinaryTree();
    	int[] pre = {1, 2, 3};
    	int[] in = {2, 3, 1};
    	cb.buildTree(pre, in);
    }
}