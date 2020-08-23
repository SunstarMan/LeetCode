package dfs;

import java.util.HashSet;
import java.util.Set;

/*980. 不同路径 III
在二维网格 grid 上，有 4 种类型的方格：
1 表示起始方格。且只有一个起始方格。
2 表示结束方格，且只有一个结束方格。
0 表示我们可以走过的空方格。
-1 表示我们无法跨越的障碍。
请注意，起始和结束方格可以位于网格中的任意位置。
返回在四个方向（上、下、左、右）上行走时，从起始方格到结束方格的不同路径的数目，每一个无障碍方格都要通过一次。
输入：[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
输出：2
解释：我们有以下两条路径：
1. (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2)
2. (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2)
提示：1 <= grid.length * grid[0].length <= 20
 */
public class Solution980 {
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};//上右下左
    private int zeroNumber;
    private int m;
    private int n;

    public boolean inArea(int[][] grid, int x, int y) {
        return (x < m && x >= 0) && (y >= 0 && y < n);
    }

    public int dfs(int[][] grid, int x, int y, boolean[][] visited, HashSet<Integer> route) {
        if (grid[x][y] == 2) {
            if (route.size() == zeroNumber + 1) return 1;
            else return 0;
        }

        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + direction[i][0];
            int yy = y + direction[i][1];
            if (inArea(grid, xx, yy) && (grid[xx][yy] == 0 || grid[xx][yy] == 2) && !visited[xx][yy]) {
                visited[xx][yy] = true;
                route.add(xx * n + yy);
                sum += dfs(grid, xx, yy, visited, route);
                route.remove(xx * n + yy);
                visited[xx][yy] = false;
            }
        }
        return sum;
    }

    public int uniquePathsIII(int[][] grid) {
        int x = 0, y = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    x = i;
                    y = j;
                }
                if (grid[i][j] == 0) {
                    zeroNumber++;
                }
            }
        }
        boolean[][] visited = new boolean[m][n];
        visited[x][y] = true;
        HashSet<Integer> route = new HashSet<>();
        return dfs(grid, x, y, visited, route);
    }

    public static void main(String[] args) {
        int[][] a = {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(new Solution980().uniquePathsIII(a));
    }
}
