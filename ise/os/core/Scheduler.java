package ise.os.core;

/**
 * Pcb调度程序，被ClockInterrupt的interrupt函数周期性地调用
 *
 * @author yecq
 */
class Scheduler {

    private Algorithm algo;

    private PcbQueue queue;

    private ProcessManager manager;

    // 设置调度算法
    void setAlgorithm(Algorithm algo) {
        this.algo = algo;
    }

    // 调度
    public void schedule() {
        // 选出一个运行态进程
        int pid_run = this.algo.getSwitchOut();

        //选出一个就绪态进程
        int pid_in = this.algo.getSwitchIn();

        // 然后切换 ...
    }

}
