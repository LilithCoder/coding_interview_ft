class Solution {
    // 本题思路：
    // 本题中可能出现括号嵌套的情况，比如 2[a2[bc]]，这种情况下我们可以先转化成2[abcbc]，再转化成abcbcabcbc
    // 如果当前的字符为数位，解析出一个数字（连续的多个数位）并进栈
    // 如果当前的字符为字母或者左括号，直接进栈
    // 如果当前的字符为右括号，开始出栈，一直到左括号出栈，出栈序列反转后拼接成一个字符串，此时取出栈顶的数字，就是这个字符串应该出现的次数，我们根据这个次数和字符串构造出新的字符串并进栈
    // 最终将栈中的元素按照从栈底到栈顶的顺序拼接起来，就得到了答案
    public String decodeString(String s) {
        int index = 0;
        LinkedList<String> stack = new LinkedList<>();
        while (index < s.length()) {
            char curr = s.charAt(index);
            
            // 得到一个数字并入栈
            if (Character.isDigit(curr)) {
                // 得到数字的过程
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(index))) {
                    sb.append(s.charAt(index));
                    index++;
                }
                stack.addLast(sb.toString());
            }
            
            // 如果是字母或[，直接入栈
            if (Character.isLetter(curr) || curr == '[') {
                stack.addLast(String.valueOf(s.charAt(index)));
                index++;
            }
            
            // 如果是]，将[]的字符串pop出，根据[前的次数构建新的字符串，并入栈
            if (curr == ']') {
                
                // [前所有的字符串出栈
                LinkedList<String> segment_str_list = new LinkedList<>();
                while (!stack.peekLast().equals("[")) {
                    segment_str_list.add(stack.removeLast());
                }
                
                // 倒序
                Collections.reverse(segment_str_list);
                
                // 得到当前的segment_str
                StringBuilder segment_str = new StringBuilder();
                for (String temp: segment_str_list) {
                    segment_str.append(temp);
                }
                
                // 左括号出栈
                stack.removeLast();
                
                // 得到当前segment_str出现的次数
                int time = Integer.parseInt(stack.removeLast());
                
                // 根据这个字符串出现的次数，构造新的字符串并入栈
                StringBuilder new_str = new StringBuilder();
                for (int i = 0; i < time; i++) {
                    new_str.append(segment_str.toString());
                }
                stack.addLast(new_str.toString());
                index++;
            }
        }
        StringBuilder res = new StringBuilder();
        for (String temp: stack) {
            res.append(temp);
        }
        return res.toString();
    }
}