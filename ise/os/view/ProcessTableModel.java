package ise.os.view;

import java.util.LinkedList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 表格模型
 *
 * @author yecq
 */
class ProcessTableModel extends AbstractTableModel {

    final private String[] header;
    private List data;

    ProcessTableModel() {
        // 注册监听
        this.header = new String[]{"进程号", "名称",/* "优先级" ,*/ "状态", "剩余时间(秒)"};
        reloadData();
    }

    // 获取所有进程
    private void reloadData() {
        // 自行补上获取所有进程信息的数据，这里我做个假的数据
        // 用java bean来表示每一行数据更好
        this.data = new LinkedList();
        String[] rec1 = {"1", "Process_1", "运行", "50"};
        String[] rec2 = {"2", "Process_2", "就绪", "66"};
        String[] rec3 = {"3", "Process_3", "等待", "100"};
        this.data.add(rec1);
        this.data.add(rec2);
        this.data.add(rec3);
    }

    @Override
    public int getRowCount() {
        return this.data.size();
    }

    @Override
    public int getColumnCount() {
        return this.header.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return this.header[columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] rec = (String[]) this.data.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rec[0];
            case 1:
                return rec[1];
            case 2:
                return rec[2];
            case 3:
                return rec[3];
            default:
                throw new IllegalArgumentException("进程控制块数据错误");
        }
    }
}
