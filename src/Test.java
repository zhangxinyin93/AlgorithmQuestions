/**
 * Created by zhangxinyin on 10/8/16.
 */
public class Test {
    public static void main(String[] args) {
        String x = "1+2";
        String[] test = x.split("[+]");
        System.out.println(test.length);
    }
}
