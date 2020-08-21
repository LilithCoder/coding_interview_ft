class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Arrays.sort(logs, new Comparator<String>() {
            public int compare(String str1, String str2) {
                char ch1 = str1.charAt(str1.length() - 1);
                char ch2 = str2.charAt(str2.length() - 1);
                // 二者都是数字日志
                if (Character.isDigit(ch1) && Character.isDigit(ch2)) {
                    return 0;
                } else if (Character.isDigit(ch1)) {
                    // ch1是数字日志, ch2是字母日志, 字母日志在数字日志之前
                    return 1;
                } else if (Character.isDigit(ch2)) {
                    return -1;
                } else {
                    String[] split1 = str1.split(" ", 2);
                    String[] split2 = str2.split(" ", 2);
                    return split1[1].compareTo(split2[1]) != 0 ? split1[1].compareTo(split2[1]) : split1[0].compareTo(split2[0]);
                }
            }
        });
        return logs;
    }
}