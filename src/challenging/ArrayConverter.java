package challenging;

public class ArrayConverter {

    public static void main(String[] args) {
        String before = "[[1,2]]";
        String _l = before.replace("[", "{");
        String _r = _l.replace("]", "}");
        System.out.println(_r);
    }
}
