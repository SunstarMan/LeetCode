package bfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*17. 电话号码的字母组合
给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] s = new String[digits.length()];
        int len = digits.length();
        Map<Character, String> map = new HashMap<>();

        if (s.length == 0) {
            return ans;
        }
        for (int i = 0; i < digits.length(); i++) {
            switch (digits.charAt(i)) {
                case '2':
                    s[i] = "abc";
                    break;
                case '3':
                    s[i] = "def";
                    break;
                case '4':
                    s[i] = "ghi";
                    break;
                case '5':
                    s[i] = "jkl";
                    break;
                case '6':
                    s[i] = "mno";
                    break;
                case '7':
                    s[i] = "pqrs";
                    break;
                case '8':
                    s[i] = "tuv";
                    break;
                case '9':
                    s[i] = "wxyz";
                    break;
            }
        }
//        map.put('2', "abc");
//        map.put('3', "def");
//        map.put('4', "ghi");
//        map.put('5', "jkl");
//        map.put('6', "mno");
//        map.put('7', "pqrs");
//        map.put('8', "tuv");
//        map.put('9', "wxyz");

        Recur(s, 0, ans, "");
        return ans;
    }


    private static void Recur(String[] str, int index, List<String> list, String temp) {
        if (index == str.length - 1) {
            for (int i = 0; i < str[index].length(); i++) {
                list.add(temp + str[index].charAt(i));
            }
        } else {
            for (int i = 0; i < str[index].length(); i++) {
                Recur(str, index + 1, list, temp + str[index].charAt(i));
            }
        }
    }

}
