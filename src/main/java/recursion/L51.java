package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*

n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。



上图为 8 皇后问题的一种解法。

给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。

每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。

示例:

输入: 4
输出: [
 [".Q..",  // 解法 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // 解法 2
  "Q...",
  "...Q",
  ".Q.."]
]
解释: 4 皇后问题存在两个不同的解法。

*/

public class L51 {
    public static void main(String[] args) {
        System.out.println(new Solution51().solveNQueens(4));
    }
}

class Solution51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        solveNQueens(0, n, new ArrayList<Integer>(0), result);
        return result;
    }

    private void solveNQueens(int index, int n, List<Integer> queens, List<List<String>> result) {
        if (index == n) {
            List<String> item = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder(n);
                for (int j = 0; j < n; j++) {
                    if (j == queens.get(i)) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                item.add(sb.toString());
            }
            result.add(item);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (checkSave(i, index, queens)) {
                List<Integer> newQueens = new ArrayList<>(queens);
                newQueens.add(i);
                solveNQueens(index + 1, n, newQueens, result);
            }
        }
    }

    private boolean checkSave(int x, int y, List<Integer> queens) {
        for (int i = 0; i < queens.size(); i++) {
            int qy = i;
            int qx = queens.get(qy);
            if(qx == x || Math.abs(y-qy) == Math.abs(x - qx)) {
                return false;
            }
        }
        return true;
    }
}
