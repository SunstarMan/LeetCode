package interview;

/*1013. 将数组分成和相等的三个部分
给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
形式上，如果可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] ==
A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
输出：[0,2,1,-6,6,-7,9,1,2,0,1]
输出：true
解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 */
public class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum=0;
        double sumPart;
        int count=0;
        int sum1=0;
        for (int i = 0; i < A.length; i++) {
            sum+=A[i];
        }
        sumPart=sum/3.0;
        if (sumPart%1!=0) return false;
        else {
            for (int i = 0; i < A.length; i++) {
                sum1+=A[i];
                if (sum1==sumPart){
                    count++;
                    sum1=0;
                }
                if (count==2){

                }
            }
            if (count==3){
                return true;
            }else {
                return  false;
            }
        }
    }

    public static void main(String[] args) {
        int[] x={10,-10,10,-10,10,-10,10,-10};
        boolean ans=new Solution1013().canThreePartsEqualSum(x);
        System.out.println(ans);
    }
}
