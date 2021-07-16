package ise.os.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * 菜单栏
 *
 * @author yecq
 */
class MyMenuBar extends JMenuBar {

    private Map obj;

    MyMenuBar() {
        this.obj = new HashMap();
        this.obj.put("root", this);
        initView();
        initListener();
    }

    private void initView() {
        JMenu menu = new JMenu("信息");
        JMenuItem author = new JMenuItem("作者");
        menu.add(author);
        this.obj.put("author", author);

        this.add(menu);
    }

    private void initListener() {
        JMenuItem author = (JMenuItem) obj.get("author");
        author.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String[] authors = {"同学甲", "同学乙"};
                String str = "";
                for (int i = 0; i < authors.length; i++) {
                    str += authors[i] + "\n";
                }
                str = str.substring(0, str.length() - 1);
                Util.showPlateMessage(str);

            }
        });
    }
}
