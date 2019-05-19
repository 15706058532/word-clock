package lzf.jzh.code;

import java.awt.*;

/**
 * 系统的值
 * Created in 2018-05-19 14:00
 *
 * @author Li Zhenfeng
 */
public class SystemUtils {
    /**
     * 得到当前系统的宽
     */
    private static int systemWidth;
    /**
     * 得到当前系统的高
     */
    private static int systemHeight;

    static {
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        systemWidth = screenSize.width;
        systemHeight = screenSize.height;
    }

    /**
     * 宽度适配
     *
     * @param width 设置宽度
     * @return 适配后的宽度
     */
    public static int adaptWidth(int width) {
        return (int) (((double) width) / 1920 * SystemUtils.systemWidth);
    }

    /**
     * 高度适配
     *
     * @param height 设置高度
     * @return 适配后的高度
     */
    public static int adaptHeight(int height) {
        return (int) (((double) height) / 1080 * SystemUtils.systemHeight);
    }

    /**
     * 系统横向居中
     *
     * @param width 目标宽度
     * @return 居中后的X坐标
     */
    public static int transverseCenter(int width) {
        return systemWidth / 2 - width / 2;
    }

    /**
     * 系统纵向居中
     *
     * @param height 目标高度
     * @return 居中后的Y坐标
     */
    public static int portraitCenter(int height) {
        return systemHeight / 2 - height / 2;
    }

    /**
     * 系统横向居右
     *
     * @param width 目标宽度
     * @return 居右后的X坐标
     */
    public static int transverseRight(int width) {
        return systemWidth - width;
    }

    /**
     * 系统纵向居下
     *
     * @param height 目标高度
     * @return 居下后的Y坐标
     */
    public static int portraitBottom(int height) {
        return systemHeight - height;
    }

    public static int getSystemWidth() {
        return systemWidth;
    }

    public static int getSystemHeight() {
        return systemHeight;
    }
}
