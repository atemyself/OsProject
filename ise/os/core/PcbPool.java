package ise.os.core;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 进程控制块池，系统启动初期建立一定数量的Pcb，以供使用
 *
 * @author yecq
 */

class PcbPool {

    static final int CAPACITY = 100;
    private Map<Integer, Pcb> map;  // 存放预先建立的pcb

    // 取出一个Pcb
    synchronized Pcb removeOne() {
        return null;
    }

    // 归还一个
    synchronized void returnOne(Pcb pcb) {
        
    }
}
