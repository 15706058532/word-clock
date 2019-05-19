package lzf.jzh.code.music;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import lzf.jzh.code.Utils;

import java.io.InputStream;

/**
 * 音乐播放类
 * Created in 2018-05-03 23:25
 *
 * @author Li Zhenfeng
 */
public class MusicPlayer {
    Player player;

    /**
     * 构造方法  参数是一个.mp3音频文件
     */
    public MusicPlayer(InputStream inputStream) {
        try {
            player = new Player(inputStream);
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

    //播放方法
    public void play() throws JavaLayerException {
        player.play();
    }

    public static void backPlay(InputStream inputStream) {
        MusicPlayer musicPlayer = new MusicPlayer(inputStream);
        Utils.getExecutor().execute(() -> {
            try {
                musicPlayer.play();
            } catch (JavaLayerException e) {
                e.printStackTrace();
            }
        });
    }
}