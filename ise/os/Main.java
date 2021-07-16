package ise.os;

import ise.os.view.MainFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author yecq
 */
public class Main {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }
}
