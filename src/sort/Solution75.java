package sort;

/*75. 颜色分类
给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
注意:不能使用代码库中的排序函数来解决这道题。
输入: [2,0,2,1,1,0]
输出: [0,0,1,1,2,2]
进阶：一个直观的解决方案是使用计数排序的两趟扫描算法。
首先，迭代计算出0、1 和 2 元素的个数，然后按照0、1、2的排序，重写当前数组。
你能想出一个仅使用常数空间的一趟扫描算法吗？
 */
public class Solution75 {
//    两次遍历
    public void sortColors(int[] nums) {
        int[] count = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) count[0]++;
            if (nums[i] == 1) count[1]++;
        }

        int index = 0;
        while (index < nums.length) {
            if (index < count[0]) nums[index] = 0;
            else if (index < count[1] + count[0]) nums[index] = 1;
            else nums[index] = 2;
            index++;
        }
    }

//    利用快速排序
//    public void sortColors(int[] nums) {
//        quickSort(nums,0,nums.length-1);
//    }
//    public int[] quickSort(int arr[],int start,int end) {
//        int pivot = arr[start];
//        int i = start;
//        int j = end;
//
//        while (i < j) {
//            while ((i < j) && (arr[j] > pivot)) {
//                j--;
//            }
//            while ((i < j) && (arr[i] < pivot)) {
//                i++;
//            }
//            if ((arr[i] == arr[j]) && (i < j)) {
//                i++;
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

    public static void main(String[] args) {
        int[] a={2,0,2,1,1,0};
        new Solution75().sortColors(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}
