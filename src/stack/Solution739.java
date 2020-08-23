package stack;

import java.util.Stack;

/*739. 每日温度
根据每日气温列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
如果之后都不会升高，请在该位置用 0 来代替。
例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class Solution739 {
    //    public int[] dailyTemperatures(int[] T) {
//        System.out.println(System.currentTimeMillis());
//        int len=T.length;
//        int[] ans=new int[len];
//        for (int i = 0; i < len-1; i++) {
//            for (int j = i+1; j < len; j++) {
//                if (T[j]>T[i]){
//                    ans[i]=j-i;
//                    break;//只跳出当前循环
//                }else {
//                    ans[i]=0;
//                }
//            }
//        }
//        ans[len-1]=0;
//        System.out.println(System.currentTimeMillis());//ms
//        return ans;
//    }
    public int[] dailyTemperatures(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stackValue = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();

        for (int i = 0; i < T.length; i++) {
            while (!stackValue.isEmpty() && T[i] > stackValue.peek()) {
                ans[stackIndex.peek()] = i - stackIndex.peek();
                stackValue.pop();
                stackIndex.pop();
            }
            stackValue.push(T[i]);
            stackIndex.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] a = new Solution739().dailyTemperatures(T);
        for (int i = 0; i < T.length; i++) {
            System.out.println(a[i]);
        }
    }
}
