package array;

/*575.分糖果
给定一个偶数长度的数组，其中不同的数字代表着不同种类的糖果，每一个数字代表一个糖果。
你需要把这些糖果平均分给一个弟弟和一个妹妹。返回妹妹可以获得的最大糖果的种类数。
 */
public class Solution575 {
    //数组去重，长度>=一半，输出一半，<一半，输出这个数
//    public int distributeCandies(int[] candies) {
//        Set set = new HashSet();
//        for (int i = 0; i < candies.length; i++)
//            set.add(candies[i]);
//        int type = set.size();
//        return type >= candies.length/2 ? candies.length/2 : type;
//    }
//    public static void main(String[] args) {
//        String s1="DEF";
//        String s2="ABC";
//        String temp=s1.replaceAll(s2, "");//两字符串相减
//        System.out.println(temp);
//    }

    public static void main(String[] args) {
        double testQuestions=199;
        double rightAnswer=165;
        double accuracy=(0.782608695652174+0.8368580060422961+0.8275862068965517+0.8046511627906977+0.8291457286432161)/5;
        System.out.println(accuracy);
    }
}
