package ise.os.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author yecq
 */
class ProcessTable extends JTable {

    private ProcessTableModel model;

    ProcessTable() {
        this.model = new ProcessTableModel();
        this.setModel(model);
        initView();
        initListener();
    }

    private void initView() {
        this.setRowHeight(22);
        for (int i = 0; i < model.getColumnCount(); i++) {
            this.getColumnModel().getColumn(i).setCellRenderer(new CellColorRenderer());
        }
    }

    // 调整表格各列宽度
    void adjustWidth() {
        // 调整各列的宽度
        // 设定列宽度
        double width = this.getSize().width;
        int w0 = (int) (width * 2 / 10);
        int w1 = (int) (width * 6 / 10);
        int w2 = (int) (width * 3 / 10);
        int w3 = (int) (width * 3 / 10);

        TableColumnModel m = getColumnModel();

        m.getColumn(0).setPreferredWidth(w0);
        m.getColumn(1).setPreferredWidth(w1);
        m.getColumn(2).setPreferredWidth(w2);
        m.getColumn(3).setPreferredWidth(w3);
    }

    // 设定颜色渲染，绿色为运行态，粉色为就绪态，灰色为等待态
    private class CellColorRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component obj = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            String status = (String) model.getValueAt(row, 2);
            if (column == 2) {
                if (status.equals("运行")) {
                    obj.setBackground(Color.green);
                } else if (status.equals("就绪")) {
                    obj.setBackground(Color.pink);
                } else if (status.equals("等待")) {
                    obj.setBackground(Color.gray);
                }
            }
            return obj;
        }
    }

    private void initListener() {
        // 建立右键菜单
        this.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.isMetaDown()) {
                    // 获取当前行的属性
                    int row = getSelectedRow();
                    if (row < 0) {
                        return;
                    }
                    String status = (String) model.getValueAt(row, 2);
                    String pid = (String) model.getValueAt(row, 0);

                    JPopupMenu p = new JPopupMenu();
                    JMenuItem run = new JMenuItem("设为运行");
                    if (status.equals("运行")) {
                        run.setEnabled(false);
                    }
                    run.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            // to do ...
                        }
                    });
                    JMenuItem ready = new JMenuItem("设为就绪");
                    if (status.equals("就绪")) {
                        ready.setEnabled(false);
                    }
                    ready.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            // to do ...
                        }
                    });
                    JMenuItem wait = new JMenuItem("设为等待");
                    if (status.equals("等待")) {
                        wait.setEnabled(false);
                    }
                    wait.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            // to do ...
                        }
                    });
                    JMenuItem exit = new JMenuItem("终止");
                    exit.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            if (JOptionPane.showConfirmDialog(null, "是否撤销进程", "?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                                // to do ...
                            }
                        }
                    });

                    p.add(run);
                    p.add(ready);
                    p.add(wait);
                    p.add(exit);
                    p.show(e.getComponent(), e.getX(), e.getY());
                }
            }

        });
    }
}
