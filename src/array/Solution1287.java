package array;

/*1287. 有序数组中出现次数超过25%的元素
给你一个非递减的 有序 整数数组，已知这个数组中恰好有一个整数，它的出现次数超过数组元素总数的 25%。
请你找到并返回这个整数
 */
public class Solution1287 {

    public int findSpecialInteger(int[] arr) {
        int len = arr.length;
        int quarter=len/4;

        for (int i = 0; i < len - quarter; i++){
            if (arr[i] == arr[i + quarter]){
                return arr[i];
            }
        }
        return arr[0];
    }
}
