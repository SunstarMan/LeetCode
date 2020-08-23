package dailyquestion;

import java.util.*;

/*179. 最大数
给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
示例 1:输入: [10,2]
输出: 210
示例 2:输入: [3,30,34,5,9]
输出: 9534330
说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class Solution179 {
    public String largestNumber(int[] nums) {
        int len = nums.length;
        boolean flag=false;
        List<String> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i]!=0) flag=true;
            list.add(String.valueOf(nums[i]));
        }

        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String a = o1 + o2;
                String b = o2 + o1;
                return b.compareTo(a);
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < len; i++) {
            stringBuilder.append(list.get(i));
        }
        if (flag) return stringBuilder.toString();
        else return "0";
    }
}
