package lzf.jzh.code;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 常量
 * Created in 2018-05-19 14:09
 *
 * @author Li Zhenfeng
 */
public interface Constant {
    /**
     * 字体
     */
    String FONT_PATH_1 = "font/FZLTS_GBK.TTF";
    /**
     * 字体
     */
    String MUSIC_PATH_1 = "music/lmqdha.mp3";
    /**
     * 统一背景
     */
    Color BACKGROUND_COLOR = new Color(62, 62, 62);
    /**
     * 字体颜色（白）
     */
    Color WHITE_COLOR_A = Color.WHITE;
    /**
     * 字体颜色（白）
     */
    Color WHITE_COLOR_B = new Color(204, 204, 204);
    /**
     * 字体颜色（红）
     */
    Color RED_COLOR_B = new Color(169, 0, 0);
    /**
     * 字体颜色（红）
     */
    Color RED_COLOR_A = Color.RED;
    /**
     * 月份字符串
     */
    List<String> MONTHS = new ArrayList<>();
    /**
     * 31天份字符串
     */
    List<String> DAYS_31 = new ArrayList<>();
    /**
     * 30天份字符串
     */
    List<String> DAYS_30 = new ArrayList<>();
    /**
     * 29天份字符串
     */
    List<String> DAYS_29 = new ArrayList<>();
    /**
     * 28天份字符串
     */
    List<String> DAYS_28 = new ArrayList<>();
    /**
     * 星期字符串
     */
    List<String> WEEKS = new ArrayList<>();
    /**
     * 小时字符串
     */
    List<String> HHS = new ArrayList<>();
    /**
     * 分钟字符串
     */
    List<String> MMS = new ArrayList<>();
    /**
     * 秒字符串
     */
    List<String> SSS = new ArrayList<>();

}
