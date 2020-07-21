// 写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。（多组同时输入 ）

// 输入描述:
// 输入一个十六进制的数值字符串。

// 输出描述:
// 输出该数值的十进制字符串。

// 输入例子1:
// 0xA
// 输出例子1:
// 10

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String str = s.nextLine().substring(2);
            int bit = 0;
            int result = 0;
            for (int i = str.length() - 1; i >= 0; i--) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    result += (ch - '0') * Math.pow(16, bit++);
                }
                if (ch >= 'A' && ch <= 'F') {
                    result += (ch - 'A' + 10) * Math.pow(16, bit++);
                }
            }
            System.out.println(result);
        }
    }
}