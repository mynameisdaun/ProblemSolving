package challenging;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class Main {

    static int N, v, e, d, parent[];
    static long distance[];

    public static void union(int a, int b) {
        if (a != b) {
            if (a > b) {
                parent[b] = a;
            } else {
                parent[a] = b;
            }
        }
    }

    public static int find(int n) {
        return parent[n] == n ? n : (parent[n] = find(parent[n]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        parent = new int[N + 1];
        distance = new long[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<List<Integer>>((a, b) -> a.get(0) - b.get(0));
        for (int t = 0; t < N; t++) {
            pq.offer(
                    Arrays.stream(br.readLine().split(" "))
                            .mapToInt(Integer::parseInt)
                            .boxed()
                            .collect(Collectors.toList())
            );
        }
        while (!pq.isEmpty()) {
            List<Integer> list = pq.poll();
            v = find(list.get(0));
            for (int i = 1; i < list.size() - 1; i += 2) {
                e = find(list.get(i));
                System.out.println("v: "+v+" e: "+e);
                d = list.get(i + 1);
                if (v != e) {
                    distance[e] = Math.max(distance[v] + d, distance[e]);
                    for (int j = 1; j <= N; j++) {
                        System.out.print(distance[j]+" ");
                    }
                    System.out.println();
                    union(v, e);
                }
            }
        }
        System.out.println(distance[N]);;
    }
}
/*
5
1 3 2 -1
5 4 6 -1
3 1 2 4 3 -1
2 4 4 -1
4 2 4 3 3 5 6 -1
 */
/*
5
1 5 1 -1
5 1 1 4 10 -1
4 3 10 5 10 -1
3 2 10 4 10 -1
2 3 10 -1
 */

