package ps;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

class Solution1 {

    public static void main(String[] args) throws ParseException {

        Date from  = new Date();
        SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String to = transFormat.format(from);

        System.out.println(to);

        long a = System.currentTimeMillis();
        System.out.println(a);

        System.out.println(transFormat.format(a));
        a -= 6 ;
        System.out.println(transFormat.format(a));





    }

    static int[] hi () {
        return null;
    }


}