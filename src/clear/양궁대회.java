package clear;

class 양궁대회 {
    static int[] answer;
    static int max = Integer.MIN_VALUE;

    public int[] solution(int n, int[] info) {
        DFS(0, new boolean[11], info, n);
        if(answer == null) {
            return new int[]{-1};
        }
        return answer;
    }

    public void DFS(int L, boolean[] win, int[] info, int n) {
        if(L==info.length) {
            checkPossibleAnswer(win, info, n);
        } else {
            win[L]=true;
            DFS(L+1, win, info, n);
            win[L]=false;
            DFS(L+1, win, info, n);
        }
    }

    public void checkPossibleAnswer(boolean[] win, int[] info, int n) {
        int ryan = 0;
        int appeach = 0;
        int[] tmp = new int[11];

        for(int i=0 ; i<win.length ; i++) {
            if(!win[i]&&info[i]==0) continue;
            if(!win[i]&&info[i]>0) {
                appeach += 10-i;
            }
            if(win[i]) {
                ryan += 10-i;
                n -= (info[i]+1);
                tmp[i] = info[i]+1;
            }
        }
        if(ryan-appeach < max || n < 0) return;

        int index = 10;
        while(n>0 && index>=0) {
            if(win[index]) {
                tmp[index] += n;
                break;
            }
            if(info[index]-tmp[index]-1 >= 1) {
                int t = Math.min(info[index]-tmp[index]-1, n);
                tmp[index] += t;
                n -=t;
            }
            index--;
        }

        if(ryan>appeach && ryan-appeach > max) {
            answer = tmp;
            max = ryan-appeach;
        } else if(ryan>appeach && ryan-appeach == max) {
            for(int i = 10 ; i>=0 ; i--) {
                if(tmp[i] > answer[i]) {
                    answer=tmp;
                    return;
                }
                if(tmp[i] < answer[i]) {
                    return;
                }
            }
        }
    }
}
