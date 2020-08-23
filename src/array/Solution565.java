package array;

/*565. 数组嵌套
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。
找到并返回最大的集合S，S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。
假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，
之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
输入: A = [5,4,0,3,1,6,2]
输出: 4
解释: A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
其中一种最长的 S[K]:S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 */
public class Solution565 {
    public int arrayNesting(int[] nums) {
        int ans = 1;

        for(int i = 0; i < nums.length; i++){
            if(ans > nums.length/2) return ans;
            int curMax = 1;
            int cur = nums[nums[i]];
            while(nums[i] != cur){
                curMax++;
                cur = nums[cur];
            }
            ans = curMax > ans? curMax : ans;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] x={5,4,0,3,1,6,2};
        int ans=new Solution565().arrayNesting(x);
        System.out.println(ans);
    }
}
