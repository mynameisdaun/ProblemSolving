package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class 수식트리 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String equation = "71*52-/";
        ExpressionTree et = new ExpressionTree(equation);
        System.out.println(et.preOrder(et.getRoot()));
        System.out.println(et.inOrder(et.getRoot()));
        System.out.println(et.postOrder(et.getRoot()));
        System.out.println(et.calculate(et.getRoot()));
    }

    static class ExpressionTree {
        private String equation;
        private Node root;

        private int pos;

        public Node getRoot() {
            return root;
        }

        public double calculate(Node node) {
            if (node == null) {
                return 0;
            }
            double left = calculate(node.left);
            double right = calculate(node.right);
            if (node.data == '+') {
                return left + right;
            }
            if (node.data == '-') {
                return left - right;
            }
            if (node.data == '*') {
                return left * right;
            }
            if (node.data == '/') {
                return left / right;
            }
            return Double.parseDouble(String.valueOf(node.data));
        }

        public ExpressionTree(String equation) {
            this.equation = equation;
            this.pos = equation.length() - 1;
            this.root = append();
        }

        public String preOrder(Node node) {
            if (node == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(node.data);
            sb.append(preOrder(node.left));
            sb.append(preOrder(node.right));
            return sb.toString();
        }

        public String inOrder(Node node) {
            if (node == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(inOrder(node.left));
            sb.append(node.data);
            sb.append(inOrder(node.right));
            return sb.toString();
        }

        public String postOrder(Node node) {
            if (node == null) return "";
            StringBuilder sb = new StringBuilder();
            sb.append(postOrder(node.left));
            sb.append(postOrder(node.right));
            sb.append(node.data);
            return sb.toString();
        }

        public Node append() {
            if (Character.isDigit(equation.charAt(pos))) {
                return new Node(equation.charAt(pos));
            }
            Node node = new Node(equation.charAt(pos));
            --pos;
            node.right = append();
            --pos;
            node.left = append();
            return node;
        }
    }

    static class Node {
        private char data;

        private Node left;
        private Node right;

        public Node(char data) {
            this.data = data;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return Objects.equals(data, node.data);
        }

    }
}
