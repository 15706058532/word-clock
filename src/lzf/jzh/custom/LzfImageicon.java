package lzf.jzh.custom;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义图片类
 * Created in 2018-05-19 17:53
 *
 * @author Li Zhenfeng
 */
public class LzfImageicon extends ImageIcon {
    private static final long serialVersionUID = 1L;
    private Image image;
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     * 根据给定的path 创建ImageIcon
     *
     * @param path   生成图片路径
     * @param width  生成图片宽度
     * @param height 生成图片高度
     */
    public LzfImageicon(String path, int width, int height) {
        super();
        this.image = new ImageIcon(path).getImage();
        this.width = width;
        this.height = height;
    }

    /**
     * 根据给定的image 创建ImageIcon
     *
     * @param image
     * @param width  生成图片宽度
     * @param height 生成图片高度
     */
    public LzfImageicon(Image image, int width, int height) {
        super();
        this.image = image;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据给定的ImageIcon 创建ImageIcon
     *
     * @param imageIcon
     * @param width     生成图片宽度
     * @param height    生成图片高度
     */
    public LzfImageicon(ImageIcon imageIcon, int width, int height) {// 构造方法重载
        super();
        if (imageIcon == null) {
            imageIcon = new ImageIcon();
        }
        this.image = imageIcon.getImage();
        this.width = width;
        this.height = height;
    }

    /**
     * 根据给定的path 创建ImageIcon
     *
     * @param x      生成图片的相对起始x位置
     * @param y      生成图片的相对起始Y位置
     * @param width  生成图片宽度
     * @param height 生成图片高度
     */
    public LzfImageicon(String path, int x, int y, int width, int height) {// 构造方法重载
        super();
        this.image = new ImageIcon(path).getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据给定的imageIcon 创建ImageIcon
     *
     * @param imageIcon
     * @param x         生成图片的相对起始x位置
     * @param y         生成图片的相对起始Y位置
     * @param width     生成图片宽度
     * @param height    生成图片高度
     */
    public LzfImageicon(ImageIcon imageIcon, int x, int y, int width, int height) {
        super();
        this.image = imageIcon.getImage();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据给定的imageIcon 创建ImageIcon
     *
     * @param image
     * @param x      生成图片的相对起始x位置
     * @param y      生成图片的相对起始Y位置
     * @param width  生成图片宽度
     * @param height 生成图片高度
     */
    public LzfImageicon(Image image, int x, int y, int width, int height) {// 构造方法重载
        super();
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int a, int b) {// 重写父类方法
        super.paintIcon(c, g, a, b);
        g.drawImage(image, x, y, width, height, null);
    }
}
