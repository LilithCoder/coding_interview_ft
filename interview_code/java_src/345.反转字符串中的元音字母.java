class Solution {
    public String reverseVowels(String s) {
        if (s == null) return null;
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
        char[] result = new char[s.length()];
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            char left_ch = s.charAt(left);
            char right_ch = s.charAt(right);
            if (!vowels.contains(left_ch)) {
                result[left++] = left_ch;
            } else if (!vowels.contains(right_ch)) {
                result[right--] = right_ch;
            } else {
                result[left++] = right_ch;
                result[right--] = left_ch;
            }
        }
        return new String(result);
    }
}