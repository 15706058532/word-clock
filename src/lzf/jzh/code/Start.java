package lzf.jzh.code;

import lzf.jzh.code.music.MusicPlayer;
import lzf.jzh.resource.Resource;

import java.io.IOException;
import java.net.URL;

/**
 * 流程控制类
 * Created in 2018-05-19 14:15
 *
 * @author Li Zhenfeng
 */
public class Start {
    /**
     * 启动程序的入口
     */
    public static void main(String[] args) {
        new Start().process();
    }

    /**
     * 流程都在此处控制
     */
    private void process() {
        //初始化组件
        Function.init();
        //启动音乐
        URL resource = Resource.getResourceURL(Constant.MUSIC_PATH_1);
        try {
            MusicPlayer.backPlay(resource.openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        //初始显示
        Function.showInit();
        //依次显示外圈
        Function.roundShow();
        //校准时间
        Function.calibration();
        //旋转
        Function.rotate();
    }
}
