package binarySearch;

/*852. 山脉数组的峰顶索引
我们把符合下列属性的数组 A 称作山脉：
A.length >= 3
存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]的i的值。
 */
public class Solution852 {
    public int peakIndexInMountainArray(int[] A) {
        int left = 0;
        int right = A.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (A[mid - 1] < A[mid] && A[mid + 1] < A[mid]) {
                return mid;
            } else if (A[mid - 1] < A[mid] && A[mid + 1] > A[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] x = {0, 1, 0};
        System.out.println(new Solution852().peakIndexInMountainArray(x));
    }
}
