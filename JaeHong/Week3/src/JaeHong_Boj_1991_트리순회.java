import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class JaeHong_Boj_1991_트리순회 {
    static HashMap<Character,Node> tree = new HashMap<>();
    static StringBuilder preorderResult = new StringBuilder();
    static StringBuilder inorderResult = new StringBuilder();
    static StringBuilder postorderResult = new StringBuilder();

    public static void preorder(Node node) {
        if (node == null) return;
        preorderResult.append(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        inorderResult.append(node.data);
        inorder(node.right);
    }

    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        postorderResult.append(node.data);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        // 루트 노드 생성
        tree.put('A', new Node('A'));

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            Node parentNode = tree.get(data);

            if (left != '.') {
                Node leftChild = new Node(left);
                parentNode.left = leftChild;
                tree.put(left, leftChild);
            }
            if (right != '.') {
                Node rightChild = new Node(right);
                parentNode.right = rightChild;
                tree.put(right, rightChild);
            }
        }

        preorder(tree.get('A'));
        inorder(tree.get('A'));
        postorder(tree.get('A'));

        // 결과 출력
        System.out.println(preorderResult);
        System.out.println(inorderResult);
        System.out.println(postorderResult);
    }
}

