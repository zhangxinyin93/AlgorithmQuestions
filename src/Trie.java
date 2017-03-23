/**
 * Implement Trie structure, prefix tree
 */

// Version 1: 26叉树
public class Trie {
    class TrieNode {
        private TrieNode[] children;
        public boolean hasWord;

        public TrieNode() {
            children = new TrieNode[26];
            hasWord = false;
        }

        public void insert(String word, int index) {
            if(index == word.length()) {
                this.hasWord = true;
                return;
            }

            int position = word.charAt(index)-'a';
            if(children[position] == null) {
                children[position] = new TrieNode();
            }

            children[position].insert(word,index + 1);
        }

        public TrieNode search(String word, int index) {
            if(index == word.length()) {
                return this;
            }

            int position = word.charAt(index) - 'a';
            if(children[position] == null) {
                return null;
            }

            return children[position].search(word, index + 1);
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        root.insert(word,0);
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root.search(word,0);
        return (node != null && node.hasWord);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        return root.search(prefix,0) != null;
    }
}
