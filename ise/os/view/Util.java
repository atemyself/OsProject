package ise.os.view;

import javax.swing.JOptionPane;

/**
 * 一些工具函数
 *
 * @author yecq
 */
public class Util {

    public static void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "!", JOptionPane.ERROR_MESSAGE);
    }

    public static void showPlateMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "^_^", JOptionPane.PLAIN_MESSAGE);
    }
}
