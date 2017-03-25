import java.util.HashMap;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * Given 4 points: (1,2), (3,6), (0,0), (1,3).
 * The maximum number is 3.
 */
public class MaxPointsOnALine {

    public int maxPoints(Point[] points) {
        if (points == null) {
            return 0;
        }

        if (points.length <= 2) {
            return points.length;
        }

        HashMap<Double, Integer> pointsMap = new HashMap<>();
        int max = 2;

        for (int i = 0; i < points.length - 1; i++) {

            /**
             * 例如(1,2) (3,6) (0,0) (1,3)其中(1,2) (3,6) (0,0)在一条直线上,
             * 第一次开始以(1,2)为起点的时候已经会全部找到了，后面再以(3,6)为起点时就是子集
             * 所以每次换起始点的时候需要清空map
             */
            pointsMap.clear();
            int dup = 0;

            // 如果所有的点都在同一条vertical line上，要先把第一个加进来
            pointsMap.put((double)Integer.MIN_VALUE, 1);

            for (int j = i + 1; j < points.length; j++) {

                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    dup++;
                    continue;
                }

                double slope = getSlope (points[i],points[j]);

                if (pointsMap.containsKey(slope)) {
                    pointsMap.put(slope, pointsMap.get(slope) + 1);
                } else {
                    pointsMap.put(slope,2);
                }
            }

            for (int line : pointsMap.values()) {
                if (line + dup > max) {
                    max = line + dup;
                }
            }
        }

        return max;
    }

    private double getSlope(Point i, Point j) {
        if (i.x == j.x) {
            return (double)Integer.MIN_VALUE;
        }

        // 加0.0是为了-0.0和+0.0被判断成不一样的值
        return (double)(i.y - j.y) / (double)(i.x - j.x) + 0.0;
    }
}
