package greedy;


import java.util.Arrays;
import java.util.Comparator;

/*
在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以y坐标并不重要，因此只要知道开始和结束的x坐标就足够了。开始坐标总是小于结束坐标。平面内最多存在104个气球。

一支弓箭可以沿着x轴从不同点完全垂直地射出。在坐标x处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的最小数量。

Example:

输入:
[[10,16], [2,8], [1,6], [7,12]]

输出:
2

解释:
对于该样例，我们可以在x = 6（射爆[2,8],[1,6]两个气球）和 x = 11（射爆另外两个气球）。
* */
public class L452 {
    public static void main(String[] args) {
        System.out.println(new Solution452().findMinArrowShots(new int[][]{new int[]{10,16},new int[]{2,8},new int[]{1,6},new int[]{7,12}}));
    }
}

class Solution452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) {
            return 1;
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0],o2[0]);
            }
        });

        int arrowCnt = 0;
        int maxEnd = -1;
        for (int i = 0; i < points.length; i++) {
            if (points[i][0] > maxEnd) {
                arrowCnt++;
                maxEnd = points[i][1];
            }
            maxEnd = Math.min(points[i][1], maxEnd);
        }
        return arrowCnt;
    }
}