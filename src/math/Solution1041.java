package math;

/*1041. 困于环中的机器人
在无限的平面上，机器人最初位于 (0, 0) 处，面朝北方。机器人可以接受下列三条指令之一：
"G"：直走 1 个单位
"L"：左转 90 度
"R"：右转 90 度
机器人按顺序执行指令 instructions，并一直重复它们。
只有在平面中存在环使得机器人永远无法离开时，返回 true。否则，返回 false。
 */
public class Solution1041 {
    public boolean isRobotBounded(String instructions) {
        int direct=0;//上0,左1,下2,右3
        int x=0;
        int y=0;
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i)=='G'){
                if (direct==0) y+=1;
                else if (direct==1) x-=1;
                else if (direct==2) y-=1;
                else x+=1;
            }
            if (instructions.charAt(i)=='L'){
                if (direct==0) direct=1;
                else if (direct==1) direct=2;
                else if (direct==2) direct=3;
                else direct=0;
            }
            if (instructions.charAt(i)=='R'){
                if (direct==0) direct=3;
                else if (direct==1) direct=0;
                else if (direct==2) direct=1;
                else direct=2;
            }
        }

        if ((x!=0||y!=0)&&direct==0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s="GLRLGLLGLGRGLGL";
        System.out.println(new Solution1041().isRobotBounded(s));
    }
}
