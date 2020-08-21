class Solution {
    int i = 0;
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (; i < s.length(); i++) {
            char ch = s.charAt(i);
            // 如果是数字
            if (Character.isDigit(ch)) num = 10 * num + (ch - '0');
            if (ch == '(') {
                i++;
                num = calculate(s);
            }
            // 遇到新的符号以及i走到算式的尽头时引发入栈
            if (!Character.isDigit(ch) && ch != ' ' || i == s.length() - 1) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    int pre = stack.pop();
                    stack.push(pre * num);
                } else if (sign == '/') {
                    int pre = stack.pop();
                    stack.push(pre / num);
                }
                sign = ch;
                num = 0;
            }
            if (ch == ')') break;
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}