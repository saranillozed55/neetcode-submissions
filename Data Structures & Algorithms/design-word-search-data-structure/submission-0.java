class WordDictionary {

    private Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node cur = root;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isCompleteWord = true;
    }

    public boolean search(String word) {
        return dfs(word, 0, root);
    }
    public boolean dfs(String word, int index, Node node) {
        if(index == word.length()) {
            return node.isCompleteWord;
        }

        char c = word.charAt(index);

        if(c == '.') {
            for(Node child : node.children.values())  {
                if(dfs(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        if(!node.children.containsKey(c)) {
            return false;
        }
        return dfs(word, index + 1, node.children.get(c));
    }
}
public class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isCompleteWord;
}
