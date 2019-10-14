import java.util.List;
import java.util.LinkedList;
import java.util.TreeMap;

public class _729_MyCalendarI {
    class MyCalendar1 {
        List<int[]> bookings;

        public MyCalendar1() {
            bookings=new LinkedList<>();
        }

        public boolean book(int start, int end) {
            int s = 0, e = bookings.size()-1;
            while (s <= e){
                int mid = s + (e-s)/2;
                int[] bk=bookings.get(mid);
                if (bk[0]==start){
                    return false;
                }else if (bk[0]>start){
                    e=mid-1;
                }else{
                    s=mid+1;
                }
            }
            if (s>0 && start<bookings.get(s-1)[1])
                return false;

            if (s<bookings.size() && end>bookings.get(s)[0])
                return false;

            bookings.add(s, new int[]{start, end});
            return true;
        }
    }

    class MyCalendar2 {
        TreeMap<Integer, Integer> map;
        public MyCalendar2() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            Integer low = map.lowerKey(end);

            if(low == null || map.get(low) <= start) {
                map.put(start, end);
                return true;
            }
            return false;
        }
    }
}
