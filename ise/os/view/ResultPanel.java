package ise.os.view;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 * 还没做，放着占个位置
 * @author yecq
 */
class ResultPanel extends JPanel {

    ResultPanel() {
        initView();
        initListener();
    }

    private void initView() {
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setBackground(Color.LIGHT_GRAY);
    }

    private void initListener() {

    }
}
