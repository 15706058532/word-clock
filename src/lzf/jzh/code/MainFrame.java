package lzf.jzh.code;

import lzf.jzh.custom.LzfRotateLabel;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 最外面的框
 * Created in 2018-05-03 23:25
 *
 * @author Li Zhenfeng
 */
public class MainFrame extends JDialog {
    private static final long serialVersionUID = 3002753184656911059L;

    MainFrame() {
        setLayout(null);
        setBounds(0, 0, SystemUtils.getSystemWidth(), SystemUtils.getSystemHeight());
        //隐藏边框
        setUndecorated(true);
        //设置显示在所有程序最上面
        setAlwaysOnTop(true);
        //将背lovelovelovelove
        // 景设置为透明
//        setBackground(new Color(0, 0, 0, 0));
        getContentPane().setBackground(Constant.BACKGROUND_COLOR);
        setVisible(true);
        //设置为DO_NOTHING_ON_CLOSE 不允许程序通过关闭窗口来结束
        setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        addKeyListener(new KeyListener() {
            List<Integer> keys = new ArrayList<>();
            @Override
            public void keyTyped(KeyEvent e) {

            }
            @Override
            public void keyPressed(KeyEvent e) {
                //退出指令键盘敲击 l o v e 键
                int keyCode = e.getKeyCode();
                if (!keys.isEmpty() && keys.get(keys.size() - 1) == keyCode) {
                    return;
                }
                if (keyCode == 76 && keys.isEmpty()) {
                    keys.add(keyCode);
                } else if (keyCode == 79 && keys.size() == 1) {
                    keys.add(keyCode);
                } else if (keyCode == 86 && keys.size() == 2) {
                    keys.add(keyCode);
                } else if (keyCode == 69 && keys.size() == 3) {
                    System.exit(0);
                } else {
                    keys.clear();
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
    }

    /**
     * 添加心组件集合
     */
    public void addList(List<LzfRotateLabel> list) {
        for (JLabel label : list) {
            add(label);
        }
    }

    /**
     * 移除心组件集合
     */
    public void removeList(List<LzfRotateLabel> list) {
        for (JLabel label : list) {
            remove(label);
        }
    }
}
