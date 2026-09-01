class PrefixTree {

    private Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for(char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new Node());
            cur = cur.children.get(c);
        }
        cur.isCompleteWord = true;
    }

    public boolean search(String word) {
        Node cur = root;
        for(char c : word.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return cur.isCompleteWord;
    }

    public boolean startsWith(String prefix) {
        Node cur = root;
        for(char c : prefix.toCharArray()) {
            if(!cur.children.containsKey(c)) {
                return false;
            }
            cur = cur.children.get(c);
        }
        return true;
    }
}
public class Node {
    HashMap<Character, Node> children = new HashMap<>();
    boolean isCompleteWord;
}
