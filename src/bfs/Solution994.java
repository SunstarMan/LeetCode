package bfs;

import java.util.ArrayList;
import java.util.List;

/*994. 腐烂的橘子
在给定的网格中，每个单元格可以有以下三个值之一：
值 0 代表空单元格；
值 1 代表新鲜橘子；
值 2 代表腐烂的橘子。
每分钟，任何与腐烂的橘子（在 4 个正方向上）相邻的新鲜橘子都会腐烂。
返回直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1。
 */
public class Solution994 {
    class Pair{
        int x;
        int y;
        public Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
    //        x-1,y
    // x,y-1  x,y    x,y+1
    //        x+1,y
    private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};//方向顺时针变化
    private int m; // 盘面上有多少行
    private int n;// 盘面上有多少列
    private char[][] grid;
    private List<Pair> regenerate;

    public int orangesRotting(int[][] grid) {
        int time=0;
        m=grid.length;
        n=grid[0].length;
        List<Pair> rottingList=new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==2) {
                    rottingList.add(new Pair(i,j));
                }
            }
        }

        while (!rottingList.isEmpty()){
            int size=rottingList.size();
            for (int i = 0; i < size; i++) {
                Pair temp=rottingList.get(0);
                rottingList.remove(0);
                for (int j = 0; j < 4; j++) {
                    int newX = temp.x + direction[j][0];//x轴的变化
                    int newY = temp.y + direction[j][1];//y轴的变化
                    if (inArea(newX,newY) && grid[newX][newY]==1){
                        grid[newX][newY]=2;
                        rottingList.add(new Pair(newX,newY));
                    }
                }
            }
            if (!rottingList.isEmpty()){
                time++;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j]==1){
                    return -1;
                }
            }
        }
        return time;
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
