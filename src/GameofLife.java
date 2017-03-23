/**
 * https://leetcode.com/problems/game-of-life/?tab=Description
 */
public class GameofLife {

    /**
     * 方法一: O(n)的space complexity和O(n^2)的time complexity,最简单和直观的解决方法
     * @param board
     *          Original matrix with 1s and 0s
     */
    public void solution1(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int wide = board[0].length;
        int length = board.length;
        int[][] duplicate = new int[length][wide];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wide; j++) {
                duplicate[i][j] = board[i][j];
            }
        }

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < wide; j++) {
                int liveCount = getLiveCount(i, j, duplicate);

                if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] = 1;
                    }
                } else {
                    if (liveCount < 2 || liveCount > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }
    }

    private int getLiveCount(int i, int j, int[][] duplicate) {
        int liveCount = 0;
        for (int m = i-1; m < duplicate.length && m <= i + 1; m++) {
            for (int n = j-1; n < duplicate[0].length && n <= j + 1; n++) {
                if (m < 0 || n < 0 || (m == i && n == j)) {
                    continue;
                }

                if (duplicate[m][n] == 1) {
                    liveCount++;
                }

//                For solution2
//                if (duplicate[m][n] % 10 == 1) {
//                    liveCount++;
//                }
            }
        }
        return liveCount;
    }

    /**
     * 用10来进行操作,通过除法的商和余数获得不同的1和0的状态
     * / 和 % 可以经常用来解决一些问题
     * @param board
     */
    public void solution2(int[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        // 10:dead -> live 11:live -> live
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int liveCount = getLiveCount(i, j, board);

                if (board[i][j] == 0) {
                    if (liveCount == 3) {
                        board[i][j] += 10;
                    }
                } else {
                    if (liveCount == 2 || liveCount == 3) {
                        board[i][j] += 10;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = board[i][j] / 10;
            }
        }
    }
}
