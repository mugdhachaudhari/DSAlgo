import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;

public class Nqueens {
    private List<List<String>> result = new ArrayList<List<String>>();
    private char[][] solution;
    
    public List<List<String>> solveNQueens(int n) {
    	solution = new char[n][n];
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < n; j++) {
        		solution[i][j] = '.';
    		}
    	}
    	placeQueens(0, n, -1);
    	return result;
    	
    }
    
    private int placeQueens(int col, int size, int row) {
    	if (col == size) {
    		List<String> res = new ArrayList<String>();
    		for (int i = 0; i < size; i++) {
    			res.add(Arrays.toString(solution[i]));
    		}
    		result.add(res);
    		solution[row][col - 1] = '.';
    		return 1;
    		
    	}
    	
    	for (int j = 0; j < size; j++) {
//    		System.out.println("Row " + j + " Column " + col);
    		if(canPlace(j, col)) {
    			solution[j][col] = 'Q';
    			if (placeQueens(col + 1, size, j) == 1) {
    				solution[j][col] = '.';
    				continue;
    			} else {
    				solution[j][col] = '.';
    			}
    		}
    		
    		
    	}
    	return 0;
    	
    }

    private boolean canPlace(int row, int col) {
    	for (int i = 0; i < col; i++) {
    		if (solution[row][i] == 'Q') {
    			return false;
    		}
    	}
    	
    	for (int i = row, j = col; i >= 0 && j >= 0; i--,j--) {
    		if (solution[i][j] == 'Q') {
    			return false;
    		}
    	}
    	
    	for (int i = row, j = col; i < solution.length && j >= 0; i++,j--) {
    		if (solution[i][j] == 'Q') {
    			return false;
    		}
    	}
    	return true;
    }
    
	public static void main(String[] args) {
		Nqueens n = new Nqueens();
		List<List<String>> res = n.solveNQueens(4);
		System.out.println(res.size());
		for (List<String> subRes : res) {
			System.out.println(subRes.toString());
		}
	}
}