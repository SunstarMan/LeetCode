package greedy;

/*861. 翻转矩阵后的得分
有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
返回尽可能高的分数。
输入：[[0,0,1,1],[1,0,1,0],[1,1,0,0]]
输出：39
解释：
转换为 [[1,1,1,1],[1,0,0,1],[1,1,1,1]]
0b1111 + 0b1001 + 0b1111 = 15 + 9 + 15 = 39
提示：
1 <= A.length <= 20
1 <= A[0].length <= 20
A[i][j] 是 0 或 1
 */
public class Solution861 {
    public int matrixScore(int[][] A) {
        int len1=A.length;
        int len2=A[0].length;
        int ans=0;

        for (int i = 0; i < len2; i++) {
            int a=0;
            for (int j = 0; j < len1; j++) {
                a+=A[j][i]^A[j][0];//A[j][0]每一行的第一个数
            }
            ans+=Math.max(a,len1-a)*(1<<(len2-1-i));
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] A={{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        System.out.println(new Solution861().matrixScore(A));
    }
}

