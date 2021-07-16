package ise.os.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author yecq
 */
class MyPanel extends JPanel {

    private Map obj;

    MyPanel() {
        this.obj = new HashMap();
        this.obj.put("root", this);
        initView();
        initListener();
    }

    private void initView() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 2;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        this.add(getLeft(), c);
        c.gridheight = 1;
        c.gridx++;
        c.weightx = 1;
        c.insets = new Insets(10, 10, 0, 10);
        this.add(getRight(), c);

        c.gridy++;
        c.insets = new Insets(1, 10, 10, 10);
        ResultPanel rp = new ResultPanel();
        rp.setPreferredSize(new Dimension(600, 200));
        this.add(rp, c);
    }

    private JPanel getLeft() {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.NORTH;
        c.insets = new Insets(10, 10, 0, 10);
        Dimension d = new Dimension(100, 23);
        JButton bu = new JButton("创建进程");
        bu.setPreferredSize(d);
        this.obj.put("create", bu);
        p.add(bu, c);
        c.gridy++;
        c.weighty = 1;
        c.insets = new Insets(10, 10, 0, 10);
        JButton all = new JButton("结束所有");
        all.setPreferredSize(d);
        this.obj.put("exit_all", all);
        p.add(all, c);
        return p;
    }

    private JPanel getRight() {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        JTable table = new ProcessTable();
        this.obj.put("table", table);
        JScrollPane jsp = new JScrollPane(table);
        jsp.setPreferredSize(new Dimension(600, 300));
        p.add(jsp, c);

        return p;
    }

    private void initListener() {
        JButton create = (JButton) this.obj.get("create");
        create.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 显示进程创建对话框
                new ProcessCreateDialog().setVisible(true);
            }
        });

        JButton exit = (JButton) this.obj.get("exit_all");
        exit.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "是否结束所有进程？", "?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    Util.showPlateMessage("进程撤销成功");
                }
            }
        });
    }

    // 表格的宽度是等界面画出来之后再进行调整的
    void adjustTableWidth() {
        ProcessTable table = (ProcessTable) this.obj.get("table");
        table.adjustWidth();
    }
}
