import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by zhangxinyin on 10/8/16.
 */
public class Anagrams {
    public List<String> anagrams(String[] strs) {
        // write your code here
        if(strs == null || strs.length == 0) {
            return null;
        }

        List<String> answer = new ArrayList<String>();
        HashMap<Integer,ArrayList<String>> stringToHash = new HashMap<>();

        for(String str : strs) {
            int count[] = new int[26];
            for(int i = 0; i < str.length(); i++){
                count[str.charAt(i)-'a']++;
            }

            int hashKey = getHash(count);
            if(!stringToHash.containsKey(hashKey)) {
                stringToHash.put(hashKey,new ArrayList<String>());
            }

            stringToHash.get(hashKey).add(str);
        }
        for(ArrayList<String> possibleAnagram : stringToHash.values()){
            if(possibleAnagram.size() > 1){
                answer.addAll(possibleAnagram);
            }
        }
        return answer;
    }

    // Have your own hash function so that we won't have duplicate when we add there ascii
    // Magic!!!!
    private int getHash(int[] count) {
        int hash = 0;
        int a = 8934;
        int b = 3923;

        for(int m : count) {
            hash = hash * a + m;
            a = a + b;
        }
        return hash;
    }
}
