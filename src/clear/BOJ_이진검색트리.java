package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_이진검색트리 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        BinarySearchTree bst = new BinarySearchTree(new Node(root));
        String input;
        while (true) {
            input = br.readLine();
            if (input == null || input.equals("")) break;
            bst.append(bst.getRoot(), Integer.parseInt(input));
        }
        System.out.println(bst.postOrder(bst.getRoot()));
    }

    static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(Node root) {
            this.root = root;
        }

        public Node getRoot() {
            return root;
        }

        public void append(Node node, int data) {
            if (node.data > data) {
                if (node.left == null) {
                    node.left = new Node(data);
                    return;
                }
                append(node.left, data);
            }
            if (node.data < data) {
                if (node.right == null) {
                    node.right = new Node(data);
                    return;
                }
                append(node.right, data);
            }
        }

        public String postOrder(Node node) {
            if (node == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(postOrder(node.left));
            sb.append(postOrder(node.right));
            sb.append(node.data+"\n");
            return sb.toString();
        }
    }

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }


}
