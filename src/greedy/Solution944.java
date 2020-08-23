package greedy;

import java.util.Arrays;

/*944. 删列造序
给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，
形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
比如，有 A = ["abcdef", "uvwxyz"]，
要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是非降序排列的，然后请你返回 D.length 的最小可能值。
 */
public class Solution944 {

    private static boolean equals(char[] ch1, char[] ch2) {
        String string1 = new String(ch1);
        String string2 = new String(ch2);
        return string1.equals(string2);
    }

    private static char[] sort(char[] ch) {
        Arrays.sort(ch);
        return ch;
    }

    public static int minDeletionSize(String[] A) {
        int answer = 0;
        int len1 = A.length;
        int len2=A[0].length();
        char[] ch = new char[len1];//存每一列字母的数组
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < len1; i++) {
            sb.append(A[i]);
        }
        String s = sb.toString();

        char[] aToChar; //创建一个字符数组aToChar
        aToChar = s.toCharArray(); //将字符串变量转换为字符数组
        char[] copy = new char[len1];


        for (int j = 0; j < len2; j++) {
            for (int i = j; i < (len2 * len1); i = i + len2) {
                ch[(i-j)/len2] = aToChar[i];
            }

            for (int h = 0; h < len1; h++) {
                copy[h] = ch[h];
            }

            if (!equals(sort(ch), copy)) {
                answer++;
            }
            ch = new char[ch.length];
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] A = {"rrjk","furt","guzm"};
        System.out.println(minDeletionSize(A));
    }
}