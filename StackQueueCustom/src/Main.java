import java.util.Date;
import java.util.Stack;


public class Main {
    public static void main(String[] args) {
        StackCustom<Integer> st = new StackCustom<>();
        for(int i = 0; i < 5; i++) {
            st.push(i);
        }
        System.out.println(st.pop());
        System.out.println(st);
        System.out.println(st.size());

        Double d = 123.0;

    }
}
