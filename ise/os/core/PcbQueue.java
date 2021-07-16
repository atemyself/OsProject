package ise.os.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 各个状态进程的队列
 *
 * @author yecq
 */
class PcbQueue {

    private final Map<Integer, Pcb> running;    // 运行队列
    private final Map<Integer, Pcb> ready;      // 就绪队列
    private final Map<Integer, Pcb> waiting;    // 等待队列

    PcbQueue() {
        this.running = new HashMap();
        this.ready = new HashMap();
        this.waiting = new HashMap();
    }

    // 加入一个进程到运行队列
    void add2Running(Pcb process) {

    }

    // 从运行队列中取出一个Process
    Pcb removeFromRunning(int pid) {
        return this.running.remove(pid);
    }

    // 加入一个Process到就绪队列
    void add2Ready(Pcb process) {

    }

    // 从就绪队列中取出一个
    Pcb removeFromReady(int pid) {
        return null;
    }

    // 加入到等待队列
    void add2Waiting(Pcb process) {

    }

    // 从等待队列中取出一个
    Pcb removeFromWaiting(int pid) {
        return null;
    }

    // 通过pid获得这个进程
    Pcb getPcb(int pid) {
        return null;
    }

    // 根据pid，取得这个pcb
    Pcb removePcb(int pid) {
        return null;
    }

}
