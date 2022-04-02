package challenging;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.print(solution.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"}));
    }

        public int solution(int cacheSize, String[] cities) {
            int answer = 0;
            Node head = new Node("head");
            Node tail = new Node("tail");
            head.next=tail;
            tail.prev=head;
            int currentCache = 0 ;

            for(String x : cities) {

                String city = x.toLowerCase();
                System.out.println("currCity: "+city);
                Node node = head.next;
                boolean hit = false;

                while(node.next!=null) {
                    System.out.print(node.name+" ");
                    if(city.equals(node.name)) {
                        hit = true;
                        break;
                    }
                    node = node.next;
                }
                System.out.println();
                answer += hit ? 1 : 5;

                if(hit) {
                    //연결끊기
                    System.out.println("찾은노드:"+node.name);

                    Node prevNode = node.prev;
                    System.out.println("찾은노드이전:"+prevNode.name);
                    prevNode.next = node.next;
                    prevNode.next.prev=prevNode;
                    currentCache--;
                }
                else if(cacheSize!=0&&cacheSize==currentCache) {
                    //맨마지막노드 아웃;
                    Node lastNode = tail.prev;
                    tail.prev=lastNode.prev;
                    tail.prev.next=tail;
                    currentCache--;
                }

                if (cacheSize > currentCache) {
                    Node firstNode = head.next;
                    head.next = new Node(city);
                    head.next.next = firstNode;
                    head.next.prev=head;
                    firstNode.prev=head.next;
                    currentCache++;
                }

                System.out.println("====");
                Node curr = head;
                while(curr.next!=null) {
                    System.out.print(curr.name+" ");
                    curr = curr.next;
                }
                System.out.println();
                System.out.println("====");
            }
            return answer;
        }

        class Node {
            private String name;
            private Node prev;
            private Node next;

            public Node(String name) {
                this.name=name;
            }
        }
}
