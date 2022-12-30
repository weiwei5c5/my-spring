package cn.ckw.springframework.core.io;

import cn.hutool.core.lang.Assert;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName DefaultResourceLoader.java
 * @Description
 * @createTime 2022年12月29日 16:41:00
 */
public class DefaultResourceLoader implements ResourceLoader{
    /**
     * 判断是否为ClassPath、URL以及文件。
     * @param location
     * @return
     */
    @Override
    public Resource getResource(String location) {
        Assert.notNull(location, "Location must not be null");

        if (location.startsWith(CLASSPATH_URL_PREFIX)){
            return new ClassPathResource(location.substring(CLASSPATH_URL_PREFIX.length()));
        }else{

            try {
                URL url = new URL(location);
                return new UrlResource(url);
            }catch (MalformedURLException e) {
                return new FileSystemResource(location);
            }
        }


    }
}
