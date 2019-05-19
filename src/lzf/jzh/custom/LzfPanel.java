package lzf.jzh.custom;

import javax.swing.*;
import java.awt.*;

/**
 * 重写JPanel
 * Created in 2018-08-2 00:01
 *
 * @author Li Zhenfeng
 */
public class LzfPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private Image image;
    private int width;
    private int height;
    private int x;
    private int y;

    /**
     * 根据 图片路径 和宽度高度 创建
     *
     * @param imagepath
     * @param width
     * @param height
     */
    public LzfPanel(String imagepath, int width, int height) {
        super();
        this.image = new ImageIcon(imagepath).getImage();
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据 {@Image Image} 和宽度高度 创建
     *
     * @param image
     * @param width
     * @param height
     */

    public LzfPanel(Image image, int width, int height) {
        super();
        this.image = image;
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    /**
     * 根据{@ImageIcon ImageIcon} 和宽度高度 创建
     *
     * @param imageIcon
     * @param width
     * @param height
     */
    public LzfPanel(ImageIcon imageIcon, int width, int height) {
        super();
        this.image = imageIcon.getImage();
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
    }

    public LzfPanel(LayoutManager layout, boolean isDoubleBuffered, Image image) {
        super(layout, isDoubleBuffered);
        this.image = image;
    }

    public LzfPanel(LayoutManager layout, Image image) {
        super(layout);
        this.image = image;
    }

    public LzfPanel(boolean isDoubleBuffered, Image image) {
        super(isDoubleBuffered);
        this.image = image;
    }

    public LzfPanel(Image image) {
        this.image = image;
    }

    public LzfPanel() {
        super();
    }

    /**
     * 重写父类的方法
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, width, height, null);
    }

    /**
     * 更新图片设置
     *
     * @param imagepath
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void updateImage(String imagepath, int x, int y, int width, int height) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.image = new ImageIcon(imagepath).getImage();
        paintComponent(getGraphics());
        updateUI();
    }

}
