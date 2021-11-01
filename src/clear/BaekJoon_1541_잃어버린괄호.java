package clear;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon_1541_잃어버린괄호 {

    public static void main(String[] args) throws IOException, ScriptException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String[] arr = br.readLine().split(" ");
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        int parenthesis = 0;

        for(char x : str.toCharArray()) {
            sb.append(x);
            if(x=='-') {
                sb.append('(');
                if(parenthesis % 2 != 0) {
                    sb = sb.insert(sb.length()-2,')');
                    parenthesis++;
                }
                parenthesis++;
            }
        }
        if(parenthesis%2!=0&&parenthesis>0) sb.append(')');


        String equation = sb.toString();
        //System.out.println(equation);


        ScriptEngineManager mng = new ScriptEngineManager();
        ScriptEngine eng = mng.getEngineByName("js");

        System.out.println(eng.eval(parsing(equation)).toString());



    }

    static String parsing(String equation) {

        StringBuilder strNumber = new StringBuilder();
        StringBuilder answer = new StringBuilder();

        for(int i = 0 ; i < equation.length() ; i ++) {
            if(!Character.isDigit(equation.charAt(i))) {

                if(strNumber.length()>0) {
                    answer.append(Integer.parseInt(strNumber.toString()));
                    strNumber = new StringBuilder();
                }
                answer.append(equation.charAt(i));

            } else {
                strNumber.append(equation.charAt(i));
            }
        }
        if(strNumber.length()>0) {
            answer.append(Integer.parseInt(strNumber.toString()));
            strNumber = new StringBuilder();
        }
        //System.out.println(answer.toString());
        return answer.toString();

    }

}