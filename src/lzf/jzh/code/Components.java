package lzf.jzh.code;

import lzf.jzh.custom.LzfRotateLabel;

import java.util.ArrayList;
import java.util.List;

/**
 * 这里定义组件
 * Created in 2018-05-19 14:06
 *
 * @author Li Zhenfeng
 */
public class Components {
    /**
     * 主窗口
     */
    static MainFrame mainFrame = new MainFrame();
    /**
     * 年组件
     */
    static LzfRotateLabel yearLabel = new LzfRotateLabel();
    /**
     * 月组件集合
     */
    static List<LzfRotateLabel> monthLabels = new ArrayList<>();
    /**
     * 31日组件集合
     */
    static List<LzfRotateLabel> dayLabels31 = new ArrayList<>();
    /**
     * 30日组件集合
     */
    static List<LzfRotateLabel> dayLabels30 = new ArrayList<>();
    /**
     * 29日组件集合
     */
    static List<LzfRotateLabel> dayLabels29 = new ArrayList<>();
    /**
     * 28日组件集合
     */
    static List<LzfRotateLabel> dayLabels28 = new ArrayList<>();
    /**
     * 星期组件集合
     */
    static List<LzfRotateLabel> weekLabels = new ArrayList<>();
    /**
     * 时组件集合
     */
    static List<LzfRotateLabel> hhLabels = new ArrayList<>();
    /**
     * 分组件集合
     */
    static List<LzfRotateLabel> mmLabels = new ArrayList<>();
    /**
     * 秒组件集合
     */
    static List<LzfRotateLabel> ssLabels = new ArrayList<>();

}
