package bit;

/*318. 最大单词长度乘积
给定一个字符串数组 words，找到 length(word[i]) * length(word[j]) 的最大值，并且这两个单词不含有公共字母。
你可以认为每个单词只包含小写字母。如果不存在这样的两个单词，返回 0。
输入: ["abcw","baz","foo","bar","xtfn","abcdef"]
输出: 16
解释: 这两个单词为 "abcw", "xtfn"。
 */
public class Solution318 {
    public int maxProduct(String[] words) {
        int len = words.length;
        //boolean[][] bits = new boolean[len][26];
        int[] numbers = new int[len];
        for (int i = 0; i < len; i++) {
            boolean[] bits = new boolean[26];
            for (int j = 0; j < words[i].length(); j++) {
                bits[words[i].charAt(j) - 'a'] = true;
            }
            int bit = 1;
            int t = 0;
            for (int j = 0; j < 26; j++) {
                if (bits[j]) t = t | bit;
                bit = bit << 1;
            }
            numbers[i] = t;
        }

        int ans = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if ((numbers[i] & numbers[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;

//        for (int i = 0; i < len; i++) {
//            for (int j = 0; j < words[i].length(); j++) {
//                bits[i][words[i].charAt(i) - 'a'] = true;
//            }
//        }
//        for (int i = 0; i < len; i++) {
//            int bit = 1;
//            int temp = 0;
//            for (int j = 0; j < 26; j++) {
//                if (bits[i][j]) {
//                    temp = temp | bit;
//                }
//                bit = bit << 1;
//            }
//            numbers[i] = temp;
//        }

    }

    public static void main(String[] args) {
        String[] s={"abcw","baz","foo","bar","xtfn","abcdef"};
        System.out.println(new Solution318().maxProduct(s));
    }
}
