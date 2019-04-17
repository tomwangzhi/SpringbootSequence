package task;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimeTask {

    public static void main(String[] args) {

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                System.out.println("我是每个间隔时间执行");
            }
        };

        Timer timer = new Timer();
        // timerTask任务在10ms后第一次运行，后面每隔3s运行
        timer.schedule(timerTask,10,3000);
    }
}
