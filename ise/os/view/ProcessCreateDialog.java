package ise.os.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 进程创建对话框
 *
 * @author yecq
 */
class ProcessCreateDialog extends JDialog {

    private Map obj;

    ProcessCreateDialog() {
        this.obj = new HashMap();
        this.obj.put("root", this);
        initView();
        initListener();
    }

    private void initView() {
        this.setModal(true);
        this.setLayout(new BorderLayout());
        this.add(getPanel(), BorderLayout.CENTER);

        JPanel p = new JPanel();
        Dimension dd = new Dimension(60, 23);
        JButton ok = new JButton("确定");
        ok.setPreferredSize(dd);
        this.obj.put("confirm", ok);
        p.add(ok);
        JButton cancel = new JButton("取消");
        cancel.setPreferredSize(dd);
        this.obj.put("cancel", cancel);
        p.add(cancel);

        this.add(p, BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.setTitle("进程创建");
        this.pack();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dd1 = this.getSize();
        double sc_len = d.getWidth();
        double sc_hei = d.getHeight();
        int l_x = (int) (sc_len - dd1.width) / 2;
        int l_y = (int) (sc_hei - dd1.height) / 3;
        this.setLocation(l_x, l_y);

    }

    private JPanel getPanel() {
        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.WEST;
        c.insets = new Insets(15, 10, 0, 0);
        p.add(new JLabel("进程名称"), c);
        c.gridy++;
        c.insets = new Insets(10, 10, 10, 0);
        p.add(new JLabel("运行时间(秒)"), c);

        c.gridy = 0;
        c.gridx++;
        c.insets = new Insets(15, 20, 0, 10);
        JTextField name = new JTextField();
        name.setPreferredSize(new Dimension(80, 25));
        p.add(name, c);
        this.obj.put("name", name);
        c.gridy++;
        c.insets = new Insets(10, 20, 10, 10);
        JTextField time = new JTextField();
        time.setPreferredSize(new Dimension(80, 25));
        time.setText("60");
        p.add(time, c);
        this.obj.put("time", time);

        return p;
    }

    private void initListener() {
        JButton confirm = (JButton) this.obj.get("confirm");
        confirm.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JTextField jtf = (JTextField) obj.get("name");
                String name = jtf.getText().trim();
                if (name.equals("")) {
                    Util.showErrorMessage("进程名为空");
                    return;
                }

                JTextField jtf1 = (JTextField) obj.get("time");
                String time = jtf1.getText().trim();
                if (time.equals("")) {
                    Util.showErrorMessage("时间为空");
                    return;
                }
                
                Util.showPlateMessage("进程创建成功");

                JDialog root = (JDialog) obj.get("root");
                root.dispose();

            }
        });

        JButton cancel = (JButton) this.obj.get("cancel");
        cancel.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JDialog root = (JDialog) obj.get("root");
                root.dispose();
            }
        });
    }
}
