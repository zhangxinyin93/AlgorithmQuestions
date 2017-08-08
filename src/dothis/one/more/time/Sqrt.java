package dothis.one.more.time;

/**
 * Implement double sqrt(double x) and x >= 0.
 * Compute and return the square root of x.
 */
public class Sqrt {

    /**
     * 数字类型的题要尤其注意两个问题
     * 【越界】和【符号】
     */
    public double sqrt(double x) {
        if (x < 0) {
            return Double.MIN_VALUE;
        }

        if (x == 0 || x == 1) {
            return x;
        }

        double start = 0;
        double end = x;

        // 表示精度的问题！
        double threshold = 1e-12;

        if (x < 1.0) {
            end = 1.0;
        }

        while (end - start > threshold) {
            double mid = (end - start) / 2 + start;

            if (mid * mid == x){
                return mid;
            }

            if (mid * mid < x) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (end * end <= x) {
            return end;
        }

        return start;
    }
}
