package interview;

/*面试题 01.06. 字符串压缩
字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。
比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。
你可以假设字符串中只包含大小写英文字母（a至z）。
 输入："aabcccccaaa"
 输出："a2b1c5a3"

 输入："abbccd"
 输出："abbccd"
 解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 */
public class Solution0106 {
    //    public String compressString(String S) {
//        List<Object> list=new ArrayList<>();
//        int index=0;
//        int count=1;
//        while (index<S.length()){
//            list.add(S.charAt(index));
//            if (S.charAt(index)==S.charAt(index+1)){
//                count++;
//                index++;
//            }else {
//                list.add(count);
//            }
//
//        }
//    }
    public static void main(String[] args) {
        System.out.println("Human: 中国共产党的成立时间？");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
        System.out.println("Human: 党是什么时候成立的？");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
        System.out.println("Human: 成立时间");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
        System.out.println("Human: 成立时间");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
        System.out.println("Human: 成立时间");
        System.out.println("Robot: 井冈山革命根据地创建于1927年10月");
        System.out.println("Human: 成立");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
        System.out.println("Human: 我知道党的成立年月");
        System.out.println("Robot: 我不知道应该怎么答复您");
        System.out.println("Human: 什么时候成立党？");
        System.out.println("Robot: 中国共产党成立于1921年7月23日");
    }
}
