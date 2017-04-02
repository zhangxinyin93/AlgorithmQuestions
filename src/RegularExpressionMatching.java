/**
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.指的是*前面那个字母，这个字母可以match
 * 0到任何次数，只要需要，但是是需要都是连续的
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        return matching(s, p, 0, 0);
    }

    private boolean matching(String s, String p, int sindex, int pindex) {
        // 递归的出口
        // 此时pattern已经用完了
        if(pindex >= p.length()) {
            return sindex >= s.length();
        }

        // pattern走到了最后一个
        if(pindex == p.length() - 1) {
            return sindex == s.length() - 1 && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.');
        }

        // 当pattern当前character的下一个不是'*'时
        if (p.charAt(pindex + 1) != '*') {
            // S走完了，但是pattern还没有走完
            if(sindex >= s.length()) {
                return false;
            }

            // 当前字符匹配
            if(s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.') {
                return matching(s, p, sindex + 1, pindex + 1);
            } else {
                return false;
            }
        }

        // 下一个是*，且当前字符匹配，就开始尝试当前字符可以从0开始匹配，任何匹配次数使剩下的字符串都匹配时就算成功
        while (sindex < s.length() && (s.charAt(sindex) == p.charAt(pindex) || p.charAt(pindex) == '.')) {
            if(matching(s, p, sindex, pindex + 2)) {
                return true;
            }

            sindex++;
        }

        // 下一个是*，但是当前不匹配，pattern往后跳两个
        // 所以这样子可以保证后面例如进入了while循环的时候前面都是匹配上了
        // 只用从进入while循环的那个sindex开始往后匹配了sindex, sindex + 1, sindex + 2....
        return matching(s, p, sindex, pindex + 2);
    }

    // TODO: Using DP to solve this problem
}
