package ise.os.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 主界面
 *
 * @author yecq
 */
public class MainFrame extends JFrame {

    private Map obj;

    public MainFrame() {
        this.obj = new HashMap();
        this.obj.put("root", this);
        initView();
        initListener();

        this.pack();
        // 调整表格大小
        ((MyPanel) this.obj.get("panel")).adjustTableWidth();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension dd1 = this.getSize();
        double sc_len = d.getWidth();
        double sc_hei = d.getHeight();
        int l_x = (int) (sc_len - dd1.width) / 2;
        int l_y = (int) (sc_hei - dd1.height) / 3;
        this.setLocation(l_x, l_y);

    }

    private void initView() {
        this.setLayout(new BorderLayout());
        this.setJMenuBar(new MyMenuBar());
        MyPanel panel = new MyPanel();
        this.obj.put("panel", panel);
        this.add(panel, BorderLayout.CENTER);

        this.setTitle("操作系统实验");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    private void initListener() {
        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                JFrame root = (JFrame) obj.get("root");
                if (JOptionPane.showConfirmDialog(null, "是否要退出", "?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    root.dispose();
                    System.exit(0);
                }
            }
        });
    }
}
