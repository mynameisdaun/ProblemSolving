package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class BOJ_1991_트리순회 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Tree tree = new Tree("A");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(br.readLine());
        }

        while (!queue.isEmpty()) {
            String input = queue.poll();
            String[] arr = input.split(" ");
            String data = arr[0];
            String left = arr[1];
            String right = arr[2];

            Node node = tree.search(tree.getRoot(), data);
            if (node == null) {
                queue.offer(input);
                System.out.println("can not find");
                continue;
            }
            tree.append(data, left, right);
        }

        System.out.println(tree.preorder(tree.getRoot()));
        System.out.println(tree.inorder(tree.getRoot()));
        System.out.println(tree.postorder(tree.getRoot()));

    }

    static class Tree {
        private Node root;

        public Node getRoot() {
            return root;
        }

        public Tree(String root) {
            this.root = new Node(root);
        }

        public void append(String data, String left, String right) {
            Node node = search(root, data);
            if (!left.equals(".")) {
                node.left = new Node(left);
            }
            if (!right.equals(".")) {
                node.right = new Node(right);
            }
        }

        public String preorder(Node node) {
            if (node == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(node.data);
            sb.append(preorder(node.left));
            sb.append(preorder(node.right));
            return sb.toString();
        }

        public String inorder(Node node) {
            if (node == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(inorder(node.left));
            sb.append(node.data);
            sb.append(inorder(node.right));
            return sb.toString();
        }

        public String postorder(Node node) {
            if (node == null) {
                return "";
            }
            StringBuilder sb = new StringBuilder();
            sb.append(postorder(node.left));
            sb.append(postorder(node.right));
            sb.append(node.data);
            return sb.toString();
        }

        public Node search(Node node, String data) {
            if (root.data.equals(data)) return root;

            if (node == null) return null;

            if (node.left != null && node.left.data.equals(data)) {
                return node.left;
            }
            if (node.right != null && node.right.data.equals(data)) {
                return node.right;
            }

            Node fromLeft = null;
            if (node.left != null) {
                fromLeft = search(node.left, data);
            }
            Node fromRight = null;
            if (node.right != null) {
                fromRight = search(node.right, data);
            }
            if (fromLeft != null)
                return fromLeft;
            return fromRight;
        }
    }

    static class Node {
        private String data;
        private Node left;
        private Node right;

        public Node(String data) {
            this.data = data;
        }

        public boolean isLeaf() {
            return this.left == null && this.right == null;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return Objects.equals(data, node.data);
        }

        @Override
        public int hashCode() {
            return data != null ? data.hashCode() : 0;
        }
    }
}
