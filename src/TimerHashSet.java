import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class TimerHashSet implements Timer{

    HashSet<Integer> hashSet = new HashSet<Integer>();

    @Override
    public long timer_add(){
        long time;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashSet.add(i);
        }
        long time2 = System.currentTimeMillis();
        time =time2 - time1;
        return  time;
    }
    @Override
    public long timer_remove(){
        long time;
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            hashSet.remove(0);
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return  time;
    }
    @Override
    public long timer_set(){
        long time;
        Random rnd = new Random();
        if (hashSet.size()!=0) {
            long time1 = System.currentTimeMillis();
            hashSet.contains(rnd.nextInt(10000));
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
        Iterator<Integer> itr = hashSet.iterator();
        while (itr.hasNext()) {
            itr.next();
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return time;
    }
}
