import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class TrieNode {
    // Initialize your data structure here.
    public char value;
    public boolean isWord;
    public TrieNode[] next;
    public TrieNode(char value) {
        this.value = value;
        isWord = false;
        next = new TrieNode[26];
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode(' ');
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode tn = root;
        char[] chArray = word.toCharArray();
        for (int i = 0; i < chArray.length; i++) {
            TrieNode tmp = tn.next[chArray[i] - 'a'];
            if (tmp == null) {
                tmp = new TrieNode(chArray[i]);
                tn.next[chArray[i] - 'a'] = tmp;
                
            }
            
            if (i == chArray.length - 1) {
                tmp.isWord = true;
            }
            tn = tmp;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = findLastNode(word.toCharArray());
        return (node != null && node.isWord) ? true : false;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = findLastNode(prefix.toCharArray());
        return (node != null) ? true : false;
    }
    
    private TrieNode findLastNode(char[] chArray) {
        TrieNode node = root;
        for (int i = 0; i < chArray.length; i++) {
            TrieNode nd = node.next[chArray[i] - 'a'];
            if (nd == null) {
                return null;
            }
            node = nd;
        }
        return node;
    }
}


public class Board {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (int i = 0; i < words.length; i++) {
            trie.insert(words[i]);
        }
        
        List<String> ls = new ArrayList<String>();
        
        if (board.length == 0) {
            return null;
        }
        
        int m = board.length;
        int n = board[0].length;
        
        
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                HashMap<Integer, Integer> mp = new HashMap<Integer, Integer>();
                findWords(i, j, board, mp, m, n, ls, trie, String.valueOf(board[i][j]));
           }
        }
        
       return ls; 
    }
    
    private void findWords(int i, int j, char[][] board, HashMap<Integer, Integer> mp, int m, int n, List<String> ls, Trie trie, String st) {
        if (trie.startsWith(st)) {
            if (trie.search(st)) {
//            	System.out.println("Added");
                ls.add(st);
            }
//            System.out.println("i is " + i + "j is " + j);
            mp.put(n*i + j, 1);
            if (i + 1 < m && !(mp.containsKey(n*(i + 1) + j))) {
//            	System.out.println("Down");
                findWords(i + 1, j, board, new HashMap<Integer, Integer>(mp), m, n, ls, trie, st + board[i +1][j]);
            }
            
            if (j + 1 < n && !(mp.containsKey(n*(i) + j + 1))) {
//            	System.out.println("Right");
                findWords(i, j + 1, board, new HashMap<Integer, Integer>(mp), m, n, ls, trie, st + board[i][j + 1]);
            }   
            if (i - 1 >= 0 && !(mp.containsKey(n*(i - 1) + j))) {
//            	System.out.println("Up");
                findWords(i - 1, j, board, new HashMap<Integer, Integer>(mp), m, n, ls, trie, st + board[i - 1][j]);
            }
            
            if (j - 1 >= 0 && !(mp.containsKey(n*(i) + j - 1))) {
//            	System.out.println("Left");
                findWords(i, j - 1, board, new HashMap<Integer, Integer>(mp), m, n, ls, trie, st + board[i][j - 1]);
            } 
        } 
        
        return;
        
        
        
    }
    
    public static void main(String[] args) {
		Board b = new Board();
		char[][] dict = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},
				{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(b.findWords(dict, words));
	}
}