import java.util.HashMap;
import java.util.Map;

class TrieNode {
    Map<Character, TrieNode> nodes;
    boolean isWord;

    public TrieNode() {
        nodes = new HashMap<>();
    }

}

public class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char letter = word.charAt(i);
            TrieNode node = current.nodes.get(letter);
            if (node == null) {
                node = new TrieNode();
                current.nodes.put(letter, node);
            }
            current = node;
        }
        current.isWord = true;
    }

    public boolean isCompleteWord(String word) {
        TrieNode current = root;
        int len = word.length();
        for(int i = 0; i < len; i++) {
            char letter = word.charAt(i);
            TrieNode node = current.nodes.get(letter);
            System.out.println("node: " + node.nodes);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isWord;
    }

    public boolean isValidPrefix(String prefix) {
        TrieNode current = root;
        int len = prefix.length();
        for(int i = 0; i < len; i++) {
            char letter = prefix.charAt(i);
            TrieNode node = current.nodes.get(letter);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current != null;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("helloworld");
        trie.insert("hello");
        trie.insert("java");
        trie.insert("javascript");
        System.out.println(trie.isCompleteWord("helloworld"));
        System.out.println(trie.isCompleteWord("hello"));
        System.out.println(trie.isCompleteWord("hell"));

        System.out.println(trie.isValidPrefix("hell"));
        System.out.println(trie.isValidPrefix("hellp"));
    }
}