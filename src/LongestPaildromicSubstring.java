/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.
 * Example:
 * given s = abcdzdcab return"cdzdc"
 */
public class LongestPaildromicSubstring {

    /**
     * 第一种方法, 最好理解的方法
     * 从每个中心展开, 进行搜索, 复杂度为O(n^2)
     * @param s
     *        input String
     */
    public String longestPalidrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        int max = Integer.MIN_VALUE;
        String maxString = "";

        // 字符串中的每个字符和字符与字符之间的间隙都可以是回文子串的中心
        // 偶数代表以字符为中心，奇数代表以字符之间的间隙为中心
        // 当i为偶数时，abc，以b为中心，那么从b开始向左右找回文即可
        // 当i为奇数是，abc，以b和c的间隙为中心，那么就要从b和c分别向左右
        for (int i = 0; i < s.length() * 2 - 1; i++) {
            int left = i / 2;
            int right = i / 2;

            if (i % 2 == 1) {
                right++;
            }

            String substring = findPalindrome(s,left,right);

            if (substring.length() > max) {
                max = substring.length();
                maxString = substring;
            }
        }

        return maxString;
    }

    private String findPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
