package stack;

/*735. 行星碰撞
给定一个整数数组 asteroids，表示在同一行的行星。
对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。
每一颗行星以相同的速度移动。
找出碰撞后剩下的所有行星。碰撞规则：
两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class Solution735 {
//    public int[] asteroidCollision(int[] asteroids) {
//        Stack<Integer> stack=new Stack<>();
//        int m=asteroids.length;
//        stack.push(asteroids[0]);
//        int index=1;
////        for (int i = 1; i < m; i++) {
////            if (stack.peek()<0){
////                stack.push(asteroids[i]);
////                i++;
////            }else {
////                stack.push(asteroids[i]);
////                i++;
////                if (stack.peek()<0){
////                    compute(stack);
////                }else {
////                    stack.push(asteroids[i]);
////                    i++;
////                }
////            }
////        }
//        while (index<m){
//            if (stack.peek()<0){
//                stack.push(asteroids[index]);
//                index++;
//            }else {
//                stack.push(asteroids[index]);
//                index++;
//                if (stack.peek()<0){
//                    compute(stack);
//                }else {
//                    if (index<m){
//                        stack.push(asteroids[index]);
//                        index++;
//                    }
//                }
//            }
//        }
//
//        int len=stack.size();
//        int[] originArray=new int[len];
//        for (int i = 0; i < len; i++) {
//            originArray[i]=stack.pop();
//        }
//        int[] ans = new int[len];
//        for (int i = 0; i < len; i++) {
//            ans[i] = originArray[len - i - 1];
//        }
//        return ans;
//    }
//
//    public void compute(Stack<Integer> stack1){
//        if (stack1.size()>1){
//            int num1=stack1.pop();//负数
//            int num2=stack1.pop();//正数
//            if (Math.abs(num1)!=num2){
//                if (Math.abs(num1)>num2){
//                    int num3=stack1.peek();
//                    stack1.push(num1);
//                    if (num3>0)  compute(stack1);
//                } else {
//                    stack1.push(num2);
//                }
//            }
//        }
//    }

    public int[] asteroidCollision(int[] asteroids) {
        int m = asteroids.length;
        int[] stack = new int[m];
        int si = -1;
        for (int a : asteroids) {
            if (si < 0 || a > 0 || a < 0 && stack[si] < 0) {
                stack[++si] = a;
            } else if (a < 0 && stack[si] > 0) {
                while (si >= 0 && stack[si] > 0 && stack[si] < -a) --si;
                if (si < 0 || stack[si] < 0) {
                    stack[++si] = a;
                } else if (stack[si] == -a) {
                    --si;
                } else if (stack[si] < -a) {
                    stack[si] = a;
                }
            }
        }
        int len = si + 1;
        int[] ans = new int[len];
        System.arraycopy(stack, 0, ans, 0, len);
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-2, 1, 1, 1};
        int[] ans;
        ans = new Solution735().asteroidCollision(a);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
}
