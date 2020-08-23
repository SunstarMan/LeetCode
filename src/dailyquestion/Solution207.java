package dailyquestion;

import java.util.ArrayList;
import java.util.List;

/*207. 课程表
你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
示例 1:输入: 2, [[1,0]]
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。

 */
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree=new int[numCourses];//Degree记录每一门课程需要的先修课程总数
        List<List<Integer>> graph=new ArrayList<>();//记录每一门课程所需的先修课程的邻接表

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());//graph中包含numCourses个链表
        }

        //构造inDegree数组
        for (int[] prerequisite : prerequisites) {//prerequisites题目给出的参数：记录课程与其先修课程，列数为2
            graph.get(prerequisite[1]).add(prerequisite[0]);//prerequisite[1]先修课程
            inDegree[prerequisite[0]]=inDegree[prerequisite[0]]+1;//prerequisite[0]后修课程
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
}
