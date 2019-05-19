package lzf.jzh.code;


import lzf.jzh.resource.Resource;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 写点注释
 * Created in 2018-05-19 14:03
 *
 * @author Li Zhenfeng
 */
public class Utils {
    /**
     * 设置睡眠时间(毫秒)
     *
     * @param time
     */
    public static void sleep(int time) {
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取字体
     *
     * @param path
     * @param style
     * @param size
     * @return
     */
    static Font getFont(String path, int style, int size) {
        // 创建一个新的字体类
        Font font = new Font(null, style, size);
        try {
            // 倒入字体
            font = Font.createFont(Font.TRUETYPE_FONT, Resource.getResourceURL(path).openStream());
            // 复制字体到新字体
            font = font.deriveFont(style, size);
        } catch (Exception e1) {
            JOptionPane.showMessageDialog(Components.mainFrame, "字体加载异常");
        }
        return font;
    }

    private final static ThreadPoolExecutor EXECUTOR = new ThreadPoolExecutor(10, 50, 60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10), new ThreadPoolExecutor.CallerRunsPolicy());

    /**
     * 使用线程池 (这样写不是很合适啊~~~)
     */
    public static ThreadPoolExecutor getExecutor() {

        return EXECUTOR;
    }

}
