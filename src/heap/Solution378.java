package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/*378. 有序矩阵中第K小的元素
给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第k小的元素。
请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
matrix = [
   [ 1,  5,  9],
   [10, 11, 13],
   [12, 13, 15]
],
k = 8,
返回 13。
提示：
你可以假设 k 的值永远是有效的, 1 ≤ k ≤ n2 。
 */
public class Solution378 {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer>  queue=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                queue.offer(matrix[i][j]);
            }
        }
        for (int i = 0; i < k-1; i++) {
            queue.poll();
        }
        return queue.peek();
    }

    public static void main(String[] args) {
        int[][] nums={{1,5,9},{10,11,13},{12,13,15}};
        int n=8;
        System.out.println(new Solution378().kthSmallest(nums,n));
    }
}
