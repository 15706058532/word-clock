package lzf.jzh.code;

import lzf.jzh.custom.LzfRotateLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

/**
 * 写点注释
 * <br/>
 * Created in 2019-05-18 9:50
 *
 * @author Li Zhenfeng
 */
public class Function {
    private static Font font = Utils.getFont(Constant.FONT_PATH_1, Font.BOLD, SystemUtils.adaptWidth(16));
    private static long timeStamp;

    /**
     * 初始化方法
     */
    public static void init() {
        MainFrame mainFrame = Components.mainFrame;
        LzfRotateLabel yearLabel = Components.yearLabel;
        List<LzfRotateLabel> monthLabels = Components.monthLabels;
        List<LzfRotateLabel> dayLabels31 = Components.dayLabels31;
        List<LzfRotateLabel> dayLabels30 = Components.dayLabels30;
        List<LzfRotateLabel> dayLabels29 = Components.dayLabels29;
        List<LzfRotateLabel> dayLabels28 = Components.dayLabels28;
        List<LzfRotateLabel> weekLabels = Components.weekLabels;
        List<LzfRotateLabel> hhLabels = Components.hhLabels;
        List<LzfRotateLabel> mmLabels = Components.mmLabels;
        List<LzfRotateLabel> ssLabels = Components.ssLabels;
        //月份
        for (int i = 1; i <= 12; i++) {
            String month = getNumber(i) + "月";
            LzfRotateLabel label = new LzfRotateLabel(month);
            monthLabels.add(label);
            label = new LzfRotateLabel(month);
            monthLabels.add(label);
            Constant.MONTHS.add(month);
            Constant.MONTHS.add(month);
        }
        //天数
        for (int i = 1; i <= 31; i++) {
            String day = getNumber(i) + "号";
            LzfRotateLabel label = new LzfRotateLabel(day);
            dayLabels31.add(label);
            label = new LzfRotateLabel(day);
            dayLabels31.add(label);
            Constant.DAYS_31.add(day);
            Constant.DAYS_31.add(day);
            if (i < 31) {
                label = new LzfRotateLabel(day);
                dayLabels30.add(label);
                label = new LzfRotateLabel(day);
                dayLabels30.add(label);
                Constant.DAYS_30.add(day);
                Constant.DAYS_30.add(day);
            }
            if (i < 30) {
                label = new LzfRotateLabel(day);
                dayLabels29.add(label);
                label = new LzfRotateLabel(day);
                dayLabels29.add(label);
                Constant.DAYS_29.add(day);
                Constant.DAYS_29.add(day);
            }
            if (i < 29) {
                label = new LzfRotateLabel(day);
                dayLabels28.add(label);
                label = new LzfRotateLabel(day);
                dayLabels28.add(label);
                Constant.DAYS_28.add(day);
                Constant.DAYS_28.add(day);
            }
        }
        //周数
        for (int i = 1; i <= 7; i++) {
            String week = "星期" + getNumber(i);
            if (i == 7) {
                week = "星期日";
            }
            LzfRotateLabel label = new LzfRotateLabel(week);
            weekLabels.add(label);
            label = new LzfRotateLabel(week);
            weekLabels.add(label);
            Constant.WEEKS.add(week);
            Constant.WEEKS.add(week);
        }
        //时
        for (int i = 0; i <= 23; i++) {
            String hh = getNumber(i) + "点";
            LzfRotateLabel label = new LzfRotateLabel(hh);
            hhLabels.add(label);
            label = new LzfRotateLabel(hh);
            hhLabels.add(label);
            Constant.HHS.add(hh);
            Constant.HHS.add(hh);
        }
        //分
        for (int i = 0; i <= 59; i++) {
            String mm = getNumber(i) + "分";
            LzfRotateLabel label = new LzfRotateLabel(mm);
            mmLabels.add(label);
            label = new LzfRotateLabel(mm);
            mmLabels.add(label);
            Constant.MMS.add(mm);
            Constant.MMS.add(mm);
        }
        //秒
        for (int i = 0; i <= 59; i++) {
            String ss = getNumber(i) + "秒";
            LzfRotateLabel label = new LzfRotateLabel(ss);
            ssLabels.add(label);
            label = new LzfRotateLabel(ss);
            ssLabels.add(label);
            Constant.SSS.add(ss);
            Constant.SSS.add(ss);
        }
        //组件宽度
        int componentSize = 75;
        //年
        yearLabel.setText("爱你一万年");
        yearLabel.setFont(font);
        yearLabel.setForeground(Constant.RED_COLOR_A);
        yearLabel.setBackground(Constant.BACKGROUND_COLOR);
        yearLabel.setHorizontalAlignment(SwingConstants.CENTER);
        yearLabel.setBounds(SystemUtils.getSystemWidth() / 2 - SystemUtils.adaptWidth((componentSize + 25) / 2), SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(20), SystemUtils.adaptWidth(componentSize + 25), SystemUtils.adaptHeight(40));
        //秒
        List<Point> points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2), 6);
        setPoint(ssLabels, componentSize, points, 6f);
        //分
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize), 6);
        setPoint(mmLabels, componentSize, points, 6f);
        //时
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 2), 15);
        setPoint(hhLabels, componentSize, points, 15f);
        //星期
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 3), 52);
        setPoint(weekLabels, componentSize, points, 52f);
        //31天
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 4), 11.7);
        setPoint(dayLabels31, componentSize, points, 11.7f);
        //30天
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 4), 12);
        setPoint(dayLabels30, componentSize, points, 12f);
        //29天
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 4), 12.5);
        setPoint(dayLabels29, componentSize, points, 12.5f);
        //28天
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 4), 12.9);
        setPoint(dayLabels28, componentSize, points, 12.9f);
        //月
        points = initPointsCircular(SystemUtils.getSystemWidth() / 2, SystemUtils.getSystemHeight() / 2, SystemUtils.getSystemHeight() / 2 - SystemUtils.adaptHeight(componentSize / 2) - SystemUtils.adaptHeight(componentSize * 5), 30);
        setPoint(monthLabels, componentSize, points, 30);
        mainFrame.add(yearLabel);
        mainFrame.addList(ssLabels);
        mainFrame.addList(mmLabels);
        mainFrame.addList(hhLabels);
        mainFrame.addList(weekLabels);
        mainFrame.addList(dayLabels31);
        mainFrame.addList(dayLabels30);
        mainFrame.addList(dayLabels29);
        mainFrame.addList(dayLabels28);
        mainFrame.addList(dayLabels31);
        mainFrame.addList(monthLabels);
        mainFrame.update(mainFrame.getGraphics());
    }


    /**
     * 设置坐标
     *
     * @param mmLabels      组件
     * @param componentSize 组件大小
     * @param points        坐标
     * @param interval      旋转度
     */
    private static void setPoint(List<LzfRotateLabel> mmLabels, int componentSize, List<Point> points, float interval) {
        for (int i = 0; i < points.size(); i++) {
            LzfRotateLabel rotateLabel = mmLabels.get(i);
            Point point = points.get(i);
            rotateLabel.setBounds(point.x - SystemUtils.adaptHeight(componentSize / 2), point.y - SystemUtils.adaptHeight(componentSize / 2), SystemUtils.adaptHeight(componentSize), SystemUtils.adaptHeight(componentSize));
            if (i % 2 == 0) {
                rotateLabel.setTheta((int) (i / 2) * interval);
                rotateLabel.setForeground(Constant.WHITE_COLOR_A);
            } else {
                rotateLabel.setTheta(((int) (i / 2)) * interval - interval / 2);
                rotateLabel.setForeground(Constant.WHITE_COLOR_B);
            }
            rotateLabel.setFont(font);
            rotateLabel.setBackground(Constant.BACKGROUND_COLOR);
            rotateLabel.setVisible(false);
        }
    }

    /**
     * 初始显示
     */
    public static void showInit() {
        //   int time = 1;
        int time = 900;

        Components.yearLabel.setVisible(true);
        Components.yearLabel.setForeground(Constant.RED_COLOR_A);
        Utils.sleep(time);

        Components.monthLabels.get(0).setVisible(true);
        Components.monthLabels.get(0).setForeground(Constant.RED_COLOR_A);
        Components.monthLabels.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);

        //31
        Components.dayLabels31.get(0).setVisible(true);
        Components.dayLabels31.get(0).setForeground(Constant.RED_COLOR_A);
        Components.dayLabels31.get(1).setForeground(Constant.RED_COLOR_B);
        //30
        Components.dayLabels30.get(0).setVisible(true);
        Components.dayLabels30.get(0).setForeground(Constant.RED_COLOR_A);
        Components.dayLabels30.get(1).setForeground(Constant.RED_COLOR_B);
        //29
        Components.dayLabels29.get(0).setVisible(true);
        Components.dayLabels29.get(0).setForeground(Constant.RED_COLOR_A);
        Components.dayLabels29.get(1).setForeground(Constant.RED_COLOR_B);
        //28
        Components.dayLabels28.get(0).setVisible(true);
        Components.dayLabels28.get(0).setForeground(Constant.RED_COLOR_A);
        Components.dayLabels28.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);

        Components.weekLabels.get(0).setVisible(true);
        Components.weekLabels.get(0).setForeground(Constant.RED_COLOR_A);
        Components.weekLabels.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);

        Components.hhLabels.get(0).setVisible(true);
        Components.hhLabels.get(0).setForeground(Constant.RED_COLOR_A);
        Components.hhLabels.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);

        Components.mmLabels.get(0).setVisible(true);
        Components.mmLabels.get(0).setForeground(Constant.RED_COLOR_A);
        Components.mmLabels.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);

        Components.ssLabels.get(0).setVisible(true);
        Components.ssLabels.get(0).setForeground(Constant.RED_COLOR_A);
        Components.ssLabels.get(1).setForeground(Constant.RED_COLOR_B);
        Utils.sleep(time);
    }

    /**
     * 依次显示外圈
     */
    public static void roundShow() {
        int time = 500;
        //  int time = 1;
        doRoundShow(Components.monthLabels);
        doRoundShow(Components.dayLabels31);
        doRoundShow(Components.weekLabels);
        doRoundShow(Components.hhLabels);
        doRoundShow(Components.mmLabels);
        doRoundShow(Components.ssLabels);
        Utils.sleep(time);
    }

    public static void doRoundShow(List<LzfRotateLabel> labels) {
        //   int time = 1;
        int time = 40;
        for (int i = 0; i < labels.size(); i += 2) {
            labels.get(i).setVisible(true);
            Utils.sleep(time);
        }

    }

    public static void rotate() {
        Timer timer = new Timer(1000, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Utils.getExecutor().execute(new Runnable() {
                    @Override
                    public void run() {
                        List<String> sss = Constant.SSS;
                        List<String> mms = Constant.MMS;
                        List<String> hhs = Constant.HHS;
                        List<String> weeks = Constant.WEEKS;
                        List<String> days31 = Constant.DAYS_31;
                        List<String> days30 = Constant.DAYS_30;
                        List<String> days29 = Constant.DAYS_29;
                        List<String> days28 = Constant.DAYS_28;
                        List<String> months = Constant.MONTHS;

                        String nowS = sss.get(0);
                        String nowM = mms.get(0);
                        String nowH = hhs.get(0);
                        String nowWeek = weeks.get(0);
                        String nowD31 = days31.get(0);
                        String nowD30 = days30.get(0);
                        String nowD29 = days29.get(0);
                        String nowD28 = days28.get(0);
                        String nowMonth = months.get(0);

                        List<LzfRotateLabel> monthLabels = Components.monthLabels;
                        LzfRotateLabel yearLabel = Components.yearLabel;
                        List<LzfRotateLabel> dayLabels31 = Components.dayLabels31;
                        List<LzfRotateLabel> dayLabels30 = Components.dayLabels30;
                        List<LzfRotateLabel> dayLabels29 = Components.dayLabels29;
                        List<LzfRotateLabel> dayLabels28 = Components.dayLabels28;
                        List<LzfRotateLabel> weekLabels = Components.weekLabels;
                        List<LzfRotateLabel> hhLabels = Components.hhLabels;
                        List<LzfRotateLabel> mmLabels = Components.mmLabels;
                        List<LzfRotateLabel> ssLabels = Components.ssLabels;

                        Calendar instance = Calendar.getInstance();
                        instance.setTimeInMillis(timeStamp);
                        int maxDayNum = instance.getActualMaximum(Calendar.DATE);

                        boolean ss = "五十九秒".equals(nowS);
                        boolean mm = "五十九分".equals(nowM);
                        boolean hh = "二十三点".equals(nowH);
                        boolean week = "星期日".equals(nowWeek);
                        boolean day;
                        switch (maxDayNum) {
                            case 31:
                                day = "三十一号".equals(nowD31);
                                break;
                            case 30:
                                day = "三十号".equals(nowD30);
                                break;
                            case 29:
                                day = "二十九号".equals(nowD29);
                                break;
                            default:
                                day = "二十八号".equals(nowD28);
                                break;

                        }
                        boolean month = "十二月".equals(nowMonth);
                        //月
                        if (ss && mm && hh && day) {
                            for (int i = 0; i < monthLabels.size(); i++) {
                                LzfRotateLabel label = monthLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                                label.updateUI();
                            }
                        }
                        //周/天
                        if (ss && mm && hh) {
                            for (int i = 0; i < weekLabels.size(); i++) {
                                LzfRotateLabel label = weekLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(false);
                                } else {
                                    label.setVisible(true);
                                }
                            }
                            //顺序31,30,29,28
                            boolean[] showDays = {false, false, false, false};
                            showDays[31 - maxDayNum] = true;
                            //31天
                            for (int i = 0; i < dayLabels31.size(); i++) {
                                LzfRotateLabel label = dayLabels31.get(i);
                                if (showDays[0]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(false);
                                    } else {
                                        label.setVisible(true);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days31.get(i));
                            }
                            //30天
                            for (int i = 0; i < dayLabels30.size(); i++) {
                                LzfRotateLabel label = dayLabels30.get(i);
                                if (showDays[1]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(false);
                                    } else {
                                        label.setVisible(true);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days30.get(i));
                            }
                            //29天
                            for (int i = 0; i < dayLabels29.size(); i++) {
                                LzfRotateLabel label = dayLabels29.get(i);
                                if (showDays[2]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(false);
                                    } else {
                                        label.setVisible(true);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days29.get(i));
                            }
                            //28天
                            for (int i = 0; i < dayLabels28.size(); i++) {
                                LzfRotateLabel label = dayLabels28.get(i);
                                if (showDays[3]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(false);
                                    } else {
                                        label.setVisible(true);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days28.get(i));
                            }

                        }
                        //时
                        if (ss && mm) {
                            for (int i = 0; i < hhLabels.size(); i++) {
                                LzfRotateLabel label = hhLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(false);
                                } else {
                                    label.setVisible(true);
                                }
                            }
                        }
                        //分
                        if (ss) {
                            for (int i = 0; i < mmLabels.size(); i++) {
                                LzfRotateLabel label = mmLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(false);
                                } else {
                                    label.setVisible(true);
                                }
                            }
                        }
                        //秒
                        for (int i = 0; i < ssLabels.size(); i++) {
                            LzfRotateLabel label = ssLabels.get(i);
                            if (i % 2 == 0) {
                                label.setVisible(true);
                            } else {
                                label.setVisible(false);
                            }
                            label.updateUI();
                        }
//------------------------------------------------------------------------
//                        Utils.sleep(300);
                        //月
                        if (ss && mm && hh && day) {
                            String monthLast = months.get(0);
                            months.add(monthLast);
                            months.add(monthLast);
                            months.remove(0);
                            months.remove(0);
                            for (int i = 0; i < monthLabels.size(); i++) {
                                LzfRotateLabel label = monthLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                            }

                        }
                        //周/天
                        if (ss && mm & hh) {
                            String weekLast = weeks.get(0);
                            weeks.add(weekLast);
                            weeks.add(weekLast);
                            weeks.remove(0);
                            weeks.remove(0);
                            for (int i = 0; i < weekLabels.size(); i++) {
                                LzfRotateLabel label = weekLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                            }

                            //顺序31,30,29,28
                            boolean[] showDays = {false, false, false, false};
                            showDays[31 - maxDayNum] = true;
                            //31天
                            String days31Last = days31.get(0);
                            days31.add(days31Last);
                            days31.add(days31Last);
                            days31.remove(0);
                            days31.remove(0);
                            for (int i = 0; i < dayLabels31.size(); i++) {
                                LzfRotateLabel label = dayLabels31.get(i);
                                if (showDays[0]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days31.get(i));
                            }
                            //30天
                            String days30Last = days30.get(0);
                            days30.add(days30Last);
                            days30.add(days30Last);
                            days30.remove(0);
                            days30.remove(0);
                            for (int i = 0; i < dayLabels30.size(); i++) {
                                LzfRotateLabel label = dayLabels30.get(i);
                                if (showDays[1]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days30.get(i));
                            }
                            //29天
                            String days29Last = days29.get(0);
                            days29.add(days29Last);
                            days29.add(days29Last);
                            days29.remove(0);
                            days29.remove(0);
                            for (int i = 0; i < dayLabels29.size(); i++) {
                                LzfRotateLabel label = dayLabels29.get(i);
                                if (showDays[2]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days29.get(i));
                            }
                            //28天
                            String days28Last = days28.get(0);
                            days28.add(days28Last);
                            days28.add(days28Last);
                            days28.remove(0);
                            days28.remove(0);
                            for (int i = 0; i < dayLabels28.size(); i++) {
                                LzfRotateLabel label = dayLabels28.get(i);
                                if (showDays[3]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days28.get(i));
                            }
                        }
                        //时
                        if (ss && mm) {
                            String hhLast = hhs.get(0);
                            hhs.add(hhLast);
                            hhs.add(hhLast);
                            hhs.remove(0);
                            hhs.remove(0);
                            for (int i = 0; i < hhLabels.size(); i++) {
                                LzfRotateLabel label = hhLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                            }
                        }
                        //分
                        if (ss) {
                            String mmLast = mms.get(0);
                            mms.add(mmLast);
                            mms.add(mmLast);
                            mms.remove(0);
                            mms.remove(0);
                            for (int i = 0; i < mmLabels.size(); i++) {
                                LzfRotateLabel label = mmLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(false);
                                } else {
                                    label.setVisible(true);
                                }
                            }

                        }
                        //秒
                        for (int i = 0; i < ssLabels.size(); i++) {
                            LzfRotateLabel label = ssLabels.get(i);
                            if (i % 2 == 0) {
                                label.setVisible(false);
                            } else {
                                label.setVisible(true);
                            }
                        }
                        sss.add(nowS);
                        sss.add(nowS);
                        sss.remove(0);
                        sss.remove(0);

                        Utils.sleep(200);
//------------------------------------------------------------------------
                        //年
                        if (ss && mm && hh && day && month) {
                            instance.setTimeInMillis(timeStamp + 1000);
                            yearLabel.setText(getNumber(instance.get(Calendar.YEAR)) + "年");
                        }
                        //月
                        if (ss && mm && hh && day) {
                            for (int i = 0; i < monthLabels.size(); i++) {
                                LzfRotateLabel label = monthLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(months.get(i));
                            }
                        }
                        //周/天
                        if (ss && mm && hh) {
                            for (int i = 0; i < weekLabels.size(); i++) {
                                LzfRotateLabel label = weekLabels.get(i);
                                if (i % 2 == 0) {
                                    label.setVisible(true);
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(weeks.get(i));
                            }
                            instance.setTimeInMillis(timeStamp + 1000);
                            maxDayNum = instance.getActualMaximum(Calendar.DATE);
                            //顺序31,30,29,28
                            boolean[] showDays = {false, false, false, false};
                            showDays[31 - maxDayNum] = true;
                            //31天
                            for (int i = 0; i < dayLabels31.size(); i++) {
                                LzfRotateLabel label = dayLabels31.get(i);
                                if (showDays[0]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days31.get(i));
                            }
                            //30天
                            for (int i = 0; i < dayLabels30.size(); i++) {
                                LzfRotateLabel label = dayLabels30.get(i);
                                if (showDays[1]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days30.get(i));
                            }
                            //29天
                            for (int i = 0; i < dayLabels29.size(); i++) {
                                LzfRotateLabel label = dayLabels29.get(i);
                                if (showDays[2]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days29.get(i));
                            }
                            //28天
                            for (int i = 0; i < dayLabels28.size(); i++) {
                                LzfRotateLabel label = dayLabels28.get(i);
                                if (showDays[3]) {
                                    if (i % 2 == 0) {
                                        label.setVisible(true);
                                    } else {
                                        label.setVisible(false);
                                    }
                                } else {
                                    label.setVisible(false);
                                }
                                label.setText(days28.get(i));
                            }

                        }
                        //时
                        for (int i = 0; ss && mm && i < hhLabels.size(); i++) {
                            LzfRotateLabel label = hhLabels.get(i);
                            if (i % 2 == 0) {
                                label.setVisible(true);
                            } else {
                                label.setVisible(false);
                            }
                            label.setText(hhs.get(i));
                        }
                        //分
                        for (int i = 0; ss && i < mmLabels.size(); i++) {
                            LzfRotateLabel label = mmLabels.get(i);
                            if (i % 2 == 0) {
                                label.setVisible(true);
                            } else {
                                label.setVisible(false);
                            }
                            label.setText(mms.get(i));
                        }
                        //秒
                        for (int i = 0; i < ssLabels.size(); i++) {
                            LzfRotateLabel label = ssLabels.get(i);
                            if (i % 2 == 0) {
                                label.setVisible(true);
                            } else {
                                label.setVisible(false);
                            }
                            label.setText(sss.get(i));
                        }
                        //每次加一秒
                        timeStamp += 1000;
                    }
                });

            }
        });
        timer.start();
    }

    /**
     * 将数字转换为大写
     *
     * @param num 原始数字
     * @return 转换后的数字字符串
     */
    private static String getNumber(int num) {
        String[] number = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九", "十"};
        if (num < 11) {
            return number[num];
        }
        String result = "";
        if (num > 1000) {
            int oneNum = num % 10;
            int twoNum = num / 10 % 10;
            int threeNum = num / 100 % 10;
            int fourNum = num / 1000 % 10;
            result += number[fourNum];
            result += number[threeNum];
            result += number[twoNum];
            result += number[oneNum];
            return result;
        }
        int oneNum = num % 10;
        int twoNum = num / 10;
        if (twoNum > 1) {
            result += number[twoNum];
        }
        result += number[10];
        if (oneNum > 0) {
            result += number[oneNum];
        }
        return result;
    }

    /**
     * 获取一组坐标
     *
     * @param x0    圆心X坐标
     * @param y0    圆心Y坐标
     * @param r     半径
     * @param angle 间隔角度
     */
    private static List<Point> initPointsCircular(int x0, int y0, int r, double angle) {
        List<Point> points = new LinkedList<>();
        //均分360份
        for (double i = 0; i < 360; i += angle) {
            int x = (int) (x0 + r * Math.cos(Math.PI * (i) / 180));
            int y = (int) (y0 + r * Math.sin(Math.PI * (i) / 180));
            //多算一度坐标，目的 看起来更像旋转
            int x2 = (int) (x0 + r * Math.cos(Math.PI * (i - angle / 2) / 180));
            int y2 = (int) (y0 + r * Math.sin(Math.PI * (i - angle / 2) / 180));
            points.add(new Point(x, y));
            points.add(new Point(x2, y2));
        }
        return points;
    }

    /**
     * 校准时间
     */
    public static void calibration() {
        Calendar instance = Calendar.getInstance();
        //将时间存起来
        timeStamp = instance.getTimeInMillis();
        int year = instance.get(Calendar.YEAR);
        int month = instance.get(Calendar.MONTH) + 1;
        int day = instance.get(Calendar.DAY_OF_MONTH);
        int week = instance.get(Calendar.DAY_OF_WEEK);
        week = week < 2 ? week + 6 : week - 1;
        int hh = instance.get(Calendar.HOUR_OF_DAY);
        int mm = instance.get(Calendar.MINUTE);
        int ss = instance.get(Calendar.SECOND);

        int maxDayNum = instance.getActualMaximum(Calendar.DATE);

        List<String> sss = Constant.SSS;
        List<String> mms = Constant.MMS;
        List<String> hhs = Constant.HHS;
        List<String> weeks = Constant.WEEKS;
        List<String> days31 = Constant.DAYS_31;
        List<String> days30 = Constant.DAYS_30;
        List<String> days29 = Constant.DAYS_29;
        List<String> days28 = Constant.DAYS_28;
        List<String> months = Constant.MONTHS;

        List<LzfRotateLabel> monthLabels = Components.monthLabels;
        LzfRotateLabel yearLabel = Components.yearLabel;
        List<LzfRotateLabel> dayLabels31 = Components.dayLabels31;
        List<LzfRotateLabel> dayLabels30 = Components.dayLabels30;
        List<LzfRotateLabel> dayLabels29 = Components.dayLabels29;
        List<LzfRotateLabel> dayLabels28 = Components.dayLabels28;
        List<LzfRotateLabel> weekLabels = Components.weekLabels;
        List<LzfRotateLabel> hhLabels = Components.hhLabels;
        List<LzfRotateLabel> mmLabels = Components.mmLabels;
        List<LzfRotateLabel> ssLabels = Components.ssLabels;

        List<String> temp = new ArrayList<>();

        //秒
        temp.addAll(sss.subList(sss.indexOf(getNumber(ss) + "秒"), sss.size()));
        temp.addAll(sss.subList(0, sss.indexOf(getNumber(ss) + "秒")));
        sss.clear();
        sss.addAll(temp);
        for (int i = 0; i < ssLabels.size(); i++) {
            LzfRotateLabel label = ssLabels.get(i);
            if (i % 2 == 0) {
                label.setVisible(true);
            } else {
                label.setVisible(false);
            }
            label.setText(temp.get(i));
        }
        //分
        temp.clear();
        temp.addAll(mms.subList(mms.indexOf(getNumber(mm) + "分"), mms.size()));
        temp.addAll(mms.subList(0, mms.indexOf(getNumber(mm) + "分")));
        mms.clear();
        mms.addAll(temp);
        for (int i = 0; i < mmLabels.size(); i++) {
            LzfRotateLabel label = mmLabels.get(i);
            if (i % 2 == 0) {
                label.setVisible(true);
            } else {
                label.setVisible(false);
            }
            label.setText(temp.get(i));
        }
        //时
        temp.clear();
        temp.addAll(hhs.subList(hhs.indexOf(getNumber(hh) + "点"), hhs.size()));
        temp.addAll(hhs.subList(0, hhs.indexOf(getNumber(hh) + "点")));
        hhs.clear();
        hhs.addAll(temp);
        for (int i = 0; i < hhLabels.size(); i++) {
            LzfRotateLabel label = hhLabels.get(i);
            if (i % 2 == 0) {
                label.setVisible(true);
            } else {
                label.setVisible(false);
            }
            label.setText(temp.get(i));
        }
        //周
        temp.clear();
        temp.addAll(weeks.subList(weeks.indexOf("星期" + ("七".equals(getNumber(week)) ? "日" : getNumber(week))), weeks.size()));
        temp.addAll(weeks.subList(0, weeks.indexOf("星期" + ("七".equals(getNumber(week)) ? "日" : getNumber(week)))));
        weeks.clear();
        weeks.addAll(temp);
        for (int i = 0; i < weekLabels.size(); i++) {
            LzfRotateLabel label = weekLabels.get(i);
            if (i % 2 == 0) {
                label.setVisible(true);
            } else {
                label.setVisible(false);
            }
            label.setText(temp.get(i));
        }
        //顺序31,30,29,28
        boolean[] showDays = {false, false, false, false};
        showDays[31 - maxDayNum] = true;
        //31天
        if (showDays[0]) {
            temp.clear();
            temp.addAll(days31.subList(days31.indexOf(getNumber(day) + "号"), days31.size()));
            temp.addAll(days31.subList(0, days31.indexOf(getNumber(day) + "号")));
            days31.clear();
            days31.addAll(temp);

        } else {
            String last = days31.get(days31.size() - 1);
            days31.add(0, last);
            days31.add(0, last);
            days31.remove(days31.size() - 1);
            days31.remove(days31.size() - 1);
        }
        for (int i = 0; i < dayLabels31.size(); i++) {
            LzfRotateLabel label = dayLabels31.get(i);
            if (showDays[0]) {
                if (i % 2 == 0) {
                    label.setVisible(true);
                } else {
                    label.setVisible(false);
                }
            } else {
                label.setVisible(false);
            }
            label.setText(days31.get(i));
        }
        //30天
        if (showDays[1]) {
            temp.clear();
            temp.addAll(days30.subList(days30.indexOf(getNumber(day) + "号"), days30.size()));
            temp.addAll(days30.subList(0, days30.indexOf(getNumber(day) + "号")));
            days30.clear();
            days30.addAll(temp);
        } else {
            String last = days30.get(days30.size() - 1);
            days30.add(0, last);
            days30.add(0, last);
            days30.remove(days30.size() - 1);
            days30.remove(days30.size() - 1);
        }
        for (int i = 0; i < dayLabels30.size(); i++) {
            LzfRotateLabel label = dayLabels30.get(i);
            if (showDays[1]) {
                if (i % 2 == 0) {
                    label.setVisible(true);
                } else {
                    label.setVisible(false);
                }
            } else {
                label.setVisible(false);
            }
            label.setText(days30.get(i));
        }
        //29天
        if (showDays[2]) {
            temp.clear();
            temp.addAll(days29.subList(days29.indexOf(getNumber(day) + "号"), days29.size()));
            temp.addAll(days29.subList(0, days29.indexOf(getNumber(day) + "号")));
            days29.clear();
            days29.addAll(temp);
        } else {
            String last = days29.get(days29.size() - 1);
            days29.add(0, last);
            days29.add(0, last);
            days29.remove(days29.size() - 1);
            days29.remove(days29.size() - 1);
        }
        for (int i = 0; i < dayLabels29.size(); i++) {
            LzfRotateLabel label = dayLabels29.get(i);
            if (showDays[2]) {
                if (i % 2 == 0) {
                    label.setVisible(true);
                } else {
                    label.setVisible(false);
                }
            } else {
                label.setVisible(false);
            }
            label.setText(days29.get(i));
        }
        //28天
        if (showDays[3]) {
            temp.clear();
            temp.addAll(days28.subList(days28.indexOf(getNumber(day) + "号"), days28.size()));
            temp.addAll(days28.subList(0, days28.indexOf(getNumber(day) + "号")));
            days28.clear();
            days28.addAll(temp);
        } else {
            String last = days28.get(days28.size() - 1);
            days28.add(0, last);
            days28.add(0, last);
            days28.remove(days28.size() - 1);
            days28.remove(days28.size() - 1);
        }
        for (int i = 0; i < dayLabels28.size(); i++) {
            LzfRotateLabel label = dayLabels28.get(i);
            if (showDays[3]) {
                if (i % 2 == 0) {
                    label.setVisible(true);
                } else {
                    label.setVisible(false);
                }
            } else {
                label.setVisible(false);
            }
            label.setText(days28.get(i));
        }
        //月
        temp.clear();
        temp.addAll(months.subList(months.indexOf(getNumber(month) + "月"), months.size()));
        temp.addAll(months.subList(0, months.indexOf(getNumber(month) + "月")));
        months.clear();
        months.addAll(temp);
        for (int i = 0; i < monthLabels.size(); i++) {
            LzfRotateLabel label = monthLabels.get(i);
            if (i % 2 == 0) {
                label.setVisible(true);
            } else {
                label.setVisible(false);
            }
            label.setText(temp.get(i));
        }
        yearLabel.setText(getNumber(year) + "年");
        yearLabel.updateUI();
    }
}
