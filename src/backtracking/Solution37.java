package backtracking;

/*37. 解数独
编写一个程序，通过已填充的空格来解决数独问题。
一个数独的解法需遵循如下规则：
数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
空白格用 '.' 表示。
 */
public class Solution37 {
    boolean solved;

    public void solveSudoku(char[][] board) {
        boolean[][] rowPlaced = new boolean[9][10];//检查行是否有某个数字：如rowPlaced[3][1]=true即表示第4行的数字1已经放置
        boolean[][] colPlaced = new boolean[9][10];//检查列是否有某个数字：如colPlaced[3][1]=true即表示第4列的数字1已经放置
        boolean[][] boxPlaced = new boolean[9][10];//检查小块是否有某个数字：如boxPlaced[0][1]=true即表示第0块的数字1已经放置

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (Character.isDigit(board[i][j])) {
                    int k = board[i][j] - '0';//将字符转为对应的数字。
                    rowPlaced[i][k] = true;
                    colPlaced[j][k] = true;
                    boxPlaced[i / 3 * 3 + j / 3][k] = true;
                }
            }
        }

        solved = false;
        solve(0, 0, rowPlaced, colPlaced, boxPlaced, board);
    }

    private void solve(int rowCurrent, int colCurrent, boolean[][] rowPlaced, boolean[][] colPlaced, boolean[][] boxPlaced, char[][] board) {
        if (rowCurrent == 9 && colCurrent == 0) {
            solved = true;
            return;
        }

        int rowTo = rowCurrent;
        int colTo = colCurrent;
        colTo = colTo + 1;

        if (colTo == 9) {
            colTo = 0;
            rowTo = rowTo + 1;
        }

        if (Character.isDigit(board[rowCurrent][colCurrent])) {
            solve(rowTo, colTo, rowPlaced, colPlaced, boxPlaced, board);
        } else {
            for (int i = 1; i < 10; i++) {
                if (!rowPlaced[rowCurrent][i] && !colPlaced[colCurrent][i] && !boxPlaced[rowCurrent / 3 * 3 + colCurrent / 3][i]) {
                    rowPlaced[rowCurrent][i] = true;
                    colPlaced[colCurrent][i] = true;
                    boxPlaced[rowCurrent / 3 * 3 + colCurrent / 3][i] = true;

                    board[rowCurrent][colCurrent] = (char) ('0' + i);
                    solve(rowTo, colTo, rowPlaced, colPlaced, boxPlaced, board);
                    if (solved) return;
                    board[rowCurrent][colCurrent] = '.';
                    boxPlaced[rowCurrent / 3 * 3 + colCurrent / 3][i] = false;
                    colPlaced[colCurrent][i] = false;
                    rowPlaced[rowCurrent][i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Solution37().solveSudoku(board);
    }

}
