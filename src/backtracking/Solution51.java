package backtracking;

/*51. N皇后
n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class Solution51 {
}

//    public void put(int row, boolean[] columnUsed, boolean[] leftUsed, boolean[] rightUsed, int[] position) {
//        int n;
//        List<List<String>> ans=new ArrayList<>();
//        List<String> ele=new ArrayList<>();
//
//        if (row == n) {
//            ans.add(ele);
//            return ans;
//        }
//        for (int j = 0; j < n; j++) {
//            if (!columnUsed[j] && !leftUsed[row + j] && !rightUsed[row - j + (n-1)]) {
//                columnUsed[j] = true;
//                leftUsed[row + j] = true;
//                rightUsed[row - j + (n-1)] = true;
//                position[row] = j;
//                put(row + 1, columnUsed, leftUsed, rightUsed, position);
//                position[row] = 0;
//                rightUsed[row - j + (n-1)] = false;
//                leftUsed[row + j] = false;
//                columnUsed[j] = false;
//            }
//        }
//    }

//    public void print(int[] position) {
//        for (int i = 0; i < 5; i++) {
//            for (int j = 0; j < 5; j++) {
//                if (position[i] == j) System.out.print("*");
//                else System.out.print("+");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }
//
//    public List<List<String>> solveNQueens(int n) {
//        int row=0;
//        boolean[] columnUsed=new boolean[n];
//        boolean[] leftUsed=new boolean[2*n-1];
//        boolean[] rightUsed=new boolean[2*n-1];
//        int[] position=new int[n];
//        List<List<String>> ans=new ArrayList<>();
//        List<String> ele=new ArrayList<>();
//
//        if (row == n) {
//            ans.add(ele);
//            return ans;
//        }
//        for (int j = 0; j < n; j++) {
//            if (!columnUsed[j] && !leftUsed[row + j] && !rightUsed[row - j + (n-1)]) {
//                columnUsed[j] = true;
//                leftUsed[row + j] = true;
//                rightUsed[row - j + (n-1)] = true;
//                position[row] = j;
//                put(row + 1, columnUsed, leftUsed, rightUsed, position);
//                position[row] = 0;
//                rightUsed[row - j + (n-1)] = false;
//                leftUsed[row + j] = false;
//                columnUsed[j] = false;
//            }
//        }
//    }
//}
