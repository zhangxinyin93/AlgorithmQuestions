import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhangxinyin on 9/27/16.
 */
public class MergeIntervals {
    public class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <=1) {
            return intervals;
        }
        List<Interval> answer = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start-o2.start;
            }
        });
        Interval lastInterval = intervals.get(0);
        for(int i=1; i<intervals.size(); i++) {
            Interval interval = intervals.get(i);
            if(interval.start <= lastInterval.end) {
                lastInterval.end = Math.max(interval.end,lastInterval.end);
            } else {
                answer.add(lastInterval);
                lastInterval = interval;

            }
        }
        answer.add(lastInterval);
        return answer;
    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.merge(new ArrayList<>());
    }
}
