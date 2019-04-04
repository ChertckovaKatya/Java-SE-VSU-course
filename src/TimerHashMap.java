import java.util.*;

public class TimerHashMap implements Timer {

    HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        @Override
        public long timer_add(){
            long time;
            Random rnd = new Random();
            long time1 = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                hashMap.put(rnd.nextInt(10000),rnd.nextInt(100) );
            }
            long time2 = System.currentTimeMillis();
            time =time2 - time1;
            return  time;
        }
        @Override
        public long timer_remove(){
            long time;
            long time1 = System.currentTimeMillis();
            Random rnd = new Random();
            while ( hashMap.size()!=0 ) {
                hashMap.remove(rnd.nextInt(10000));
            }
            long time2 = System.currentTimeMillis();
            time = time2 - time1;
            return  time;
        }



        @Override
        public long timer_set(){
            long time;
            Random rnd = new Random();
            if (hashMap.size()!=0) {
                long time1 = System.currentTimeMillis();
                hashMap.containsKey(rnd.nextInt(10000));
                long time2 = System.currentTimeMillis();
                time = time2 - time1;
                return time;
            }
            else {return -1;}
        }

        @Override
        public long timer_get() {
            long time;
            long time1 = System.currentTimeMillis();
            Set<Map.Entry<Integer, Integer>> set;
            set = hashMap.entrySet();
            for (Map.Entry<Integer, Integer> me : set) {
                me.getKey();
                me.getValue();
            }
            long time2 = System.currentTimeMillis();
            time = time2 - time1;
            return time;
        }

}
