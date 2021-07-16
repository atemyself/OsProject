package ise.os.core;

/**
 * 调度算法接口
 *
 * @author yecq
 */
interface Algorithm {

    // 选出换出的进程号，未选到返回-1
    int getSwitchOut();

    // 选出换进的进程号，未选到返回-1
    int getSwitchIn();
}
