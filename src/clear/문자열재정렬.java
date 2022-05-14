package clear;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 문자열재정렬 {

    public static void main(String[] args) throws IOException {
        Node node = new Node(1, 1);
        Set<Node> set = new HashSet<>();
        List<Node> road = new ArrayList<>();
        set.addAll(road);
        set.add(node);
        set.remove(new Node(1,1));
        System.out.println(set.size());
    }


    static class Node {
        private int row;
        private int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (row != node.row) return false;
            return col == node.col;
        }

        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }
}
