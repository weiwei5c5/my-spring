package cn.ckw.springframework.core.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Chenkunwei
 * @version 1.0.0
 * @ClassName FileSystemResource.java
 * @Description
 * @createTime 2022年12月29日 16:17:00
 */
public class FileSystemResource implements Resource{

    private final File file;

    private final String path;

    public FileSystemResource(File file) {
        this.file = file;
        this.path = file.getPath();
    }

    public FileSystemResource(String path) {
        this.file = new File(path);
        this.path = path;
    }

    public final String getPath() {
        return this.path;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }
}
