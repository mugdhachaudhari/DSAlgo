import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}
class compareInterval implements Comparator<Interval> {
	public int compare(Interval t1, Interval t2) {
		if (t1.start < t2.start) {
			return -1;
		} else if (t1.start > t2.start) {
			return 1;
		} else if (t1.end < t2.end){
			return -1;		
		} else if (t1.end > t2.end) {
			return 1;
		} else return 0;
	}
}
public class IntervalMerge {
	public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new compareInterval());
        List<Interval> res = new ArrayList<Interval>();
        Interval prev = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
        	if (prev.end > intervals.get(i).end) {
        		res.add(new Interval(prev.start, Math.max(prev.end, intervals.get(i).end)));
        	}
        	prev = intervals.get(i);
        }
        return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Interval i1 = new Interval()
	}

}
