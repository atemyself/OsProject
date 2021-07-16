package ise.os.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

/**
 * Pcb管理类，负责进程的创建、销毁、状态变化等 这是这个包里两个对外开放的public类之一
 *
 * @author yecq
 */
public class ProcessManager {

    private static ProcessManager single = null;

    private PcbPool pool;

    private PcbQueue queue;

    // 单例模式，确保虚拟机里只有这个类的一个对象
    public static ProcessManager getInstance() {
        if (single == null) {
            single = new ProcessManager();
        }
        return single;
    }

    private ProcessManager() {

    }

    // 创建进程，成功返回>0的进程号，错误返回负数
    public int createProcess(String name, long time) {
        return -1;
    }

    // 撤销进程
    public void destroyProcess(int pid) {

    }

    public void destroyAllProcess() {

    }

    // 设为就绪态
    public void ready(int pid) {

    }

    // 设为运行态
    public void running(int pid) {

    }

    // 设为等待态
    public void waiting(int pid) {

    }
}
