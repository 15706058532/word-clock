package lzf.jzh.custom;

import javax.swing.*;
import java.awt.*;

/**
 * 重写JLabel
 * Created in 2018-05-19 17:53
 *
 * @author Li Zhenfeng
 */
public class LzfAlphaLabel extends JLabel {
    private static final long serialVersionUID = 4714878332755369477L;

    public LzfAlphaLabel(String text, Icon icon, int horizontalAlignment) {
        super(text, icon, horizontalAlignment);
    }

    public LzfAlphaLabel(String text, int horizontalAlignment) {
        super(text, horizontalAlignment);
    }

    public LzfAlphaLabel(String text) {
        super(text);
    }

    public LzfAlphaLabel(Icon image, int horizontalAlignment) {
        super(image, horizontalAlignment);
    }

    public LzfAlphaLabel(Icon image) {
        super(image);
    }

    public LzfAlphaLabel() {
    }

    private AlphaComposite cmp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1);
    private float alpha = 1;

    /**
     * 设置透明度  1:不透明，0：透明
     *
     * @param alpha 透明度
     */
    public void setAlpha(float alpha) {
        this.alpha = alpha;
        if (isVisible()) {
            paintImmediately(getBounds());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setComposite(cmp.derive(alpha));
        super.paintComponent(g2d);
    }
}
