package again;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class BaekJoon_DSLR_fail {

    static int N;
    static StringBuilder SB;
    static StringBuilder LR;
    static StringBuilder RR;
    static StringBuilder sb;
    static char[] arr = {'S','D','L','R'};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i ++) {
            String[] str = br.readLine().split(" ");
            //String register = str[0];
            String register = String.format("%4s",str[0]).replace(' ', '0');
            //String target   = str[1];
            String target = String.format("%4s",str[1]).replace(' ', '0');
            SB = new StringBuilder();
            DFS(0, register, target);
            System.out.println(SB.toString());
        }
    }

    static boolean DFS(int L, String register, String target) {
        //System.out.printf("register: %s, target: %s \n",register, target);
        if(register.equals(target))  return true;
        if(isEdge(register, target)) return true;
        if(hasSameCharacter(register, target)) {
            rotation(register, target);
            return true;
        }

        int intRegister = Integer.parseInt(register);
        int intTarget = Integer.parseInt(target);

        if(intRegister <= intTarget ) {
            boolean b = DFS(L+1, D(register), target);
            if(b) return true;
        }
        return DFS(L+1, S(register), target);
    }
    static void rotation(String register, String target) {
        LR = new StringBuilder();
        LRotation(register, target);
        RR = new StringBuilder();
        RRotation(register, target);
        if(LR.length() <= RR.length()) {
            SB.append(LR);
        } else {
            SB.append(RR);
        }
    }

    static boolean LRotation(String register, String target) {
        if(register.equals(target)) return true;
        return LRotation(L(register), target);
    }

    static boolean RRotation(String register, String target) {
        if(register.equals(target)) return true;
        return RRotation(R(register), target);
    }


    static boolean hasSameCharacter(String register, String target) {
        Set<Character> setRegister = new HashSet<Character>();
        Set<Character> setTarget = new HashSet<Character>();

        System.out.printf("register: %s, target: %s \n",register, target);
        for(int i = 0 ; i < 4 ; i ++) {
            setRegister.add(register.charAt(i));
            setTarget.add(target.charAt(i));
        }

        for(int i = 0 ; i < 4 ; i ++) {
            if(
                !setRegister.contains(target.charAt(i)) ||
                !setTarget.contains(register.charAt(i))
              ) {
                System.out.println("nonmatch!");
                return false;
            }
        }
        return true;
    }

    static boolean isEdge(String register, String target) {
        int intRegister = Integer.parseInt(register);
        int intTarget = Integer.parseInt(target);

        if(
            (register.equals("0000")&&target.equals("9999")) ||
            (intRegister-intTarget ==1)
          ) {
            SB.append('S');
            return true;
        }
        return false;
    }

    static String D(String str) {
        SB.append('D');
        int number = Integer.parseInt(str);
        number = (number * 2) % 10000 ;
        return String.format("%4s",number).replace(' ', '0');
    }

    static String S(String str) {
        SB.append('S');
        int number = Integer.parseInt(str);
        return String.format("%4s",number-1).replace(' ', '0');
    }

    static String L(String str) {
        //System.out.println("left: "+str);
        LR.append('L');
        sb = new StringBuilder(str);
        sb.append(sb.charAt(0));
        return sb.substring(1,5);
    }

    static String R(String str) {
        //System.out.println("right: "+str);
        RR.append('R');
        sb = new StringBuilder(str);
        sb.insert(0,sb.charAt(sb.length()-1));
        return sb.substring(0,sb.length()-1);
    }
}



