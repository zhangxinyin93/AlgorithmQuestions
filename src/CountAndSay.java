/**
 * Base when we see 1 say 1
 * n=2, previous digit is 1, and we see one 1->11
 * n=3, in previous number 2 we see two 1->21
 * n=4, in precious number 3 we see one 2 and one 1->1211
 */
public class CountAndSay {
    public String countAndSay(int n) {
        // Write your code here
        if(n == 0) {
            return new String("1");
        }
        String old = "1";
        for(int i = 1; i < n; i++) {
            char[] oldChars = old.toCharArray();
            StringBuilder sb = new StringBuilder();

            for(int j = 0; j < oldChars.length; j++) {
                int count = 1;
                while(j != oldChars.length-1 && oldChars[j] == oldChars[j+1]) {
                    count++;
                    j++;
                }
                sb.append(count);
                sb.append(oldChars[j]);
                // Or can write like sb.append(String.valueOf(count)+String.valueOf(oldChars[j]))
            }
            old = sb.toString();
        }
        return old;
    }

    public static void main(String[] args) {
        CountAndSay countAndSay = new CountAndSay();
        String x = countAndSay.countAndSay(1);
        System.out.println(x);
    }
}
