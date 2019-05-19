package lzf.jzh.resource;

import java.net.URL;

/**
 * 资源文件
 * Created in 2018-07-28 10:04
 *
 * @author Li Zhenfeng
 */
public class Resource {
    /**
     * 获取资源文件
     *
     * @param path
     * @return
     */
    public static URL getResourceURL(String path) {
        return Resource.class.getResource(path);
    }
}
