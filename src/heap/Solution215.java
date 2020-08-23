package heap;

import java.util.Arrays;

/*215. 数组中的第K个最大元素
在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
说明:
你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 */
public class Solution215 {
//    public static int[] quickSort(int arr[],int start,int end) {
//        int pivot = arr[start];
//        int i = start;
//        int j = end;
//
//        while (i < j) {
//            while ((i < j) && (arr[j] < pivot)) {
//                j--;
//            }
//            while ((i < j) && (arr[i] > pivot)) {
//                i++;
//            }
//            if ((arr[i] == arr[j]) && (i < j)) {
//                j--;
//            } else {
//                int temp = arr[i];
//                arr[i] = arr[j];
//                arr[j] = temp;
//            }
//        }
//
//        if (i-1 > start)  arr=quickSort(arr,start,i-1);
//        if (j+1 < end)    arr=quickSort(arr,j+1,end);
//        return (arr);
//    }
//
//    public int findKthLargest(int[] nums,int k) {
//        quickSort(nums,0,nums.length-1);
//        return nums[k-1];
//    }


    public int findKthLargest(int[] nums,int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];
    }

    public static void main(String[] args) {
        int[] nums={3,2,3,1,2,4,5,5,6};
        System.out.println(new Solution215().findKthLargest(nums,3));
    }


}
