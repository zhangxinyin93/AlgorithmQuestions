import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {

    public boolean isValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        if (s.length() % 2 != 0) {
            return false;
        }

        Stack<Character> parentheses = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parenthes = s.charAt(i);
            if (parenthes == '(' || parenthes == '[' || parenthes == '{') {
                parentheses.push(parenthes);
            } else {

                // 注意这里的stack可能会为空,顺便就可以判断从来没有入过栈的全是右括号的情况
                if (!parentheses.isEmpty()) {
                    char top = parentheses.peek();
                    if (top == '(' && parenthes == ')' ||
                            top == '[' && parenthes == ']' ||
                            top == '{' && parenthes == '}') {
                        parentheses.pop();
                    }

                    // 如果栈是空,就是一直没有左括号进来过,可以return false了
                } else {
                    return false;
                }
            }
        }

        return parentheses.isEmpty();
    }
}
