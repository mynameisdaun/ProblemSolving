package clear;

public class 합이같은부분집합 {

    public static boolean flag = false;

    public static void main(String[] args) {
        int N = 6;
        int[] arr = {1,3,5,6,7,10};
        합이같은부분집합 solution = new 합이같은부분집합();
        solution.solution(N, arr);
    }

    public void solution(int N, int[] arr) {
        DFS(0,0,arr,N,32);
    }

    public void DFS (int L, int S, int[] arr, int N, int total) {
        if(flag) return;
        if(S * 2 > total ) return;
        if(L==N) {
            if(S * 2 == total) {
                System.out.println("YES");
                flag=true;
            }
        } else {
          DFS(L+1,S +arr[L], arr, N, total);
          DFS(L+1, S, arr, N, total);
        }

    }
}
