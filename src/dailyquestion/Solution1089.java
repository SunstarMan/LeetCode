package dailyquestion;

/*1089. 复写零
给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
注意：请不要在超过该数组长度的位置写入元素。
要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
示例 1:输入：[1,0,2,3,0,4,5,0]
输出：null
解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]

 */
public class Solution1089 {
    public void duplicateZeros(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) count++;
        }
        int ptr = arr.length - 1;
        while (count != 0) {
            if (arr[ptr] == 0) {
                count--;
                if (ptr + count < arr.length) arr[ptr + count] = 0;
                if (ptr + 1 + count < arr.length) arr[ptr + 1 + count] = 0;
            } else {
                if (ptr + count < arr.length) arr[ptr + count] = arr[ptr];
            }
            ptr--;
        }
    }
}
