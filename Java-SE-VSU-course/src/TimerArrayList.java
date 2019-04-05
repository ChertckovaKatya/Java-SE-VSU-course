import java.util.ArrayList;
import java.util.Random;

public class TimerArrayList implements Timer {

    ArrayList<Integer> numList= new ArrayList<Integer>();

    @Override
    public long timer_add(){
        long time;
            long time1 = System.currentTimeMillis();
            Random rnd = new Random();
            for (int i = 0; i < 10000; i++) {
                numList.add(rnd.nextInt(100));
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
                numList.remove(0);
            }
            long time2 = System.currentTimeMillis();
            time = time2 - time1;
        return  time;
    }
    @Override
    public long timer_set(){
        long time;
        Random rnd = new Random();
        if (numList.size()!=0) {
            long time1 = System.currentTimeMillis();
            numList.set(rnd.nextInt(10000), 1);
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
        for (int i = 0; i < numList.size(); i++) {
            numList.get(i);
        }
        long time2 = System.currentTimeMillis();
        time = time2 - time1;
        return time;
    }

}
