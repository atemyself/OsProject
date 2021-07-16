package ise.os.core;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 时钟中断，每隔一段时间产生一次中断
 *
 * @author yecq
 */
class ClockInterrupt {

    private static final int BASE = 1000;       // 时间间隔基数
    static final long delay = (long) (5 * BASE);  // 5秒调度一次

    private Scheduler sched;

    private Timer timer;        // 定时器

    ClockInterrupt() {
        // 定时任务线程
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                interrupt();
            }
        };
        this.timer = new Timer(true);
        this.timer.schedule(task, delay, delay);
    }

    // 产生一次中断信号，然后调用调度器进行进程调度
    // 通知内核监听放在切面里进行
    private void interrupt() {
        if (this.sched != null) {
            this.sched.schedule();
        }
    }
}
