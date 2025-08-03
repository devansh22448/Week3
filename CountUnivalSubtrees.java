import java.util.*;

class Node {
    int val;
    Node left, right;

    Node(int val) {
        this.val = val;
    }
}

public class CountUnivalSubtrees {

    private int count = 0;

    public int countUnivalSubtrees(Node root) {
        isUnival(root);
        return count;
    }

    private boolean isUnival(Node node) {
        if (node == null) return true;

        boolean left = isUnival(node.left);
        boolean right = isUnival(node.right);

        if (!left || !right) return false;

        if (node.left != null && node.left.val != node.val) return false;
        if (node.right != null && node.right.val != node.val) return false;

        count++;
        return true;
    }

    public static Node buildTreeFromInput(String[] input) {
        if (input.length == 0 || input[0].equals("null")) return null;

        Node root = new Node(Integer.parseInt(input[0]));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < input.length) {
            Node current = queue.poll();

            if (i < input.length && !input[i].equals("null")) {
                current.left = new Node(Integer.parseInt(input[i]));
                queue.offer(current.left);
            }
            i++;

            if (i < input.length && !input[i].equals("null")) {
                current.right = new Node(Integer.parseInt(input[i]));
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the tree in level order (use 'null' for empty nodes):");
        String line = scanner.nextLine();
        String[] input = line.trim().split("\\s+");

        Node root = buildTreeFromInput(input);

        CountUnivalSubtrees counter = new CountUnivalSubtrees();
        int result = counter.countUnivalSubtrees(root);
        System.out.println(result);
    }
}
