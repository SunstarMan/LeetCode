package hashTable;

import java.util.HashMap;
import java.util.Map;

/*拼写单词
给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
注意：每次拼写（指拼写词汇表中的一个单词）时，chars 中的每个字母都只能用一次。
返回词汇表 words 中你掌握的所有单词的 长度之和。
输入：words = ["cat","bt","hat","tree"], chars = "atach"
输出：6
 */
public class Solution1160 {
    public int countCharacters(String[] words, String chars) {
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> tempMap = new HashMap<>();

        for (int i = 0; i < chars.length(); i++) {
            int m = map.getOrDefault(chars.charAt(i), 0);
            map.put(chars.charAt(i), m + 1);
        }

        for (int i = 0; i < words.length; i++) {
            boolean contain = true;

            tempMap.clear();
            for (Map.Entry<Character, Integer> m : map.entrySet()) {
                tempMap.put(m.getKey(), m.getValue());
            }


            for (int j = 0; j < words[i].length(); j++) {
                if (tempMap.containsKey(words[i].charAt(j))) {
                    tempMap.put(words[i].charAt(j), tempMap.get(words[i].charAt(j)) - 1);
                    if (tempMap.get(words[i].charAt(j)) == -1) {
                        break;
                    }
                } else {
                    contain = false;
                    break;
                }
            }

            if (!tempMap.containsValue(-1) && contain) {
                result += words[i].length();
            }

        }

        return result;
    }

    public static void main(String[] args) {
        String[] a={"cat","bt","hat","tree"};
        String ch="atach";
        int ans=new Solution1160().countCharacters(a,ch);
        System.out.println(ans);
    }
}
