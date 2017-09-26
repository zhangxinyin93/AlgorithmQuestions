package dothis.one.more.time;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 * For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]

 */
public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> validParenthesis = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        generateParenthesisHelper(validParenthesis, builder, 0, 0, n);
        return validParenthesis;
    }

    private void generateParenthesisHelper(List<String> validParenthesis, StringBuilder builder,
                                           int openParenthesis, int closeParenthesis, int target) {
        if (builder.length() == target * 2) {
            validParenthesis.add(builder.toString());
            return;
        }

        // 最多可以添加这么多的左括号
        if (openParenthesis < target) {
            builder.append('(');
            generateParenthesisHelper(validParenthesis, builder, openParenthesis+1, closeParenthesis, target);
            builder.deleteCharAt(builder.length() - 1);
        }

        // 相当于可以看成每添加一个左括号都要与之匹配一个右括号，这样最后的结果一定是Valid的
        if (closeParenthesis < openParenthesis) {
            builder.append(')');
            generateParenthesisHelper(validParenthesis, builder, openParenthesis, closeParenthesis+1, target);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
