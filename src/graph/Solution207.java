package graph;

import java.util.ArrayList;
import java.util.List;

/*207. 课程表
现在你总共有 n 门课需要选，记为 0 到 n-1。
在选修某些课程之前需要一些先修课程。例如，想要学习课程0，你需要先完成课程1，我们用一个匹配来表示他们:[0,1]
给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？
 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {//numCourses需要修的课程总数
        int[] inDegree=new int[numCourses];//Degree记录每一门课程需要的先修课程总数
        List<List<Integer>> graph=new ArrayList<>();//记录每一门课程所需的先修课程的邻接表

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());//graph中包含numCourses个链表
        }

        //构造inDegree数组
        for (int[] prerequisite : prerequisites) {//prerequisites题目给出的参数：记录课程与其先修课程，列数为2
            graph.get(prerequisite[0]).add(prerequisite[1]);//prerequisite[0]先修课程
            inDegree[prerequisite[1]]=inDegree[prerequisite[1]]+1;//prerequisite[1]后修课程
        }

        List<Integer> roots=new ArrayList<>();//roots记录修读课程的顺序
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i]==0) {
                roots.add(i);
            }
        }

        //遍历
        while (!roots.isEmpty()){
            Integer root=roots.get(0);//root记录先修的课程号
            roots.remove(0);//移除已经修过的课程
            List<Integer> nodes=graph.get(root);//把课root的后修课程复制到nodes中
            for (Integer node : nodes) {
                inDegree[node]-=1;
                if (inDegree[node]==0) roots.add(node);
            }
        }

        for (int i : inDegree) {
            if (i!=0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] x={{1,2},{1,3},{2,4},{3,4},{3,0}};
        int num=5;
        System.out.println(new Solution207().canFinish(num,x));
    }


}
