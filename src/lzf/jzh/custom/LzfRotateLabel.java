package lzf.jzh.custom;

import javax.swing.*;
import java.awt.*;

/**
 * 重写JLabel
 * Created in 2018-05-19 17:53
 *
 * @author Li Zhenfeng
 */
public class LzfRotateLabel extends JLabel {
    private static final long serialVersionUID = 4714878332755369477L;

    public LzfRotateLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public LzfRotateLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public LzfRotateLabel(String text) {
        super(text);
    }

    public LzfRotateLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public LzfRotateLabel(Icon image) {
        super(image);
    }

    public LzfRotateLabel() {
    }

    private double theta = 0;

    /**
     * 设置旋转角度
     *
     * @param theta 旋转角度
     */
    public void setTheta(float theta) {
        this.theta = theta;
        if (isVisible()) {
            paintImmediately(getBounds());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = getWidth(), h = getHeight();
        double theta = Math.toRadians(this.theta);
        Graphics2D g2d = (Graphics2D) g;
        // 消除锯齿
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        renderingHints.put(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        g2d.setRenderingHints(renderingHints);
        w = w / 2;
        h = h / 2;
        g2d.rotate(theta, w, h);
        super.paintComponent(g);
    }
}
