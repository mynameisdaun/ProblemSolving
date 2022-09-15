package clear;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BOJ_4195_친구네트워크 {

    public static void union(int[] parent, int a, int b, Map<Integer, Set<Integer>> network) {
        int a_parent = find(parent, a);
        int b_parent = find(parent, b);

        Set<Integer> aNetwork = network.get(a_parent);
        Set<Integer> bNetwork = network.get(b_parent);

        if (a_parent < b_parent) {
            bNetwork.forEach(n-> parent[n] = a_parent);
            aNetwork.addAll(bNetwork);
            network.put(a_parent, aNetwork);
            parent[b_parent] = a_parent;
        } else {
            aNetwork.forEach(n-> parent[n] = b_parent);
            bNetwork.addAll(aNetwork);
            network.put(b_parent, bNetwork);
            parent[a_parent] = b_parent;
        }

    }

    public static int find(int[] parent, int i) {
        if (parent[i] == i)
            return i;
        return parent[i] = find(parent, parent[i]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tcase = Integer.parseInt(br.readLine());
        while (tcase-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] parents = new int[200000];
            for (int i = 0; i < parents.length; i++) {
                parents[i] = i;
            }

            Map<String, Integer> map = new HashMap<>();
            Map<Integer, Set<Integer>> network = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                String a = input[0];
                String b = input[1];

                Integer indexA = map.get(a);
                if(indexA == null) {
                    indexA = map.size();
                    map.put(a, indexA);
                    Set<Integer> aSet = new HashSet<>();
                    aSet.add(indexA);
                    network.put(indexA, aSet);
                }

                Integer indexB = map.get(b);
                if(indexB == null) {
                    indexB = map.size();
                    map.put(b, indexB);
                    Set<Integer> bSet = new HashSet<>();
                    bSet.add(indexB);
                    network.put(indexB, bSet);
                }

                int a_parent = find(parents, indexA);
                int b_parent = find(parents, indexB);

                if (a_parent != b_parent) {
                    union(parents, indexA, indexB, network);
                }

                int idx = Math.min(a_parent, b_parent);
                System.out.println(network.get(idx).size());
            }

        }
    }
}
/*


 */
