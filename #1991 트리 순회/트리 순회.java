import java.io.*;
import java.util.HashMap;

public class Main { //갓천대 짱! 동기나라사랑!!!
    static HashMap<String, Node> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            Node node = getNode(s[0]);
            Node left = getNode(s[1]);
            Node right = getNode(s[2]);

            node.setLeft(left);
            node.setRight(right);
        }

        preorder(map.get("A")); // 전위 순회
        System.out.println();
        inorder(map.get("A")); // 중위 순회
        System.out.println();
        postorder(map.get("A")); // 후위 순회
    }

    public static Node getNode(String name) {
        if (name.equals(".")) {
            return null;
        }

        Node node;
        if (map.containsKey(name)) {
            node = map.get(name);
        } else {
            node = new Node(name);
            map.put(name, node);
        }

        return node;
    }

    // 전위 순회
    public static void preorder(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.getName());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    // 중위 순회
    public static void inorder(Node node) {
        if (node == null) {
            return;
        }

        inorder(node.getLeft());
        System.out.print(node.getName());
        inorder(node.getRight());
    }

    // 후위 순회
    public static void postorder(Node node) {
        if (node == null) {
            return;
        }

        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.print(node.getName());
    }
}

class Node {
    private String name;
    private Node left;
    private Node right;

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}