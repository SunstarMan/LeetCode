package sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*面试题45. 把数组排成最小的数
输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
输入: [10,2]
输出: "102"
提示:0 < nums.length <= 100
说明:输出结果可能非常大，所以你需要返回一个字符串而不是整数
拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class Solution45 {
    public String minNumber(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String temp1 = o1 + "" + o2;
                String temp2 = o2 + "" + o1;
                return temp1.compareTo(temp2);
            }
        });

        StringBuffer stringBuffer=new StringBuffer();
        for (int i = 0; i < nums.length; i++) {
            stringBuffer.append(list.get(i));
        }

        String ans=stringBuffer.toString();
        return ans;
    }

    public static void main(String[] args) {
        int[] a={3,30,34,5,9};
        System.out.println(new Solution45().minNumber(a));
    }
}
