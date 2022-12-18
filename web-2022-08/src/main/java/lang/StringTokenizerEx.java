package lang;

import java.util.StringTokenizer;

import org.apache.catalina.tribes.util.Arrays;

public class StringTokenizerEx {
    public void test() {
        String source = "a/b////---///d/e/f,,,,/12314533,,//-----";
        // 만약에 source를 StringTokenizer로 쪼개면 a b d e f 12314533만 유효의 값, 나머지는 무효의 값.
        StringTokenizer st = new StringTokenizer(source, "/-,");
        System.out.println("token size : " + st.countTokens());
        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            System.out.println(s);
           }
        System.out.println("-".repeat(20));
        String[] array = source.split("/|-|,");
        System.out.println(Arrays.toString(array));
    }
    
    public static void main(String[] args) {
        StringTokenizerEx ex = new StringTokenizerEx();
        ex.test();
    }
}
