package recursion;

import java.util.ArrayList;
import java.util.List;


/*

给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。

例如，给出 n = 3，生成结果为：

[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]

*/

public class L22 {
    public static void main(String[] args) {
        System.out.println(new Solution22().generateParenthesis(3));
    }
}

class Solution22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        generateParenthesis(1, n, 1,"(", result);

        return result;
    }

    private void generateParenthesis(int index, int n, int leftNum, String item, List<String> result) {
        if (index == 2 * n) {
            result.add(item);
            return;
        }

        if (leftNum < n) {
            generateParenthesis(index + 1, n, leftNum + 1, item + "(", result);
        }

        if (leftNum > item.length() - leftNum) {
            generateParenthesis(index + 1, n, leftNum, item + ")", result);
        }
    }
}
