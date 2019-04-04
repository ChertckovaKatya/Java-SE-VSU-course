import java.util.LinkedList;
import java.util.Random;

public class TimerLinkedList implements Timer {

    LinkedList<Integer> linList = new LinkedList<Integer>();

    @Override
    public long timer_add(){
        long time;
        long time1 = System.currentTimeMillis();
        Random rnd = new Random();
        for (int i = 0; i < 10000; i++) {
            linList.add(rnd.nextInt(100));
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
            linList.remove(0);
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return  time;
    }
    @Override
    public long timer_set(){
        long time;
        Random rnd = new Random();
        if (linList.size()!=0) {
            long time1 = System.currentTimeMillis();
            linList.set(rnd.nextInt(10000), 1);
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
        for (int i = 0; i < linList.size(); i++) {
            linList.get(i);
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return time;
    }
}
