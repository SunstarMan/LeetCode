package hashTable;

import java.util.HashSet;
import java.util.Set;

/*宝石与石头
给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，
你想知道你拥有的石头中有多少是宝石。
J中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
输入: J = "aA", S = "aAAbbbb"
输出: 3
 */
public class Solution771 {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<Character>();
        int count=0;
        char[] ch1=J.toCharArray();
        char[] ch2=S.toCharArray();

        /*for (int i=0;i<ch1.length;i++){
            set.add(ch1[i]);
        }*/

        for (char c : ch1) {
            set.add(c);
        }

        for (char c : ch2) {
            if (set.contains(c)){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        String gemstone="aA";
        String tone="aAAddde";
        System.out.println(new Solution771().numJewelsInStones(gemstone,tone));
    }
}
